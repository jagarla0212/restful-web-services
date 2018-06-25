package com.springboot.rest.RestWithSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class RestWithSpringBootApplication {

	public static void main(String[] args) {
		ApplicationContext appContext = SpringApplication.run(RestWithSpringBootApplication.class, args);
		
		/*for(String beanName : appContext.getBeanDefinitionNames()) {
			System.out.println(beanName);
		}*/
	}
}