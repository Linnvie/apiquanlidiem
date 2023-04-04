package com.ptithcm.dto;

public class BaseDto {
	private String message;
	private Boolean error;
	private Object data;
	public String getMessage() {
		return message;
	}
	
	public BaseDto() {
		super();
	}


	public BaseDto(String message, Boolean error) {
		super();
		this.message = message;
		this.error = error;
	}


	public BaseDto(String message, Boolean error, Object data) {
		super();
		this.message = message;
		this.error = error;
		this.data = data;
	}


	public void setMessage(String message) {
		this.message = message;
	}
	public Boolean getError() {
		return error;
	}
	public void setError(Boolean error) {
		this.error = error;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
}
