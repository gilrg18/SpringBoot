package com.gil.rest.webservices.restfulwebservices.user;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

//ApiModel to add description to swagger
@ApiModel(description="User details")
public class User {

	private Integer id;	
	//Adding a validation to name so it requires at least some length
	@Size(min=2, message="Name should have at least 2 characters")
	//ApiModelProperty to add notes to the swagger
	@ApiModelProperty(notes="Name should have at least 2 characters")
	private String name;
	//Adding a validation so date can only be in the past, not in the future
	@Past
	@ApiModelProperty(notes="birthDate must be in the past")
	private Date birthDate;

	public User(Integer id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}

}
