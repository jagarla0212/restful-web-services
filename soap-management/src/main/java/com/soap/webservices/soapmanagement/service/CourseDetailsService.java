package com.soap.webservices.soapmanagement.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.soap.webservices.soapmanagement.bean.Course;

@Component
public class CourseDetailsService {
	public enum StatusEnum {
		SUCCESS, FAIL
	}
	private static List<Course> courses = new ArrayList<>();
	
	static {
		courses.add( new Course(1,"spring 1", "spring with WS"));
		courses.add( new Course(2,"spring 2", "spring with RS"));
		courses.add( new Course(3,"spring 3", "spring boot"));
	}
	
	public Course getById(int id) {
		
		for(Course course:courses) {
			if(course.getId() == id) {
				return course;
			}
		}
		return null;
		
	}
	
	public List<Course> getAll(){
		return courses;
	}
	
	public StatusEnum deleteById(int id) {
		Iterator<Course> iterator = courses.iterator();
		
		while(iterator.hasNext()) {
			Course course = iterator.next();
			if(course.getId() == id) {
				iterator.remove();
				return StatusEnum.SUCCESS;
			}
		}
		
		return StatusEnum.FAIL;
	}

}