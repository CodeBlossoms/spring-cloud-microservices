package com.ggk.sixt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ggk.sixt.Repository.CarRepo;
import com.ggk.sixt.vo.Car;


@RestController
@RequestMapping("/cars")
public class CarController {

	@Autowired
	CarRepo carRepo;
	
	@RequestMapping("/{carId}")
	public Car getcar(@PathVariable int carId){
		return carRepo.findOne(carId);
	}
	
	@RequestMapping
	public List<Car> getCars(){
		List<Car> cars = new ArrayList<>();
		carRepo.findAll().forEach(car -> cars.add(car));
		
		return cars;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void insertCar(@RequestBody Car car){
		carRepo.save(car);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void updateCar(@RequestBody Car car){
		carRepo.save(car);
	}
	
	@RequestMapping(value = "/{carId}",method = RequestMethod.DELETE)
	public void deleteCar(@PathVariable int carId){
		carRepo.delete(carId);
	}
}
