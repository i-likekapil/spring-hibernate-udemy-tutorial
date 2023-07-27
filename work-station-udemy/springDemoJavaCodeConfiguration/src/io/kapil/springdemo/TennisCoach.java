package io.kapil.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	@Autowired
	private FortuneService fortuneService;
	
	@Override
	public String getDailyWorkout() {
		return "Played tennis for 2 hours";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	@PostConstruct
	public void init() {
		System.out.println("TennisCoach init bean hook");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("TennisCoach destroy bean hook");
	}
	
	

}
