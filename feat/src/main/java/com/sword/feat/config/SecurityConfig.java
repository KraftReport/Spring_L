package com.sword.feat.config;

import com.sword.feat.model.ROLE;
import com.sword.feat.service.CustomAuthenticationProviderService;
import com.sword.feat.service.CustomUserDetailService;

import ch.qos.logback.core.net.SocketConnector.ExceptionHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.ExceptionHandlingConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf(csrf -> csrf.disable()).authorizeHttpRequests(auth -> {
			auth.requestMatchers("/css/**").permitAll();
			auth.requestMatchers("/login", "/register").permitAll();
			auth.requestMatchers("/admin/**").hasAuthority(ROLE.ADMIN.name());
			auth.anyRequest().authenticated();
		}).formLogin(login -> login.loginPage("/login").defaultSuccessUrl("/home").permitAll())
				.logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/login?logout").permitAll())
				.exceptionHandling(excetpionHandler -> excetpionHandler
						.accessDeniedHandler((request, response, accessDeniedException) -> {
							response.sendRedirect("/access-denied");
						}));

		return httpSecurity.build();
	}


	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


 

}
