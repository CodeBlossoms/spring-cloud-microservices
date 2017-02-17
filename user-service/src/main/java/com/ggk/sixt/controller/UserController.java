package com.ggk.sixt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ggk.sixt.domainService.UserService;
import com.ggk.sixt.repository.UserRepo;
import com.ggk.sixt.vo.User;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
public class UserController implements UserService {

	@Autowired
	UserRepo userRepo;
	
	/*@HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "500")
        })*/
	public User getUser(@PathVariable int userId){
		return userRepo.findOne(userId);
	}
	
	public List<User> getUsers(){
		List<User> users = new ArrayList<>();
		userRepo.findAll().forEach(user -> users.add(user));
		
		return users;
	}
	
	public void insertUser(@RequestBody User user){
		userRepo.save(user);
	}
	
	public void updateUser(@RequestBody User user){
		userRepo.save(user);
	}
	
	public void deleteUser(@PathVariable int userId){
		userRepo.delete(userId);
	}
	
	/*@RequestMapping("/role")
	public List<User> getUsersByRole(@RequestParam String role){
		return userRepo.findByRole(role);
	}*/
}
