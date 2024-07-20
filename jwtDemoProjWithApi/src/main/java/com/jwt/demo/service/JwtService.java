package com.jwt.demo.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

	@Value("${application.security.secret-key}")
    private String SECRET_KEY;
	@Value("${application.security.access-token-expiration}")
	private Long accessTokenExpiration;
	@Value("${application.security.refresh-token-expiration}")
	private Long refreshTokenExpiration;

    public String extractUserName(String jwt) {
        return extractClaim(jwt,Claims::getSubject);
    }

    public <T>T extractClaim(String token, Function<Claims,T> claimResolver){
        final var claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    private Claims extractAllClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getSigingKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSigingKey(){
        var keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    
    public String generateRefreshToken(UserDetails userDetails) {
    	return buildToken(new HashMap<>(), userDetails, refreshTokenExpiration);
    }

    public String generateRefreshToken(Map<String,Object> extraClaims,UserDetails userDetails) {
    	return buildToken(extraClaims, userDetails, refreshTokenExpiration);
    }
    
    public String generateToken(Map<String,Object> extraClaims, UserDetails userDetails){
        return buildToken(extraClaims, userDetails, accessTokenExpiration);
    }

    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(),userDetails);
    }
    
    private String buildToken(Map<String,Object> extraClaims, UserDetails userDetails,Long expiration) {
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() * expiration))
                .signWith(getSigingKey())
                .compact();
    }

    public boolean isTokenIsValid(String token,UserDetails userDetails){
        var userName = extractUserName(token);
        return (userDetails.getUsername().equals(userName)) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token,Claims::getExpiration);
    }
}
