package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	// create an array of strings
	private String[] data = {
		"You must try, or hate yourself for not trying.",
		"You can make your own happiness.",
		"The greatest risk is not taking one."
	};
	
	//random number generator
	private Random myRandom =  new Random();
	
	@Override
	public String getFortune() {
		
		// pick a random fortune
		int index = myRandom.nextInt(data.length);
		
		String fortune = data[index];
		
		return fortune;
	}

}
