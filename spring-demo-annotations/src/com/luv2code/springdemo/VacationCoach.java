package com.luv2code.springdemo;


public class VacationCoach implements Coach {

	
	private FortuneService fortuneService;
	
	public VacationCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		
		return "Work on relaxation today and self-care!";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}

}
