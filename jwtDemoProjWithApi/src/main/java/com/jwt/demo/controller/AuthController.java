package com.jwt.demo.controller;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.jwt.demo.DTO.AuthenticationRequest;
import com.jwt.demo.DTO.AuthenticationResponse;
import com.jwt.demo.DTO.RegisterRequest;
import com.jwt.demo.service.SecurityService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

import java.io.IOException;

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
    
    @PostMapping("/refresh-token")
    public void refreshToken(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws StreamWriteException, DatabindException, IOException {
    	securityService.refreshToken(httpServletRequest,httpServletResponse);
    }
}
