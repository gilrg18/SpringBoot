package com.soap.webservices.soapcoursemanagement.soap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.gil.courses.CourseDetails;
import com.gil.courses.DeleteCourseDetailsRequest;
import com.gil.courses.DeleteCourseDetailsResponse;
import com.gil.courses.GetAllCourseDetailsRequest;
import com.gil.courses.GetAllCourseDetailsResponse;
import com.gil.courses.GetCourseDetailsRequest;
import com.gil.courses.GetCourseDetailsResponse;
import com.gil.courses.Status;
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
		
		return mapCourseDetails(course);
		// response is java which needs to be converted back to xml, use
		// @ResponsePayload
	}

	@PayloadRoot(namespace = "http://gil.com/courses", localPart = "GetAllCourseDetailsRequest")
	@ResponsePayload
	public GetAllCourseDetailsResponse processAllCourseDetailsRequest(@RequestPayload GetAllCourseDetailsRequest request) {

		List<Course> courses= service.findAll();
		
		return mapAllCourseDetails(courses);
	}
	
	@PayloadRoot(namespace = "http://gil.com/courses", localPart = "DeleteCourseDetailsRequest")
	@ResponsePayload
	public DeleteCourseDetailsResponse deleteCourseDetailsRequest(@RequestPayload DeleteCourseDetailsRequest request) {
		//map the service enum status to the class status in com.gil.courses
		com.soap.webservices.soapcoursemanagement.soap.service.CourseDetailsService.Status status = service.deleteById(request.getId());
		
		DeleteCourseDetailsResponse response = new DeleteCourseDetailsResponse();
		//map the status to the status class
		response.setStatus(mapStatus(status));
		return response;
	}
	
	//Status is the class (bean) in com.gil.courses package
	private com.gil.courses.Status mapStatus(com.soap.webservices.soapcoursemanagement.soap.service.CourseDetailsService.Status status) {
		// TODO Auto-generated method stub
		if(status == com.soap.webservices.soapcoursemanagement.soap.service.CourseDetailsService.Status.FAILURE)
			return com.gil.courses.Status.FAILURE;
		return com.gil.courses.Status.SUCCESS;
	}

	private GetCourseDetailsResponse mapCourseDetails(Course course) {
		GetCourseDetailsResponse response = new GetCourseDetailsResponse();

		response.setCourseDetails(mapCourse(course));

		return response;
	}
	
	private GetAllCourseDetailsResponse mapAllCourseDetails(List<Course> courses) {
		GetAllCourseDetailsResponse response = new GetAllCourseDetailsResponse();
		for(Course course: courses) {
			CourseDetails mapCourse = mapCourse(course);
			response.getCourseDetails().add(mapCourse);
		}

		return response;
	}
	
	
	

	private CourseDetails mapCourse(Course course) {
		CourseDetails courseDetails = new CourseDetails();
		
		courseDetails.setId(course.getId());
		
		courseDetails.setName(course.getName());
		
		courseDetails.setDescription(course.getDescription());
		return courseDetails;
	}
}
