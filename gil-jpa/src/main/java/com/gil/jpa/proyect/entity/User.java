package com.gil.jpa.proyect.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//Map it to a Table called User

@Entity
public class User {
	
	//Primary key id with @Id
	@Id
	//I dont want to asign the primary key
	//I want it to be generated with @Generated Value
	@GeneratedValue
	private long id;
	private String name;
	private String role;
	
	//jpa expects a simple default constructor
	protected User() {
		
	}

	public User(long id, String name, String role) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getRole() {
		return role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", role=" + role + "]";
	}

}
