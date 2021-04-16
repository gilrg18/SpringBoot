package com.spring.basics.springinsomesteps;

import org.springframework.stereotype.Component;
//@Component to tell spring this is a bean
@Component
public class BubbleSortAlgorithm implements SortAlgorithm{
	//Not really implementing the logic, lets just assume it is implemented...
	public int[] sort(int[] numbers) {
		//logic of bubbleSort
		return numbers;
	}
}
