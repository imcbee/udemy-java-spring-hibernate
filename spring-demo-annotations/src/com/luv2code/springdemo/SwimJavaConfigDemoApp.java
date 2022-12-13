package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		
		// read SportConfig class (section 10)
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		// get the bean from spring container (section 10)
		Coach theCoach = context.getBean("swimCoach", Coach.class);
			// section 7: tennisCoach use to be "thatSillyCoach"
		
		//call method from the bean (section 10)
		System.out.println(theCoach.getDailyWorkout());
		
		// call method for dailyFortune (section 10)
		System.out.println(theCoach.getDailyFortune());
		
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
