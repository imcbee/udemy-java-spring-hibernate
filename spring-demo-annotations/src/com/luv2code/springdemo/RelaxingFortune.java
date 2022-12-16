package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class RelaxingFortune implements FortuneService {

	@Override
	public String getFortune() {
		
		return "There will be rest for the weary :) ";
	}

}
