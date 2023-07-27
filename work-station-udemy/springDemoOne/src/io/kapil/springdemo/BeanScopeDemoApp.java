package io.kapil.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContextPrototype.xml");
		
		HappyFortuneService service1 = context.getBean("fortune",HappyFortuneService.class);
		//System.out.println(service1.getTitle());
		service1.setTitle("Kapil");
		//System.out.println(service1.getTitle());
		
		HappyFortuneService service2 = context.getBean("fortune",HappyFortuneService.class);
		
		//System.out.println(service2.getTitle());
		
		boolean result = service1 == service2;
		
		System.out.println("Pointing to the same object : "+result);
		System.out.println("Memory location of service 1 : "+service1);
		System.out.println("Memory location of service 2 : "+service2);
		
		context.close();
	}

}
