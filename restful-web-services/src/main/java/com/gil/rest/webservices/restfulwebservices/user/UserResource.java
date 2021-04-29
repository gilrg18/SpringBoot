package com.gil.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gil.rest.webservices.restfulwebservices.exception.UserNotFoundException;

@RestController
public class UserResource {

	@Autowired
	UserDaoService service;

	// GET /users
	// retrieveAllUsers
	@GetMapping("/users")
	//public List<User> retrieveAllUsers() {
	public CollectionModel<User> retrieveAllUsers(){
		//return service.findAll();
		List<User> users = service.findAll();
		CollectionModel<User> resource = CollectionModel.of(users);
		
		for(User user: users) {
			//Link you want to use (retrieveAllUsers)
			WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveUser(user.getId()));
			//Name of the link you want to use ("all-users")
			resource.add(linkTo.withRel("user "+user.getId()));
		}
		
		return resource;
	}

	// retrieveUser(int id)
	// code 200 means succesfull
	@GetMapping("/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id) {
		User user = service.findOne(id);
		if (user == null) {
			throw new UserNotFoundException("id-" + id);
		}
		// HATEOAS
		// "all-users", SERVER_PATH + "/users"
		// retrieveAllUsers
		EntityModel<User> resource = EntityModel.of(user);
		//Link you want to use (retrieveAllUsers)
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		//Name of the link you want to use ("all-users")
		resource.add(linkTo.withRel("all-users"));
		return resource;
	}

	@DeleteMapping("/users/{id}")
	public User deleteUser(@PathVariable int id) {
		User user = service.deleteById(id);
		if (user == null) {
			throw new UserNotFoundException("id-" + id);
		}
		return user;
	}

	// input - details of user
	// output - CREATED code and return the cretaed URI
	// with RequestBody whatever is mapped to the body of the request will
	// be mapped to the method parameter (User user)
	// we need a rest client to do post requests (POSTMAN)
	@PostMapping("/users")
	// Enable validation on specific user with @Valid
	public ResponseEntity<Object> createdUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);
		// return the URI /user/{id} -> /user/savedUser.getId()
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		// return status of CREATED
		return ResponseEntity.created(location).build();
	}
}
