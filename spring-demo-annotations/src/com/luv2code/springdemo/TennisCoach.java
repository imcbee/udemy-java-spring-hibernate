package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component //this will use the default bean id unless you specify ("thatSillyCoach")
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("fileFortuneService")
	private FortuneService fortuneService;
	
	
	
	//define a default constructor (no args constructor to keep track of spring and give diagnosis message)
		//section 8
	public TennisCoach() {
		System.out.println(">> inside default constructor");
	}
	
	//section 9 - define init method
	@PostConstruct
	public void doMyStartUpStuff() {
		System.out.println(">> TennisCoach: inside of doMyStartUpStuff");
	}
	
	//section 9 - define destroy method
	@PreDestroy 
	public void doMyCleanUpStuff() {
		System.out.println(">> TennisCoach: inside of doMyCleanUpStuff");
	}
	
	//define setter method (section 8) - needs to resolve the inject dependency
//	@Autowired
//	public void doSomeCrazyStuff(FortuneService theFortuneService) {
//		System.out.println(">> inside the doSomeCrazyStuff() method");
//		fortuneService = theFortuneService;
//	}
	
	/*
	@Autowired
	public TennisCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	*/
	
	@Override
	public String getDailyWorkout() {
		
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
