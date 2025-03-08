package com.test;

import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.test.base")
public class AppConfig {
	
	@Bean
	public Date date() {
		return new Date();
	}

}
