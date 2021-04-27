package com.gil.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//tell spring this is a Controller (meaning it will be handling rest http requests)
@RestController
public class HelloWorldController {
	// GET
	// URI - /hello-world
	// method - "Hello World"
	// map a get request to the URI
	// @RequestMapping(method=RequestMethod.GET, path= "/hello-world")
	// There is another annotation called GetMapping so you dont have to specify the RequestMethod.GET
	//Similar to getMapping there exists putmapping, postmapping and others that we would use.
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	//hello-world-bean, instead of returning a string we want to return a bean
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
	
	
	//hello-world/path-variable/gil   gil will be mapped to the path variable {name}
	@GetMapping(path = "/hello-world-bean/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s", name)); 
	}
		
}
