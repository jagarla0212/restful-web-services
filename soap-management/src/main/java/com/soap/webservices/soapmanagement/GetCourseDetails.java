package com.soap.webservices.soapmanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.soap.webservices.soapmanagement.bean.Course;
import com.soap.webservices.soapmanagement.exceptions.CourseNotFoundException;
import com.soap.webservices.soapmanagement.service.CourseDetailsService;

import com.springwebservice.courses.CourseDetailsType;
import com.springwebservice.courses.DeleteCourseRequest;
import com.springwebservice.courses.DeleteCourseResponse;
import com.springwebservice.courses.GetAllCourseDetailsRequest;
import com.springwebservice.courses.GetAllCourseDetailsResponse;
import com.springwebservice.courses.GetCourseDetailsRequest;
import com.springwebservice.courses.GetCourseDetailsResponse;
import com.springwebservice.courses.StatusType;

@Endpoint
public class GetCourseDetails {

	@Autowired
	CourseDetailsService courseDetailsService;
	
	@PayloadRoot(namespace="http://springwebservice.com/courses", localPart="GetCourseDetailsRequest")
	@ResponsePayload
	public GetCourseDetailsResponse processCourseDetails(@RequestPayload GetCourseDetailsRequest request) {
		
		Course course = courseDetailsService.getById(request.getId());
		if( null == course) {
			throw new CourseNotFoundException("Invalid course id" + request.getId());
		}
		GetCourseDetailsResponse response = null;
		response = new GetCourseDetailsResponse();
		response.setCourseDetails(mapCourse(course));
		return response;
	}

	
	@PayloadRoot(namespace="http://springwebservice.com/courses", localPart="GetAllCourseDetailsRequest")
	@ResponsePayload
	public GetAllCourseDetailsResponse processAllCourseDetails(@RequestPayload GetAllCourseDetailsRequest request) {
		return mapAllCourses();
	}
	
	@PayloadRoot(namespace="http://springwebservice.com/courses", localPart="DeleteCourseRequest")
	@ResponsePayload
	public DeleteCourseResponse deleteCourseDetails(@RequestPayload DeleteCourseRequest request) {
		DeleteCourseResponse response = new DeleteCourseResponse();
		
		if(CourseDetailsService.StatusEnum.SUCCESS == courseDetailsService.deleteById(request.getId())) {
		
		response.setStatus(StatusType.SUCCESS);
		}
		else {
			response.setStatus(StatusType.FAIL);
		}
		return response;
	}
	
	private GetAllCourseDetailsResponse mapAllCourses() {
		List<Course> courses = courseDetailsService.getAll();
		GetAllCourseDetailsResponse response = new GetAllCourseDetailsResponse();
		for(Course course: courses) {
			response.getCourseDetails().add(mapCourse(course));
		}
		
		return response;
	}


	private CourseDetailsType mapCourse(Course course) {
		
		CourseDetailsType courseType = null;
		if( null != course) {
			 courseType = new CourseDetailsType();
			courseType.setId(course.getId());
			courseType.setName(course.getName());
			courseType.setDescription(course.getDescription());			
		}
		return courseType;
	}
}
