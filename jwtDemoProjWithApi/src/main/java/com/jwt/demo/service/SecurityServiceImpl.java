package com.jwt.demo.service;

import com.jwt.demo.DTO.AuthenticationRequest;
import com.jwt.demo.DTO.AuthenticationResponse;
import com.jwt.demo.DTO.RegisterRequest;
import com.jwt.demo.model.Role;
import com.jwt.demo.model.Token;
import com.jwt.demo.model.TokenType;
import com.jwt.demo.model.User;
import com.jwt.demo.repository.TokenRepository;
import com.jwt.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    
        saveToken(user,token);
        return AuthenticationResponse.builder()
                .token(token)
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
        revokeAllTokens(user.getId());
        saveToken(user,token);
        return AuthenticationResponse.builder()
                .token(token)
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
}
