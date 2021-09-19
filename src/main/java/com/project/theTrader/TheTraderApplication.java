package com.project.theTrader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

@SpringBootApplication
public class TheTraderApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheTraderApplication.class, args);
	}

	@Bean
	// https://www.baeldung.com/java-resourcebundle
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages-es");
		return messageSource;
	}

}
