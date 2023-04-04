package com.ptithcm.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="quantrivien")
public class QuanTriVienEntity {
	@Id
	@Column(name="ma_qtv", length=20)
	private String maQTV;
	
	@OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name="ma_qtv")
	private AccountEntity account;

	public String getMaQTV() {
		return maQTV;
	}

	public void setMaQTV(String maQTV) {
		this.maQTV = maQTV;
	}

	public AccountEntity getAccount() {
		return account;
	}

	public void setAccount(AccountEntity account) {
		this.account = account;
	}
	
	
	
	
}
