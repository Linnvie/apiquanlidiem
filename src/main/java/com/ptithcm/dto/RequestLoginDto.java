package com.ptithcm.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class RequestLoginDto {
	@NotNull
	@Length(min = 5, max = 20)
	private String username;
	
	@NotNull
	@Length( max = 255)
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
