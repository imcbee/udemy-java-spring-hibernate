package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		
		// read SportConfig class (section 10)
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		// get the bean from spring container (section 10)
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);
			// section 7: tennisCoach use to be "thatSillyCoach"
		
		//call method from the bean (section 10)
		System.out.println(theCoach.getDailyWorkout());
		
		// call method for dailyFortune (section 10)
		System.out.println(theCoach.getDailyFortune());
		
		//call new methods (section 10 - inject from properties file)
		System.out.println(String.format("email: %s", theCoach.getEmail()));
		System.out.println(String.format("team: %s", theCoach.getTeam()));
		
		
		//close context (section 10)
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
