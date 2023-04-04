package com.ptithcm.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="account")
public class AccountEntity implements UserDetails{
	@Id
	@Column(name="username", length=20)
	private String username;
	
//	@OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
//	private SinhVienEntity sinhVien;
	
	@Column(name="password", nullable=false)
	private String password;
	
	@Column(name="status", nullable=false)
	private Boolean status;
	
	@Column(name="role", nullable=false, length=10)
	private String role;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

//	public SinhVienEntity getSinhVien() {
//		return sinhVien;
//	}
//
//	public void setSinhVien(SinhVienEntity sinhVien) {
//		this.sinhVien = sinhVien;
//	}

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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<SimpleGrantedAuthority> authorities= new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(role));
		return Collections.unmodifiableList(Arrays.asList(new SimpleGrantedAuthority(authorities.toString())));
		// List.of(new SimpleGrantedAuthority(authorities.toString()));
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	
	
	
}
