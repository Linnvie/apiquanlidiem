package com.ptithcm.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="giangvien_ltc")
public class GiangVienLTCEntity {
	@EmbeddedId
	private GVLTCKey id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ma_gv",insertable = false, updatable = false)
	private GiangVienEntity giangVien;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ma_ltc",insertable = false, updatable = false)
	private LopTinChiEntity lopTinChi;

	public GVLTCKey getId() {
		return id;
	}

	public void setId(GVLTCKey id) {
		this.id = id;
	}

	public GiangVienEntity getGiangVien() {
		return giangVien;
	}

	public void setGiangVien(GiangVienEntity giangVien) {
		this.giangVien = giangVien;
	}

	public LopTinChiEntity getLopTinChi() {
		return lopTinChi;
	}

	public void setLopTinChi(LopTinChiEntity lopTinChi) {
		this.lopTinChi = lopTinChi;
	}
	
	
}
