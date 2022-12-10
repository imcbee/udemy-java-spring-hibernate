package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class CodingCoach implements Coach {

	private FortuneService fortuneService;
	
	@Override
	public String getDailyWorkout() {
		
		return "Practice making Java Beans in the Spring Container";
		
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
