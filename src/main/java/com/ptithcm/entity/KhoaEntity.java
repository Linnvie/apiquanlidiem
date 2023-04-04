package com.ptithcm.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="khoa")
public class KhoaEntity {
	@Id
	@Column(name="ma_khoa", length=20)
	private String maKhoa;
	
	@Column(name="ten_khoa", nullable=false)
	private String tenKhoa;
	
//	@OneToMany(mappedBy="khoa")
//	private Collection<LopEntity> lopList = new ArrayList<>();

	public String getMaKhoa() {
		return maKhoa;
	}

	public void setMaKhoa(String maKhoa) {
		this.maKhoa = maKhoa;
	}

	public String getTenKhoa() {
		return tenKhoa;
	}

	public void setTenKhoa(String tenKhoa) {
		this.tenKhoa = tenKhoa;
	}

//	public Collection<LopEntity> getLopList() {
//		return lopList;
//	}
//
//	public void setLopList(Collection<LopEntity> lopList) {
//		this.lopList = lopList;
//	}
	
	
	
	
}
