package com.gil.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
		User user = service.findOne(id);
		if(user==null) {
			throw new UserNotFoundException("id-"+id);
		}
		return user;
	}
	
	//input - details of user
	//output - CREATED code and return the cretaed URI
	//with RequestBody whatever is mapped to the body of the request will
	//be mapped to the method parameter (User user)
	//we need a rest client to do post requests (POSTMAN)
	@PostMapping("/users")
	public ResponseEntity<Object> createdUser(@RequestBody User user) {
		User savedUser = service.save(user);
		// return the URI /user/{id} -> /user/savedUser.getId()
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		//return status of CREATED
		return ResponseEntity.created(location).build();
	}
}
