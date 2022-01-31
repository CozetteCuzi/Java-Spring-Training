package com.restful.webservices.restful.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
		User user = service.findOne(id); 
		if(user == null) 
			throw new UserNotFoundException("id-" + id);
		return user;	
	}
	
	@PostMapping(path="/users")
	public ResponseEntity<Object> saveUser(@RequestBody User user) {
		User savedUser = service.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(savedUser.getId())
		.toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping(path="/users/{id}")
	public void deleteUser(@PathVariable int id) {
		boolean result = service.deleteUser(id);
		if(!result) 
			throw new UserNotFoundException("id-" + id);
	}
}
