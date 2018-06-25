package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringHelloApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach myCoach = context.getBean("myCoach", Coach.class);
		
		System.out.println(myCoach.getDailyWorkout());
		
		context.close();
	
		
		
	}
}
