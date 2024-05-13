package com.example.demo.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.util.Date;
import java.util.function.Function;

public class JwtUtil {

    private  String SECRECT_KEY = "secrect";

    public String extractUsername(String token){
        return extractUsername(token, Claims::getSubject);
    }

    public Date extractExpiration(String token){
        return extractClaim(token, Claims::getExpiration);
    }

    public <T>  T extractClaim(String token, Function<Claims, T> claimResolver){
        final Claims claims = extractAllClaims(token);

        return claimResolver.apply(claims);

    }

    private  Claims extractAllClaims(String token){
        return Jwts.parser().setSigningKey(SECRECT_KEY);
    }
}
