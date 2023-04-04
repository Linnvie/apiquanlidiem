package com.ptithcm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import com.ptithcm.config.JwtAuthenticationFilter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//	@Autowired
//	private JwtAuthenticationFilter jwtAuthenticationFilter;
//	
//	private AuthenticationProvider authenticationProvider;
//	
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http.csrf().disable();
//		http.sessionManagement().sessionCreationPolicy(STATELESS);
//		http.authorizeRequests()
//			.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
//			.antMatchers("/auth/login").permitAll()
//			.antMatchers("/test").hasAnyAuthority("ROLE_USER")
//			.antMatchers("/admin/**").hasRole("ADMIN")
//			.and()
//			.csrf().disable()
//			.authorizeRequests()
//			.anyRequest()
//			.authenticated()
//			.and()
//			.authenticationProvider(authenticationProvider)
//			.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//		
//		return http.build();
//	}
//}


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;
	
	private AuthenticationProvider authenticationProvider;
	
	

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.csrf().disable();
		http.sessionManagement().sessionCreationPolicy(STATELESS);
		http.authorizeRequests()
			.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
			.antMatchers("/auth/login").permitAll()
			.antMatchers("/account**").permitAll()
			.antMatchers("/ltc**").permitAll()
			.antMatchers("/mon").permitAll()
			.antMatchers("/diem**").permitAll()
			.antMatchers("/dangkiltc**").permitAll()
			.antMatchers("/sv**").permitAll()
			//.antMatchers("/test").hasAnyAuthority("ROLE_ADMIN")
			.antMatchers("/admin/**").hasRole("ADMIN")
			.and()
			.csrf().disable()
			.authorizeRequests()
			.anyRequest()
			.authenticated()
			.and()
			.authenticationProvider(authenticationProvider)
			.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
         
    }
}
