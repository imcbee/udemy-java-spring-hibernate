package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

	public static void main(String[] args) {
		
		// load the spring configuration file (section 6)
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");
			//change file path to beanLifeCycle
		
		
		//retrieve bean from spring container(section 6)
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		//print (section 6)
		System.out.println(theCoach.getDailyWorkout());
		
		//close the context (section 6)
		context.close();
	}

}







