package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		
		// read spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get the bean from spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
			// section 7: tennisCoach use to be "thatSillyCoach"
		
		//call method from the bean
		System.out.println(theCoach.getDailyWorkout());
		
		// call method for dailyFortune (section 8)
		System.out.println(theCoach.getDailyFortune());
		
		//close context 
		context.close();
		
		// ----------------Practical #4----------------------
//		//read spring config file
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		
//		//get bean from spring container
//		Coach theCoach = context.getBean("codingCoach", Coach.class);
//		
//		//call method from the bean
//		System.out.println(theCoach.getDailyWorkout());
//		
//		//close context
//		context.close();

	}

}
