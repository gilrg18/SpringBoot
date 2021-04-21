package com.spring.basics.springinsomesteps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//I want to tell that BinarySearchImpl is a bean? how? with "@Component" annotation
@Component
public class BinarySearchImpl { // impl stands for implementation
	// *figure 1*
	//How do i tell spring this is a dependency? with "@Autowired" annotation
	//Now im telling BinarySearchImpl depends on SortAlgorithm. SortAlgorithm is a dependency for BinarySearchImpl
	@Autowired
	private SortAlgorithm sortAlgorithm;

	
	/*public BinarySearchImpl(SortAlgorithm sortAlgorithm) {
		super();
		this.sortAlgorithm = sortAlgorithm;
	}*/
	//Instead of using constructor we'll use Setter Injection
	/*public void setSortAlgorithm(SortAlgorithm sortAlgorithm) {
		this.sortAlgorithm = sortAlgorithm;
	}*/

	public int binarySearch(int[] numbers, int numberToSearchFor) {
		// Sorting an array (bubble sort or quick sort)
		// *Bubble Sort or quick sort implementation goes here*
		// This logic of BinarySearch is tightly coupled to the bubble or quick sort
		// sort algorithm
		// what it means is that if you change the algorithm, you need to change the
		// core of the binary search
		// sometimes i want to use quick sort and sometimes bubble sort, how to make
		// them loosely coupled?
		// we can implement the bubble sort outside this search and make a new object of
		// it
		// BubbleSortAlgorithm bubbleSortAlgorithm = new BubbleSortAlgorithm();
		// int[] sortedNumbers = bubbleSortAlgorithm.sort(numbers);
		// Now i would like to switch between bubble and quicksort DYNAMICALLY
		// I want the BinarySearch to be more loosely coupled, i want to be able to pass
		// in the sort algorithm, how? interface *figure 1*.
		// When you hear people making applications loosely coupled, this is what theyre talking about (interfaces)
		// now the program uses sort algorithm:
		int[] sortedNumbers = sortAlgorithm.sort(numbers);
		// print algorithm that is being used:
		System.out.println("Sort algorithm: " + sortAlgorithm);
		// Search the array
		// Return the position
		return 3;

	}

}
