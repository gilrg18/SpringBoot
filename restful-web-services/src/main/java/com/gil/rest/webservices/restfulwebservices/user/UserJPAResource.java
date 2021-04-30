package com.gil.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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
public class UserJPAResource {

	@Autowired
	UserDaoService service;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PostRepository postRepository;

	// GET /users
	// retrieveAllUsers
	@GetMapping("/jpa/users")
	// public List<User> retrieveAllUsers() {
	public List<User> retrieveAllUsers() {
		// return service.findAll();
		return userRepository.findAll();
	}

	// retrieveUser(int id)
	// code 200 means succesfull
	@GetMapping("/jpa/users/{id}")
	public EntityModel<Optional<User>> retrieveUser(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("id-" + id);
		}
		EntityModel<Optional<User>> resource = EntityModel.of(user);
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());

		resource.add(linkTo.withRel("all-users"));
		return resource;
	}

	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);
	}

	// input - details of user
	// output - CREATED code and return the cretaed URI
	// with RequestBody whatever is mapped to the body of the request will
	// be mapped to the method parameter (User user)
	// we need a rest client to do post requests (POSTMAN)
	@PostMapping("/jpa/users")
	// Enable validation on specific user with @Valid
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = userRepository.save(user);
		// return the URI /user/{id} -> /user/savedUser.getId()
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		// return status of CREATED
		return ResponseEntity.created(location).build();
	}

	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrievePosts(@PathVariable int id) {
		Optional<User> userOptional = userRepository.findById(id);
		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("id-" + id);
		}
		return userOptional.get().getPosts();
	}

	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPost(@PathVariable int id,@RequestBody Post post) {
		//fetch the user
		Optional<User> userOptional = userRepository.findById(id);
		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("id-" + id);
		}
		//we get the user
		User user = userOptional.get();
		//map the user to the post
		post.setUser(user);
		//save the post to the db
		postRepository.save(post);
		// return the URI /user/{id} -> /user/post.getId()
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId())
				.toUri();
		// return status of CREATED
		return ResponseEntity.created(location).build();
	}

}
