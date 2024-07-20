package com.jwt.demo.service;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jwt.demo.DTO.AuthenticationRequest;
import com.jwt.demo.DTO.AuthenticationResponse;
import com.jwt.demo.DTO.RegisterRequest;
import com.jwt.demo.model.Role;
import com.jwt.demo.model.Token;
import com.jwt.demo.model.TokenType;
import com.jwt.demo.model.User;
import com.jwt.demo.repository.TokenRepository;
import com.jwt.demo.repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.net.http.HttpHeaders;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecurityServiceImpl implements SecurityService{

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenRepository tokenRepository;

    @Override
    public AuthenticationResponse register(RegisterRequest registerRequest) {
        var user = User.builder()
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        var token = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        saveToken(user,token);
        return AuthenticationResponse.builder()
                .accessToken(token)
                .refreshToken(refreshToken)
                .build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authenticationRequest.getEmail(),
                authenticationRequest.getPassword()
        ));
        var user = userRepository.findByEmail(authenticationRequest.getEmail()).orElseThrow(()->new UsernameNotFoundException("no such user is found with provided email"));
        var token = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        revokeAllTokens(user.getId());
        saveToken(user,token);
        return AuthenticationResponse.builder()
                .accessToken(token)
                .refreshToken(refreshToken)
                .build();
    }
    
    private void revokeAllTokens(Long id) {
    	var tokens = tokenRepository.findByUserId(id);
    	System.err.println(tokens);
    	if(tokens.isEmpty())
    		return;
    	
    	for(var t : tokens) {
    		t.setExpired(true);
    		t.setRevoked(true);
    		tokenRepository.save(t);
    	} 
    }

    private void saveToken(User user,String jwt){
        var token = Token.builder()
                .user(user)
                .token(jwt)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }

	@Override
	public void refreshToken(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws StreamWriteException, DatabindException, IOException {
		   final String authHeader = httpServletRequest.getHeader(org.springframework.http.HttpHeaders.AUTHORIZATION);

	        if (authHeader == null || !authHeader.startsWith("Bearer ")) { 
	            return;
	        }

	        final String refreshToken = authHeader.substring(7);
	        final String userEmail = jwtService.extractUserName(refreshToken);

	        if (userEmail != null ) {
	            var userDetails = userRepository.findByEmail(userEmail).orElse(null); 
	            if (jwtService.isTokenIsValid(refreshToken, userDetails)) {
	            var accessToken = jwtService.generateToken(userDetails);
	            revokeAllTokens(userDetails.getId());
	            saveToken(userDetails, accessToken);
	            var authResponse = AuthenticationResponse.builder()
	            		.accessToken(accessToken)
	            		.refreshToken(refreshToken)
	            		.build();
	            new ObjectMapper().writeValue(httpServletResponse.getOutputStream(), authResponse);
	            }
	        }

	     
	}
}
