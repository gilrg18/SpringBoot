package com.springboot.basics.springbootin10steps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SpringbootIn10StepsApplication {

	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(SpringbootIn10StepsApplication.class, args);
		//get all the beans that are present in the application context ac
		//for(String name : ac.getBeanDefinitionNames()) {
			//System.out.println(name);
		//}
	}

}
