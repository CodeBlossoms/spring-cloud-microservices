package com.ggk.sixt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ggk.sixt.feignClients.UserServiceFeignClient;
import com.ggk.sixt.repository.OrdersRepo;
import com.ggk.sixt.vo.Car;
import com.ggk.sixt.vo.CarOrder;
import com.ggk.sixt.vo.User;


@RestController
//@RequestMapping("/orders")
public class OrdersController {
	
	private final String _carServiceUrl = "http://car-service";
	private final String _userServiceUrl = "http://user-service";

	@Autowired
	OrdersRepo carOrdersRepo;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	UserServiceFeignClient userServiceFeignClient;
	
	@RequestMapping("/{orderId}")
	public CarOrder getOrder(@PathVariable int orderId){
		return carOrdersRepo.findOne(orderId);
	}
	
	@RequestMapping
	public List<CarOrder> getOrdersByUser(@RequestParam int userId){
		System.out.println(userId);
		List<CarOrder> orders = new ArrayList<>();
		carOrdersRepo.findOrdersByUser(userId).forEach(order -> orders.add(order));
		
		return orders;
	}
	
	@RequestMapping("/all")
	public List<CarOrder> getOrders(){
		
		List<CarOrder> orders = new ArrayList<>();
		carOrdersRepo.findAll().forEach(order -> orders.add(order));
		
		return orders;
	}
	
	@RequestMapping(value = "{userId}/rent-a-car/{carId}" ,method = RequestMethod.POST)
	public void rentACar(@PathVariable int userId, @PathVariable int carId){
		//validate user is customer
		//User user = restTemplate.getForObject(_userServiceUrl+"/users/"+userId, User.class);
		
		User user = userServiceFeignClient.getUser(userId);
		
		if(user==null)
			throw new RuntimeException("Sorry we dont know you, we cannot rent you a car ");
		
		System.out.println(user.getName());
		
		if(!user.getRole().equals("customer"))
			throw new RuntimeException("Sorry we can rent our cars only to customers");
		
		CarOrder carOrder = new CarOrder();
		carOrder.setUserId(userId);
		carOrder.setCarId(carId);
		carOrdersRepo.save(carOrder);
	}
	
	@RequestMapping(value = "{adminId}/car-rent-approve/{orderId}" ,method = RequestMethod.PUT)
	public void carRentApprove(@PathVariable int adminId, @PathVariable int orderId){
		
		//validate if user is admin
		User user = restTemplate.getForObject(_userServiceUrl+"/users/"+adminId, User.class);
		if(user==null)
			throw new RuntimeException("Sorry we dont know you");
		
		if(!user.getRole().equals("admin"))
			throw new RuntimeException("Car rental can be approved Only by admin ");
		
		CarOrder carOrder = carOrdersRepo.findOne(orderId);
		if(carOrder == null)
			throw new RuntimeException("invalid order");
		
		carOrder.setCarRentApproved(true);
		
		carOrdersRepo.save(carOrder);
	}
	
	@RequestMapping(value = "{userId}/return-a-car/{orderId}" ,method = RequestMethod.PUT)
	public void returnACar(@PathVariable int userId, @PathVariable int orderId){
		//validate user is customer
		User user = restTemplate.getForObject(_userServiceUrl+"/users/"+userId, User.class);
		if(user==null)
			throw new RuntimeException("Sorry we dont know you, we cannot take your request");
		
		CarOrder carOrder = carOrdersRepo.findOne(orderId);
		if(carOrder == null)
			throw new RuntimeException("invalid order");

		if(!carOrder.isCarRentApproved())
			throw new RuntimeException("you cannot return car without requesting it");
		
		carOrder.setCarReturnReceived(true);
		
		carOrdersRepo.save(carOrder);
	}
	
	@RequestMapping(value = "{adminId}/car-return-approve/{orderId}" ,method = RequestMethod.PUT)
	public void carReturnApprove(@PathVariable int adminId, @PathVariable int orderId){
		//validate if user is admin
		User user = restTemplate.getForObject(_userServiceUrl+"/users/"+adminId, User.class);
		if(user==null)
			throw new RuntimeException("Sorry we dont know you");
		
		if(!user.getRole().equals("admin"))
			throw new RuntimeException("Rental Car can be approved Only by admin ");
		
		CarOrder carOrder = carOrdersRepo.findOne(orderId);
		if(carOrder == null)
			throw new RuntimeException("invalid order");

		//validate car 
		Car car = restTemplate.getForObject(_carServiceUrl+"/cars/"+carOrder.getCarId() , Car.class);
		if(car==null)
			throw new RuntimeException("invalid Car, cannot return it");

		carOrder.setCarReturnApproved(true);
		
		carOrdersRepo.save(carOrder);
	}
	
	
}
