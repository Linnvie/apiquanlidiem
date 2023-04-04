package com.ptithcm.utils;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.ptithcm.dto.AccountDto;
 
@Component
public class JwtTokenUtil {
    private static final long EXPIRE_DURATION = 24 * 60 * 60 * 1000; // 24 hour
     
    @Value("${app.jwt.access}")
    private String SECRET_KEY_ACCESS;
    
    @Value("${app.jwt.refresh}")
    private String SECRET_KEY_REFRESH;
     
    public String generateAccessToken(AccountDto account) throws IllegalArgumentException, UnsupportedEncodingException {
//        return Jwts.builder()
//                .setSubject(String.format("%s,%s,%s",  account.getUsername(),  account.getRole(), account.getStatus()))
//                .setIssuer("CodeJava")
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
//                .signWith(SignatureAlgorithm.HS512, SECRET_KEY_ACCESS)
//                .compact();
    	Algorithm algorithm= Algorithm.HMAC256(SECRET_KEY_ACCESS);
    	return JWT.create()
//    			.withSubject(String.format("%s,%s,%s",  account.getUsername(),  account.getRole(), account.getStatus()))
    			.withSubject( account.getUsername())
    			.withExpiresAt(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
    			.withClaim("role", account.getRole())
    			.sign(algorithm);              
    }
    
    
    public String generateRefreshToken(AccountDto account) throws IllegalArgumentException, UnsupportedEncodingException {
  	Algorithm algorithm= Algorithm.HMAC256(SECRET_KEY_REFRESH);
  	return JWT.create()
  			.withSubject(account.getUsername())
  			.withExpiresAt(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
  			.sign(algorithm);              
  }
}