package com.jwt.demo.service;

import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.jwt.demo.DTO.AuthenticationRequest;
import com.jwt.demo.DTO.AuthenticationResponse;
import com.jwt.demo.DTO.RegisterRequest;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface SecurityService {
    AuthenticationResponse register(RegisterRequest registerRequest);
    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);
	void refreshToken(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws StreamWriteException, DatabindException, IOException;
}
