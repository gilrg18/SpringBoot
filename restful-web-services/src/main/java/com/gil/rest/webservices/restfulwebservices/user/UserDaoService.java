package com.gil.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<>();
	// counter to determine id.. 3 current users in our array
	private static int usersCount = 3;
	static {
		users.add(new User(1, "Gil", new Date()));
		users.add(new User(2, "Maik", new Date()));
		users.add(new User(3, "Laura", new Date()));
	}

	public List<User> findAll() {
		return users;
	}

	public User save(User user) {
		if (user.getId() == null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}

	public User findOne(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	/*
	 * So one of the important things is I cannot use the for loop thing because I
	 * cannot delete a user in between
	 * 
	 * a request.
	 * 
	 * One of the option is to create a temporary list and add to it.
	 * 
	 * But rather than that I would use an iterator.
	 */
	public User deleteById(int id) {
		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}

}
