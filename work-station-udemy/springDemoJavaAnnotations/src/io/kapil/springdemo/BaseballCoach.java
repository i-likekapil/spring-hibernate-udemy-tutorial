package io.kapil.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component("thatSillyCoach")
@Component // default bean name is lower case of 1st letter of classname baseballCoach
public class BaseballCoach implements Coach {
	
	private FortuneService fortuneService;
	
	@Autowired
	public BaseballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}


	@Override
	public String getDailyWorkout() {
		return "play baseball for 30 minutes";
	}


	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	

}
