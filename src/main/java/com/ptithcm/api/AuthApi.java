package com.ptithcm.api;

import java.io.UnsupportedEncodingException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ptithcm.dto.BaseDto;
import com.ptithcm.dto.RequestLoginDto;
import com.ptithcm.dto.ResponseLoginDto;
import com.ptithcm.service.AuthenticationService;

@RestController
public class AuthApi {
//	@Autowired
//	AuthenticationManager authManager;
	
	@Autowired
	private AuthenticationService authenticationService;
	
	
	@PostMapping("/auth/login")
    public ResponseEntity<?> login( @RequestBody @Valid RequestLoginDto request) throws IllegalArgumentException, UnsupportedEncodingException{
		try {
			ResponseLoginDto response=authenticationService.authenticate(request);
			if(response==null) {
				return ResponseEntity.status(200).body(new BaseDto("Tài khoản đã bị khóa, vui lòng liên hệ ADMIN để mở ", false));
			}
			return ResponseEntity.ok(response);
		} catch(BadCredentialsException ex) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new BaseDto("Sai password hoặc username ", false));
		}
	}
}
