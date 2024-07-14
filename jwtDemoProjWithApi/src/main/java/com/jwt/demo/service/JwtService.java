package com.jwt.demo.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private static final String SECRET_KEY = "C06DF6C12FED7E4896C67B306C150EB834EE47A38F0F96DF0C60152AF946EF3ABA299B7AB0802B240706ADD6A1F6A4019B5F8F9B8DE2E86FD44F849AA519FA7C0050DCBB8A9CFBE7743C787454DDD33871F6E5A3C13AE3519EE5797696B394965E808102B1454DC57B61EA96DF8D843E4D49B1974C6CB27AB3449E827C573A24";

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

    public String generateToken(Map<String,Object> extraClaims, UserDetails userDetails){
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() * 1000 * 60 * 24))
                .signWith(getSigingKey())
                .compact();
    }

    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(),userDetails);
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
