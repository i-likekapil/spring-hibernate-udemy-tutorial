package io.kapil.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// with bean name
//		Coach coach = context.getBean("thatSillyCoach",Coach.class);

		// without bean name using default bean name
		// construction injection
//		Coach coach = context.getBean("baseballCoach",Coach.class);
//		System.out.println(coach.getDailyWorkout());
//		System.out.println(coach.getDailyFortune());

		// setter injection
//		Coach coach = context.getBean("tennisCoach",Coach.class);
//		System.out.println(coach.getDailyWorkout());
//		System.out.println(coach.getDailyFortune());

		// any method injection
//		Coach coach = context.getBean("volleyBall",Coach.class);
//		System.out.println(coach.getDailyWorkout());
//		System.out.println(coach.getDailyFortune());

		// field injection
//		Coach coach = context.getBean("hockeyCoach",Coach.class);
//		System.out.println(coach.getDailyWorkout());
//		System.out.println(coach.getDailyFortune());

		// qualify bean id if we have multiple implementation of base bean
		Coach coach = context.getBean("hockeyCoach", Coach.class);
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());

		context.close();

	}

}
