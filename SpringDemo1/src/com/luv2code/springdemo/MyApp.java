package com.luv2code.springdemo;

import java.util.Enumeration;
import java.util.Vector;

public class MyApp {
	public static void main(String[] args) {
/*		Coach theCoach = new BaseballCoach();
		System.out.println(theCoach.getDailyWorkout());*/
		
		System.out.println(128>>4);
		
		int [] old = {3,5,7,9};
		int [] new1 = {2,4,6,8,9,7,5,3};
		System.arraycopy(old,  0,  new1, 0, old.length);
		
		for(int i=0;i<new1.length;i++) {
			System.out.println(new1[i]);
		}
		
		System.out.println(Math.ceil(-82.4));
		System.out.println(Math.pow(-6, 2));
		
		Vector<String> vector = new Vector<String>();
		
		vector.addElement("st1");
		vector.addElement("st2");
		vector.addElement("st3");
		vector.addElement("st4");
		
		Enumeration<String> enumeration = vector.elements();
		
		while(enumeration.hasMoreElements()) {
			System.out.println(enumeration.nextElement());
		}
	}
}
