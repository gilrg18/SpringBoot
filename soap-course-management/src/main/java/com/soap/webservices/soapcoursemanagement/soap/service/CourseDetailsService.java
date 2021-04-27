package com.soap.webservices.soapcoursemanagement.soap.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.soap.webservices.soapcoursemanagement.soap.bean.Course;

@Component
public class CourseDetailsService {
	
	public enum Status{
		SUCCESS, FAILURE;
	}

	private static List<Course> courses = new ArrayList<>();

	static {
		Course course1 = new Course(1, "Math 4", "Advanced math class");
		courses.add(course1);

		Course course2 = new Course(2, "Algorithms", "Algorithms analysis and design");
		courses.add(course2);
		
		Course course3 = new Course(3, "Data Structures", "Implementing data structures");
		courses.add(course3);
		
		Course course4 = new Course(4, "Videogame dev", "Videogame development course");
		courses.add(course4);
	}

	// course - 1
	// Course findById(int id)
	public Course findById(int id) {
		for(Course course: courses) {
			if(course.getId()==id) return course;
		}
		return null;
	}
	// courses
	// List<Course> findAll()
	public List<Course> findAll(){
		return courses;
	}
	
	
	// deletecourse
	// int deleteById(int id)
	// returns 1 if delete is successfull, 0 if not
	public Status deleteById(int id) {
		Iterator<Course> iterator = courses.iterator();
		while(iterator.hasNext()) {
			Course course = iterator.next();
			if(course.getId()==id) {
				iterator.remove();
				return Status.SUCCESS;
			}
		}
		return Status.FAILURE;
		
		/*for(Course course: courses) {
			if(course.getId()==id) {
				//this could throw an exception so we need an iterator
				courses.remove(course);
				return 1;
			}
		}
		return 0;
		*/
	}

	// update course & new course
}
