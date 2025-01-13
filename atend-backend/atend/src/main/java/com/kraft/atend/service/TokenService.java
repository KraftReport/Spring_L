package com.kraft.atend.service;
 

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

@Service
public class TokenService extends TokenHandler {
	
	@Value("${jwt.token.expiration}")
	private Long  expiration;
	@Value("${jwt.secret.key}")
	private String secretKey;
	
	private final Key key = Keys.hmacShaKeyFor(secretKey.getBytes());

	public String generateToken(Long id) {
		return Jwts.builder()
				.setSubject("forapicallfromclientapp")
				.claim("user-id", id)
				.setExpiration(new Date(System.currentTimeMillis()+expiration))
				.signWith(SignatureAlgorithm.HS256, key)
				.compact(); 
	}

}
