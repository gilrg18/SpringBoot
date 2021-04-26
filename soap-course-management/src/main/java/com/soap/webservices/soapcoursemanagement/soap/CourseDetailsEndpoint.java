package com.soap.webservices.soapcoursemanagement.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.gil.courses.CourseDetails;
import com.gil.courses.GetCourseDetailsRequest;
import com.gil.courses.GetCourseDetailsResponse;
import com.soap.webservices.soapcoursemanagement.soap.bean.Course;
import com.soap.webservices.soapcoursemanagement.soap.service.CourseDetailsService;

@Endpoint
public class CourseDetailsEndpoint {

	// with autowired im telling that this CourseDetailsEndpoint depends on the
	// CourseDetailsService,
	// so the service is a dependency of the endpoint
	@Autowired
	CourseDetailsService service;
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

		Course course = service.findById(request.getId());
		
		return mapCourse(course);
		// response is java which needs to be converted back to xml, use
		// @ResponsePayload
	}

	private GetCourseDetailsResponse mapCourse(Course course) {
		
		GetCourseDetailsResponse response = new GetCourseDetailsResponse();

		CourseDetails courseDetails = new CourseDetails();
		
		courseDetails.setId(course.getId());
		
		courseDetails.setName(course.getName());
		
		courseDetails.setDescription(course.getDescription());

		response.setCourseDetails(courseDetails);

		return response;
	}
}
