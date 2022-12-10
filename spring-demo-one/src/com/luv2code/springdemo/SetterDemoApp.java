package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		
		//load the spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve bean from spring container
		CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);
		
		//call methods on the bean
			// let's come back to this later to check on diagnostic messages...
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
		
		//call new methods with emails and teams
		System.out.println(theCoach.getEmailAddress());
		
		System.out.println(theCoach.getTeam());
		
		
		// -------------------------------------------------------------------
		// Practical 2 - build your own injection
		SwimmingCoach theSwimCoach = context.getBean("mySwimmingCoach", SwimmingCoach.class);
		
		System.out.println(theSwimCoach.getDailyWorkout());
		System.out.println(theSwimCoach.getDailyFortune());
		
		//close the context
		context.close();

	}

}







