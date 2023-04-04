package com.ptithcm.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	//public static final String secret_key="123";
	 @Value("${app.jwt.access}")
	 private String SECRET_KEY_ACCESS;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String authorizationHeader = request.getHeader(AUTHORIZATION);
		if(authorizationHeader!=null && authorizationHeader.startsWith("Beer ")) {
			try {
				String token = authorizationHeader.substring("Beer ".length());
				Algorithm algorithm= Algorithm.HMAC256(SECRET_KEY_ACCESS.getBytes());
				JWTVerifier verifier=JWT.require(algorithm).build();
				DecodedJWT decodedJWT= verifier.verify(token);
				String username= decodedJWT.getSubject();
				String role = ((Claim) decodedJWT.getClaim("role")).asString();
				Collection<SimpleGrantedAuthority> authorities=new ArrayList<>();
				authorities.add(new SimpleGrantedAuthority(role));
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(username, null, authorities);
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				filterChain.doFilter(request, response);
			} catch (Exception e) {
				response.setHeader("error", e.getMessage());
				response.setStatus(FORBIDDEN.value());
				Map<String, String> error= new HashMap<>();
				error.put("error_message", e.getMessage());
				response.setContentType(APPLICATION_JSON_VALUE);
				new ObjectMapper().writeValue(response.getOutputStream(), error);
			}
		}else {
			filterChain.doFilter(request, response);
		}
		
	}

	public JwtAuthenticationFilter(String sECRET_KEY_ACCESS) {
		super();
		SECRET_KEY_ACCESS = sECRET_KEY_ACCESS;
	}

	public JwtAuthenticationFilter() {
		super();
	}
	
	

}
