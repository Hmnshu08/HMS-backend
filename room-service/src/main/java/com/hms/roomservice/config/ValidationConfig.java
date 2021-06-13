package com.hms.roomservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

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
