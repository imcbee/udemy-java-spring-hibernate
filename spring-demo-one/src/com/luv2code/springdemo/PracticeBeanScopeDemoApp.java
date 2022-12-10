package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PracticeBeanScopeDemoApp {

	public static void main(String[] args) {
		
		// load the spring configuration file (section 6)
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		
		//retrieve bean from spring container (section 6)
		Coach theCoach = context.getBean("mySwimmingCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("mySwimmingCoach", Coach.class);
		
		
		//check if they are the same beans (section 6)
		boolean result = (theCoach == alphaCoach);
		
		
		//print out results (section 6)
		System.out.println("\nPointing to the same object: " + result); // true
		
		System.out.println("\nMemory location for theCoach: " + theCoach); //Memory location for theCoach: com.luv2code.springdemo.TrackCoach@451001e5
		
		System.out.println("\nMemory location for alphaCoach: " + alphaCoach + "\n"); //Memory location for alphaCoach: com.luv2code.springdemo.TrackCoach@451001e5
			//these are the same memory and they are the same object/bean
			// after changing in xml with prototype for scope, there are two different objects now in memory
		
		
		//close the context
		context.close();
	}

}







