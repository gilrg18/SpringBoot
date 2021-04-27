package com.gil.rest.webservices.restfulwebservices;

import org.springframework.web.bind.annotation.GetMapping;
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
}
