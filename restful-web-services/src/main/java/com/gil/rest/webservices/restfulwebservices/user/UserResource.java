package com.gil.rest.webservices.restfulwebservices.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {
	
	@Autowired
	UserDaoService service;
	//GET /users
	//retrieveAllUsers
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return service.findAll();
	}
	
	//retrieveUser(int id)
	//code 200 means succesfull
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		return service.findOne(id);
	}
	
	//input - details of user
	//output - CREATED code and return the cretaed URI
	//with RequestBody whatever is mapped to the body of the request will
	//be mapped to the method parameter (User user)
	//we need a rest client to do post requests (POSTMAN)
	@PostMapping("/users")
	public void createdUser(@RequestBody User user) {
		User savedUser = service.save(user);
	}
}
