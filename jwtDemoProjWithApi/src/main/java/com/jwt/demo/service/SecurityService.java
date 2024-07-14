package com.jwt.demo.service;

import com.jwt.demo.DTO.AuthenticationRequest;
import com.jwt.demo.DTO.AuthenticationResponse;
import com.jwt.demo.DTO.RegisterRequest;

public interface SecurityService {
    AuthenticationResponse register(RegisterRequest registerRequest);
    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);
}
