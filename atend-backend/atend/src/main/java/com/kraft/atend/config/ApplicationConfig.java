package com.kraft.atend.config;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfig {

	@Value("${jwt.secret.key}")
	private String jwtSecretKey;

	@Bean
	public RestTemplate RestTemplate() {
		return new RestTemplate();
	}

	@Bean
	public JwtDecoder jwtDecoder() {
		return NimbusJwtDecoder.withSecretKey(new SecretKeySpec(jwtSecretKey.getBytes(), "HMACSHA256")).build();
	};
}
