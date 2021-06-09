package com.hms.guestservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class ValidationConfig {

	//validating mongo event listener
	@Bean
	public ValidatingMongoEventListener validationMongoEventListener() {
		return new ValidatingMongoEventListener(validator());
	}
	
	//method for validation
	@Bean
	public LocalValidatorFactoryBean validator() {
		return new LocalValidatorFactoryBean();
	}
}
