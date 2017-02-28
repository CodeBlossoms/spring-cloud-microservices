package com.ggk.sixt.domainService;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ggk.sixt.vo.User;


public interface UserService {

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public User getUser(@PathVariable("userId") int userId);
	
	@RequestMapping
	public List<User> getUsers();
	
	@RequestMapping(method = RequestMethod.POST)
	public void insertUser(@RequestBody User user);
	
	@RequestMapping(method = RequestMethod.PUT)
	public void updateUser(@RequestBody User user);
	
	@RequestMapping(value = "/{userId}",method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable("userId") int userId);
}
