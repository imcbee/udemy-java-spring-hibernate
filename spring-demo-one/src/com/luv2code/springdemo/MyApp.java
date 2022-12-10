package com.luv2code.springdemo;

public class MyApp {

	public static void main(String[] args) {
		//create the object
		//Coach theCoach = new BaseballCoach(); // refactor code to work with any type of coach
		Coach theCoach = new TrackCoach();
		
		//use the object
		System.out.println(theCoach.getDailyWorkout()); //use sysout for quick typing
	}

}
