package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
//@ComponentScan("com.luv2code.springdemo")
public class SportConfig {

	// define a bean for our sad fortune service (section 10)
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	// define bean for our swimCoach and inject dependency (section 10) 
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}
}
