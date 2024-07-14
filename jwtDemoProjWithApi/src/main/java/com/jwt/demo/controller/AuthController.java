package com.jwt.demo.controller;

import com.jwt.demo.DTO.AuthenticationRequest;
import com.jwt.demo.DTO.AuthenticationResponse;
import com.jwt.demo.DTO.RegisterRequest;
import com.jwt.demo.service.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final SecurityService securityService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest registerRequest){
        return ResponseEntity.ok(securityService.register(registerRequest));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest){
        return ResponseEntity.ok(securityService.authenticate(authenticationRequest));
    }
}
