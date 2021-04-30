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
	 * @Transactional can be used in the class or the method
	 */
	public long insert(User user) {
		// Open Transaction
		//Only those things which are in the persistence context (.persist()) are tracked by the entityManager 
		entityManager.persist(user);
		// Close Transaction
		return user.getId();
	}
}
