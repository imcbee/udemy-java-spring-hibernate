package com.luv2code.springdemo;


import java.util.Random;

public class CrystalBall implements FortuneService {

	// array of fortunes
	private String[] fortunes = {
			"Meeting adversity well is the source of your strength.",
			"You are very talented in many ways.",
			"Jealousy doesn't open doors, it closes them!"
	};
	
	// random variable
	private Random random = new Random();
	
	@Override
	public String getFortune() {
		int index = random.nextInt(fortunes.length);
		
		String givenFortune = fortunes[index];
		
		return givenFortune;
	}

}
