package com.kraft.atend.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kraft.atend.model.UserRegisterDto;
import com.kraft.atend.model.UserRegisterModel;
import com.kraft.atend.service.AuthService;
import com.kraft.atend.service.OauthHandler;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

	private final AuthService authService;
	private final OauthHandler oauthHandler;
	
	@GetMapping("/hello")
	public ResponseEntity<String> sayHello() {
		return ResponseEntity.ok("Hello");
	}
 
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> AuthenticateUser(@RequestParam("token") String token)
			throws GeneralSecurityException, IOException {
		
		var payload = oauthHandler.getPayloadFromToken(token);
		
		var userRegisterDto = new UserRegisterDto((String) payload.get("name"),payload.getEmail(),payload.getSubject()); 
		
		return ResponseEntity.ok(authService.registerUser(userRegisterDto));
	}
}
