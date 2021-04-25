package com.soap.webservices.soapcoursemanagement.soap;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;

//Enable Spring Web Services
@EnableWs
//Spring Configuration
@Configuration
public class WebServiceConfig {
	//MessageDispatcherServlet is a servlet which handles all the soap request and identifies endpoints
		//ApplicationContext
	//url -> /ws/* (url to expose all our web services at)
	
	//ServletRegistrationBean helps up map a servlet to a uri
	@Bean
	ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
		//servlet to handle all the requests and mapping a simple uri to it (/ws/*)
		MessageDispatcherServlet mds = new MessageDispatcherServlet();
		mds.setApplicationContext(context);
		mds.setTransformWsdlLocations(true);
		
		return new ServletRegistrationBean(mds, "/ws/*");
	}
}
