package com.ptithcm.dto;

import java.util.List;

public class BaseListDto {
	private String message;
	private Boolean error;
	private List<Object> data;
	
	
	public BaseListDto(String message, Boolean error) {
		super();
		this.message = message;
		this.error = error;
	}
	public BaseListDto() {
		super();
	}
	public BaseListDto(String message, Boolean error, List<Object> data) {
		super();
		this.message = message;
		this.error = error;
		this.data = data;
	}
	public String getMessage() {
		return message;
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
	public List<Object> getData() {
		return data;
	}
	public void setData(List<Object> data) {
		this.data = data;
	}
	
	
}
