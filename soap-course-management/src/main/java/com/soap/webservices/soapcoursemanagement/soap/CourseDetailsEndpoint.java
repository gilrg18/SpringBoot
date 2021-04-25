package com.soap.webservices.soapcoursemanagement.soap;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.gil.courses.CourseDetails;
import com.gil.courses.GetCourseDetailsRequest;
import com.gil.courses.GetCourseDetailsResponse;

@Endpoint
public class CourseDetailsEndpoint {

	// method
	// input - request object (GetCourseDetailsRequest)
	// output - response object (GetCourseDetailsResponse)
	// namespace it supports: http://gil.com/courses
	// name: GetCourseDetailsRequest
	// process a request with that namespace and name with @PayloadRoot
	// @RequestPayload to convert xml to object

	@PayloadRoot(namespace = "http://gil.com/courses", localPart = "GetCourseDetailsRequest")
	@ResponsePayload
	public GetCourseDetailsResponse processCourseDetailsRequest(@RequestPayload GetCourseDetailsRequest request) {

		GetCourseDetailsResponse response = new GetCourseDetailsResponse();
		CourseDetails courseDetails = new CourseDetails();
		courseDetails.setId(request.getId());
		courseDetails.setName("Microservices");
		courseDetails.setDescription("SOAP microservices");
		
		response.setCourseDetails(courseDetails);
		
		return response;
		// response is java which needs to be converted back to xml, use
		// @ResponsePayload
	}
}
