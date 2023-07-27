package io.kapil.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VolleyBall implements Coach {

	private FortuneService fortuneService;
	
	@Autowired
	public void doSomeCrazyStuff(FortuneService fortuneService) {
		System.out.println("inside "+this.getClass().getName()+" doSomeCrazyStuff method");
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "play volleyball for 50 minutes";
	}

	@Override
	public String getDailyFortune() {
		return this.fortuneService.getFortune();
	}

}
