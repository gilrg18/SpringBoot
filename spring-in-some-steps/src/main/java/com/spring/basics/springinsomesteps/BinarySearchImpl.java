package com.spring.basics.springinsomesteps;

public class BinarySearchImpl { //impl stands for implementation
	public int binarySearch(int[] numbers, int numberToSearchFor) {
		//Sorting an array (bubble sort or quick sort)
		//Bubble Sort or quick sort implementation
			//This logic of BinarySearch is tightly coupled to the bubble or quick sort sort algorithm
			//what it means is that if you change the algorithm, you need to change the core of the binary search
			//sometimes i want to use quick sort and sometimes bubble sort, how to make them loosely coupled?
			//we can implement the bubble sort outside this search and make a new object of it
		BubbleSortAlgorithm bubbleSortAlgorithm = new BubbleSortAlgorithm();
		int[] sortedNumbers = bubbleSortAlgorithm.sort(numbers);
		//Now i would like to switch between bubble and quicksort dynamically
		//I want the BinarySearch to be more loosely coupled, i want to be able to pass in the sort algorithm
		//Search the array
		//Return the position	
		return 3;
		
	}

}
