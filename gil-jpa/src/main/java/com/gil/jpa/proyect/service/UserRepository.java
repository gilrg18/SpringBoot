package com.gil.jpa.proyect.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gil.jpa.proyect.entity.User;
//jparepository<class, primarykey of that class>
public interface UserRepository extends JpaRepository<User, Long>{

}
