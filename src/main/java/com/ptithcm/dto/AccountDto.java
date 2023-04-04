package com.ptithcm.dto;

public class AccountDto {
	private String username;
	private String password;
	private Boolean status;
	private String role;
	//private SinhVienDto sinhVien;
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
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
//	public SinhVienDto getSinhVien() {
//		return sinhVien;
//	}
//	public void setSinhVien(SinhVienDto sinhVien) {
//		this.sinhVien = sinhVien;
//	}
	
	
	
}
