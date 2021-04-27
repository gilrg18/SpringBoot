package com.soap.webservices.soapcoursemanagement.soap.exception;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

//with soapfault we correct the fault of being a server error which it is not because
//this is a client error because the client is giving wrong id
//for client, use FaultCode.CLIENT
//this is a custom fault code
@SoapFault(faultCode = FaultCode.CUSTOM, customFaultCode="{http://gil.com/courses}404_COURSE_NOT_FOUND")
public class CourseNotFoundException extends RuntimeException {


	private static final long serialVersionUID = -180604455581224502L;

	public CourseNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
}
