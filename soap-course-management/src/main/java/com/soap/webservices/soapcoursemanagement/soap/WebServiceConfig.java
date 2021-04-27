package com.soap.webservices.soapcoursemanagement.soap;

import java.util.Collections;
import java.util.List;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.soap.security.xwss.XwsSecurityInterceptor;
import org.springframework.ws.soap.security.xwss.callback.SimplePasswordValidationCallbackHandler;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

//Enable Spring Web Services
@EnableWs
//Spring Configuration
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter{
	//MessageDispatcherServlet is a servlet which handles all the soap request and identifies endpoints
		//ApplicationContext
	//url -> /ws/* (url to expose all our web services at)
	
	//ServletRegistrationBean helps up map a servlet to a uri
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
		//servlet to handle all the requests and mapping a simple uri to it (/ws/*)
		MessageDispatcherServlet mds = new MessageDispatcherServlet();
		mds.setApplicationContext(context);
		mds.setTransformWsdlLocations(true);
		
		return new ServletRegistrationBean(mds, "/ws/*");
	}
	
	//wsdl: /ws/courses.wsdl
	//course-details.xsd
	
	//We want to use below schema in our wsdl definition
	@Bean(name="courses")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema coursesSchema) {
		DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
		//PortType - CoursePort
		definition.setPortTypeName("CoursePort");
		//Namespace - http://gil.com/courses
		definition.setTargetNamespace("http://gil.com/courses");
		// /ws
		definition.setLocationUri("/ws");
		//schema
		definition.setSchema(coursesSchema);
		return definition;
		//this is all the configuration we would need to be able to run our web service.
	}
	
	
	//DEFINE THE SCHEMA
	@Bean
	public XsdSchema coursesSchema() {
		return new SimpleXsdSchema(new ClassPathResource("course-details.xsd"));
	}
	
	//Configure the security
	//Interceptor.add -> XwsSecurityInterceptor
	@Bean 
	public XwsSecurityInterceptor securityInterceptor() {
		//XwsSecurityInterceptor, intercepts all requests to check if theyre secure
		XwsSecurityInterceptor securityInterceptor = new XwsSecurityInterceptor();
		//Callback Handler -> SimplePasswordValidationCallbackHandler (what to do with the requests)
		securityInterceptor.setCallbackHandler(callbackHandler());
		//SecurityPolicy -> securityPolicy.xml
		securityInterceptor.setPolicyConfiguration(new ClassPathResource("securityPolicy.xml"));
		
		return securityInterceptor;
	}
	
	//use the xwss implementation for SimplePasswordValidationCallbackHandler
	@Bean
	public SimplePasswordValidationCallbackHandler callbackHandler() {
		SimplePasswordValidationCallbackHandler handler = new SimplePasswordValidationCallbackHandler();
		//It checks whether the user Id is user and password is password.
		handler.setUsersMap(Collections.singletonMap("user", "password"));
		return handler;
	}

	//overriding from WsConfigureAdapter
	@Override
	public void addInterceptors(List<EndpointInterceptor> interceptors) {
		interceptors.add(securityInterceptor());
	}
}
