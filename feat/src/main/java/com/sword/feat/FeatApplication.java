package com.sword.feat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.sword.feat.service.CustomAuthenticationProviderService;

import lombok.RequiredArgsConstructor;

@SpringBootApplication 
public class FeatApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(FeatApplication.class, args);
	}

 

}
