package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class ArrayFortuneService implements FortuneService {

	private String[] fortunes = {
		"The man on the top of the mountain did not fall there.",
		"Meeting adversity well is the source of your strength.",
		"Never give up. You're not a failure if you don't give up.",
		"A very attractive person has a message for you.",
		"Wealth awaits you very soon.",
	};
	
	private Random random = new Random();
	
	@Override
	public String getFortune() {
		int index = random.nextInt(fortunes.length);

		String randoFortune = fortunes[index];
		
		return randoFortune;
	}

}
