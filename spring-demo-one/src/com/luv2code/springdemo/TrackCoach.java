package com.luv2code.springdemo;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	
	public TrackCoach() { // this is taking care of the complier issue in myApp
		
	}
	
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		
		return "Just do it! " + fortuneService.getFortune();
	}
	
	// add an init method (section 6)
	public void doMyStartupStuff() { // you can give any method name (section 6)
		System.out.println("TrackCoach: inside method doMyStartupStuff");
	}
	
	// add a destory method (section 6)
	public void doMyCleanupStuffYoYo() {
		System.out.println("TrackCoach: inside method doMyCleanupStuff");

	}

}
