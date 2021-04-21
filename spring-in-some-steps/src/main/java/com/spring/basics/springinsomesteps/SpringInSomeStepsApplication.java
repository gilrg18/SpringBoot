package com.spring.basics.springinsomesteps;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringInSomeStepsApplication {
	//What are the beans? @Component annotation
	//What are the dependencies of a bean? @Autowired (BinarySearchImpl depends on SortAlgorithm)
	//Where to search for beans? Spring boot will automatically scan the package and subpackages with @SpringBootApplication annotation
	
	
	public static void main(String[] args) {
		//To use BinarySearchImpl 
		//The result is not important, what we try to understand here is the concept
		//of loose coupling
		//With interfaces, we can dynamically choose our sort algorithm for the binary search, thus making use of loose coupling
		//We can now use BinarySearchImpl independently of which sort algorithm is being used
		//the sort algorithms are dependencies of BinarySearchImpl, so BinarySearchImpl depends on the sort algorithm
		//Now that i know what loosely coupled and dependencies mean, i can use Spring to make this example even better.
		//A bean is an instance of this object (new BubbleSortAlgorithm())
		//We want to be able to create the bubble algorithm and wire it in the binary search
		//the spring framework help us manage beans
		//After creating the bubblesortalgorithm bean we can remove the next line:
		//BinarySearchImpl binarySearch = new BinarySearchImpl(new BubbleSortAlgorithm());
		//System.out.println(result);
		//this is another bean (new QuicksortAlgorithm())
		
		//we cant do this now with setter injection..
		/*BinarySearchImpl binarySearch2 = new BinarySearchImpl(new QuickSortAlgorithm());
		int result2 = binarySearch2.binarySearch(new int[] {12,4,6}, 3);
		System.out.println(result2);*/
		
		//Application Context: maintains all the beans
		//The .run method returns the application context: Assign next line to a variable
		//SpringApplication.run(SpringInSomeStepsApplication.class, args);
		ApplicationContext applicationContext = SpringApplication.run(SpringInSomeStepsApplication.class, args);
		//Now we can get the bean from the applicationContext
		BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);
		int result = binarySearch.binarySearch(new int[] {12,4,6}, 3);
		System.out.println(result);
	}

}
