package com.ptithcm.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="bangdiemchitiet")
public class BangDiemChiTietEntity {
	
	@EmbeddedId
	private BangDiemChiTietKey id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="mssv",insertable = false, updatable = false)
	private SinhVienEntity sinhVien;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ma_ltc",insertable = false, updatable = false)
	private LopTinChiEntity lopTinChi;
	
	@Column(name="diem_he_1", nullable=false)
	private Float diemHe1;
	
	@Column(name="diem_he_2", nullable=false)
	private Float diemHe2;
	
	@Column(name="diem_he_3", nullable=false)
	private Float diemHe3;
	
	@Column(name="diem_tb", nullable=false)
	private Float diemTB;
	
	@Column(name="lan", nullable=false, length=2)
	private Integer lan;

	public BangDiemChiTietKey getId() {
		return id;
	}

	public void setId(BangDiemChiTietKey id) {
		this.id = id;
	}

	public SinhVienEntity getSinhVien() {
		return sinhVien;
	}

	public void setSinhVien(SinhVienEntity sinhVien) {
		this.sinhVien = sinhVien;
	}

	public LopTinChiEntity getLopTinChi() {
		return lopTinChi;
	}

	public void setLopTinChi(LopTinChiEntity lopTinChi) {
		this.lopTinChi = lopTinChi;
	}

	public Float getDiemHe1() {
		return diemHe1;
	}

	public void setDiemHe1(Float diemHe1) {
		this.diemHe1 = diemHe1;
	}

	public Float getDiemHe2() {
		return diemHe2;
	}

	public void setDiemHe2(Float diemHe2) {
		this.diemHe2 = diemHe2;
	}

	public Float getDiemHe3() {
		return diemHe3;
	}

	public void setDiemHe3(Float diemHe3) {
		this.diemHe3 = diemHe3;
	}

	public Float getDiemTB() {
		return diemTB;
	}

	public void setDiemTB(Float diemTB) {
		this.diemTB = diemTB;
	}

	public Integer getLan() {
		return lan;
	}

	public void setLan(Integer lan) {
		this.lan = lan;
	}
	
	
}
