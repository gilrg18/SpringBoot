package com.gil.jpa.proyect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.gil.jpa.proyect.entity.User;
import com.gil.jpa.proyect.service.UserDAOService;

//I would like it to be managed by spring so @Component
@Component
public class UserDAOServiceCommandLineRunner implements CommandLineRunner{
	
	//log the id that was created
	private static final Logger log = LoggerFactory.getLogger(UserDAOServiceCommandLineRunner.class);

	@Autowired
	private UserDAOService userDaoService;
	
	@Override
	public void run(String... args) throws Exception {
		//save the user
		User user = new User("Gil","Admin");
		long insert = userDaoService.insert(user);
		//log the id that was created
		log.info("New User created : " + user);
		
	}

}
