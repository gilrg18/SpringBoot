package com.spring.basics.springinsomesteps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringInSomeStepsApplication {

	public static void main(String[] args) {
		//To use BinarySearchImpl 
		//The result is not important, what we try to understand here is the concept
		//of loose coupling
		//With interfaces, we can dynamically choose our sort algorithm for the binary search, thus making use of loose coupling
		//We can now use BinarySearchImpl independently of which sort algorithm is being used
		//the sort algorithms are dependencies of BinarySearchImpl, so BinarySearchImpl depends on the sort algorithm
		//Now that i know what loosely coupled and dependencies mean, i can use Spring to make this example even better.
		BinarySearchImpl binarySearch = new BinarySearchImpl(new BubbleSortAlgorithm());
		int result = binarySearch.binarySearch(new int[] {12,4,6}, 3);
		System.out.println(result);
		BinarySearchImpl binarySearch2 = new BinarySearchImpl(new QuickSortAlgorithm());
		int result2 = binarySearch2.binarySearch(new int[] {12,4,6}, 3);
		System.out.println(result2);
		SpringApplication.run(SpringInSomeStepsApplication.class, args);
	}

}
