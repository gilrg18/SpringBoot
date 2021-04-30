package com.gil.jpa.proyect;

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
		//wether u want to update or insert u use .save()
		userRepository.save(user);
		// log the id that was created
		log.info("New User created : " + user);

	}

}
