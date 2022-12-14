package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PracticeHelloSpringApp {

	public static void main(String[] args) {
		
		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve bean from spring container
		Coach theSwimCoach = context.getBean("mySwimmingCoach", Coach.class);
		
		// call methods on the bean
		System.out.println(theSwimCoach.getDailyWorkout()); // Run a hard 5k; if it is the correct
		
		//let's call our new method for fortunes
		System.out.println(theSwimCoach.getDailyFortune()); //Today is your lucky day!
		
		// close the context
		context.close();

	}

}
;