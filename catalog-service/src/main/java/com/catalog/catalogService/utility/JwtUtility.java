package com.catalog.catalogService.utility;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtility {

    private final long Expiration_time=1000*60*60; //will be valid for 1 hour, we can change it later
    private final String SECRET ="abhijeet-anand-secret-key-19292039209##9230";
    private final SecretKey key= Keys.hmacShaKeyFor(SECRET.getBytes());

    public String generateToken(String username){
      return   Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+Expiration_time))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractUserNameFromToken(String token){
      return  extractClaims(token).getSubject();

    }

    private Claims extractClaims(String token) {
        return Jwts.parser().setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean validateToken(String username, UserDetails userDetails,String token) {
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {

       return extractClaims(token).getExpiration().before(new Date());
    }
}
