package kraft.book.code.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class JWTService {

    @Value("${application.security.jwt.secret-key}")
    private String secretKey;
    @Value("${application.security.jwt.expiration}")
    private Long expiration;
    @Value("${application.security.jwt.refresh-token.expiration}")
    private Long refreshExpiration;


    public String extractUserName(String token){
        return extractClaims(token,Claims::getSubject);
    }
    public <T>T extractClaims(String token, Function<Claims,T> claimsResolver){
        var claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    public String generateToken(UserDetails userDetails){
        return createToken(new HashMap<>(),userDetails,expiration);
    }
    public String generateToken(Map<String ,Object> extraClaims,UserDetails userDetails){
        return createToken(extraClaims,userDetails,expiration);
    }
    public String refreshToken(UserDetails userDetails){
        return createToken(new HashMap<>(),userDetails,expiration);
    }
    public boolean isTokenValid(String token,UserDetails userDetails){
        var email = extractUserName(token);
        return (email.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }
    private Date extractExpiration(String token){
        return extractClaims(token,Claims::getExpiration);
    }
    private String createToken(Map<String,Object>extraClaims, UserDetails userDetails,Long expiration){
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date((System.currentTimeMillis()+expiration)))
                .signWith(getSignInKey(secretKey), SignatureAlgorithm.ES256)
                .compact();
    }
    private Claims extractAllClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey(secretKey))
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    private Key getSignInKey(String secretKey){
        var secret = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(secret);
    }
}
