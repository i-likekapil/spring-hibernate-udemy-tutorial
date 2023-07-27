package io.kapil.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("io.kapil.springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {

	// define bean for our sad fortune service
	@Bean
	public FortuneService getSadFortuneService() {
		return new SadFortuneService();
	}

	// define bean for our swim coach and inject dependency

	@Bean
	public Coach getSwimCoach() {
		return new SwimCoach(getSadFortuneService());
	}

}
