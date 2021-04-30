package com.gil.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {
	
	@GetMapping("/v1/person")
	public PersonV1 personV1() {
		return new PersonV1("Gilberto");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 personV2() {
		return new PersonV2(new Name("Gilberto","Rogel"));
	}
	
	//Another option of doing versioning. Using params
	@GetMapping(value="/person/param", params="version=1")
	public PersonV1 paramV1() {
		return new PersonV1("Gilberto");
	}
	
	@GetMapping(value="/person/param", params="version=2")
	public PersonV2 paramV2() {
		return new PersonV2(new Name("Gilberto","Rogel"));
	}
	
	//Another option of doing versioning. Using produces
	//we are now not using application/json
	//we are now appending vnd.ourcompany.app-version+jason
	@GetMapping(value="/person/produces", produces="application/vnd.company.app-v1+json")
	public PersonV1 headerV1() {
		return new PersonV1("Gilberto");
	}
	
	@GetMapping(value="/person/produces", produces="application/vnd.company.app-v2+json")
	public PersonV2 headerV2() {
		return new PersonV2(new Name("Gilberto","Rogel"));
	}

	
	
}
