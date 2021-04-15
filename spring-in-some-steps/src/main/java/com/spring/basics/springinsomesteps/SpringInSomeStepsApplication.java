package com.spring.basics.springinsomesteps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringInSomeStepsApplication {

	public static void main(String[] args) {
		//To use BinarySearchImpl 
		//The result is not important, what we try to understand here is the concept
		//of loose coupling
		BinarySearchImpl binarySearch = new BinarySearchImpl();
		int result = binarySearch.binarySearch(new int[] {12,4,6}, 3);
		System.out.println(result);
		SpringApplication.run(SpringInSomeStepsApplication.class, args);
	}

}
