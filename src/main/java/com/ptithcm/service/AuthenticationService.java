package com.ptithcm.service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.ptithcm.dto.AccountDto;
import com.ptithcm.dto.RequestLoginDto;
import com.ptithcm.dto.ResponseLoginDto;
import com.ptithcm.entity.AccountEntity;
import com.ptithcm.repository.AccountRepository;
import com.ptithcm.utils.JwtTokenUtil;

@Service
public class AuthenticationService {
	@Autowired
	private AccountRepository accRepo;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwt;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public ResponseLoginDto authenticate(RequestLoginDto request) throws IllegalArgumentException, UnsupportedEncodingException {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		AccountEntity user = accRepo.findOneByUsername(request.getUsername()).orElseThrow(null);
//		List
		if(user!=null && user.getStatus()) {
			Collection<SimpleGrantedAuthority> authorities= new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority(user.getRole()));
			//Collections.unmodifiableList(Arrays.asList(new SimpleGrantedAuthority(authorities.toString())));
			
			String accessToken = jwt.generateAccessToken(modelMapper.map(user, AccountDto.class));
			String refreshToken = jwt.generateRefreshToken(modelMapper.map(user, AccountDto.class));
			return new ResponseLoginDto(request.getUsername(),accessToken, refreshToken);
		}
		return null;
		
	}

}
