package com.test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


@Path("/hello")
public class Hello {

	/*@GET
	@Produces(MediaType.TEXT_XML)
	public String sayHello() {
		String resource = "<?xml version=\"1.0\"?>" +
					"<hello> Hello from XML </hello>";
		return resource;
		
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String sayHelloJason() {
		return null;
	}
	*/
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHellHtml(@QueryParam("name") String name, @QueryParam("card_no") String card_no, @QueryParam("amount") double amount) {
		
		System.out.println("Name : " + name);
		System.out.println("Amount : " + amount);
		String resource = "<h1> Hello from HTML</h1>";
		if( amount > 1000 ) {
			resource = "Credit Card is not Approved";
		}
		else {
			resource = "Credit Card is Approved";
		}
		String returnString = "<html>" + "<title> Credit Card Authorization</title>" + "<body><h1>"+ name +": "+ resource +"</h1></body>" + "</html>";
		return returnString;
	}
}
