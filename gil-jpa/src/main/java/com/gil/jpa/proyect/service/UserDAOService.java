package com.gil.jpa.proyect.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.gil.jpa.proyect.entity.User;

//Indicates that interacts with the database @Repository
@Repository
@Transactional
public class UserDAOService {
	@PersistenceContext
	private EntityManager entityManager;

	/*
	 * Instead of implementing transaction management in each method, what JPA
	 * provides is a simple interface to do declarative transaction management.
	 * 
	 * @Transactional can be used in the class or the method
	 */
	public long insert(User user) {
		// Open Transaction
		// Only those things which are in the persistence context (.persist()) are
		// tracked by the entityManager
		entityManager.persist(user);
		// Close Transaction
		return user.getId();
	}

	/*
	 * Spring Data JPA
	 * What Spring data says, you just define your interfaces you.
	 * Define your repository interfaces and I will take care of implementing them.
	 * So if I want to just do a user dao service, instead of that I can create a
	 * simple repository with a small method in the interface and Spring data says,
	 * I'll provide the implementation for you.
	 */
}
