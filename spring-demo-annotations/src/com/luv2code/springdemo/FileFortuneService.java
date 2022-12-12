package com.luv2code.springdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {

	//set variables
	private String fileName = "/Users/ianmcbee/git/udemy-java-spring-hibernate/spring-demo-annotations/src/com/luv2code/springdemo/fortunes";
	private ArrayList<String> listOfFortunes;
	
	//random number generator
	Random myRandom = new Random();
	
	//method to read from file
	
	public FileFortuneService() {
		// file reader
		File theFile = new File(fileName);
		//print out checks
		System.out.println("The fortunes from the textfile: " + theFile);
		System.out.println("The fortunes exist: " + theFile.exists());
		
		//set up arraylist
		listOfFortunes = new ArrayList<String>();
		
		//tempLine var
		String tempLine;
		
		//read fortune from file
		try (BufferedReader br = new BufferedReader(
				new FileReader(fileName))) {
			
			while((tempLine = br.readLine()) != null) {
				listOfFortunes.add(tempLine);
			}
			
		}catch( Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public String getFortune() {
		//choose random string
		int index = myRandom.nextInt(listOfFortunes.size());
		
		//return random fortune
		String givenFortune = listOfFortunes.get(index);
		
		return givenFortune;
	}

}
