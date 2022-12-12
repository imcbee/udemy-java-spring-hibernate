package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class CodingCoach implements Coach {

	private FortuneService fortuneService;
	
	@Override
	public String getDailyWorkout() {
		
		return "Practice making Java Beans in the Spring Container";
		
	}
	
//	@PostConstruct
//	public void doMyStartUpStuff() {
//		System.out.println(">> CodingCoach: inside of doMyStartUpStuff");
//	}
//	
//	@PreDestroy
//	public void doMyCleanUpStuff() {
//		System.out.println(">> CodingCoach: inside of doMyCleanUpStuff");
//	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
