package com.ptithcm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="lop")
public class LopEntity {
	@Id
	@Column(name="ma_lop",length=20)
	private String maLop;
	
	@Column(name="ten_lop", nullable=false)
	private String tenLop;
	
//	@Column(name="ma_khoa", nullable=false)
//	private String maKhoa;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ma_khoa",insertable = false, updatable = false)
	private KhoaEntity Khoa;

	public String getMaLop() {
		return maLop;
	}

	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}

	public String getTenLop() {
		return tenLop;
	}

	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}

	public KhoaEntity getKhoa() {
		return Khoa;
	}

	public void setKhoa(KhoaEntity khoa) {
		Khoa = khoa;
	}

//	public String getMaKhoa() {
//		return maKhoa;
//	}
//
//	public void setMaKhoa(String maKhoa) {
//		this.maKhoa = maKhoa;
//	}
	
	
	
	
}
