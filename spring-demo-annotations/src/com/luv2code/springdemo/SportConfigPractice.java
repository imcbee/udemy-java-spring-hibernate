package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class SportConfigPractice {

	// define a bean for our sad fortune service (section 10)
	@Bean
	public FortuneService relaxingFortune() {
		return new RelaxingFortune();
	}
	
	// define bean for our swimCoach and inject dependency (section 10) 
	@Bean
	public Coach vacationCoach() {
		VacationCoach vacationCoach = new VacationCoach(relaxingFortune());
		return vacationCoach;
	}
}
