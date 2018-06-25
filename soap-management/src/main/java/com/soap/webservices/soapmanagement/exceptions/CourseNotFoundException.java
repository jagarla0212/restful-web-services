package com.soap.webservices.soapmanagement.exceptions;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

//@SoapFault(faultCode=FaultCode.CLIENT)
@SoapFault(faultCode=FaultCode.CUSTOM, customFaultCode="{http://springwebservice.com/courses}001_COURSE_NOT_FOUND")
public class CourseNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CourseNotFoundException(String message) {
		super(message);		
	}
	
}
