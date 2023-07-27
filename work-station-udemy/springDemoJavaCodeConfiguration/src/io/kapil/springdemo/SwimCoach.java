package io.kapil.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

	private FortuneService fortuneService;
	
	@Value("${email}")
	private String email;
	
	@Value("${sport.name}")
	private String name;

	public SwimCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "swim for last 30 minutes with "+this.email+" name is "+this.name;
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
