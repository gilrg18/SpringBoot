package com.gil.jpa.proyect;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.gil.jpa.proyect.entity.User;
import com.gil.jpa.proyect.service.UserDAOService;
import com.gil.jpa.proyect.service.UserRepository;

//I would like it to be managed by spring so @Component
@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner {

	// log the id that was created
	private static final Logger log = LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class);

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		// save the user
		User user = new User("Laura", "Admin");
		// wether u want to update or insert u use .save()
		userRepository.save(user);
		log.info("New User created : " + user);
		Optional<User> userWithIdOne = userRepository.findById(1L);
		// log the id that was created
		log.info("User is retrieved: " + userWithIdOne);
		List<User> users = userRepository.findAll();
		log.info("All Users: " + users);
		
	
	}

}
