package com.restful.webservices.restful.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

	@Autowired
	UserDaoService service = new UserDaoService();
		
	@GetMapping(path="/users")
	public List<User> retreiveAllUsers() {
		return service.findAll();
	}
	
	@GetMapping(path="/users/{id}")
	public User retreiveUser(@PathVariable int id) {
		return service.findOne(id);
	}
}
