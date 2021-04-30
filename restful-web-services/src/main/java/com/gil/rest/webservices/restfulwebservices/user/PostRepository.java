package com.gil.rest.webservices.restfulwebservices.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//jparepository<entity to be managed, primary key type>
@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

}
