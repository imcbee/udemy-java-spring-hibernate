package com.luv2code.springdemo;

public class BaseballCoach implements Coach {
	
	//define a private field for the dependency
	private FortuneService fortuneService;
	
	// define a constructor for dependency injection
	public BaseballCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}

	@Override //
	public String getDailyWorkout() {
		return "Spend 30 mins in the batting cage for practice";
	}

	@Override
	public String getDailyFortune() {
		
		// use the fortuneSergice to get a fortune
		
		return fortuneService.getFortune();
	}
}
