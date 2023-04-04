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
@Table(name="mon")
public class MonEntity {
	@Id
	@Column(name="ma_mon", length=20)
	private String maMon;
	
	@Column(name="ten_mon", nullable=false)
	private String tenMon;
	
	@Column(name="so_tin_chi", nullable=false, length=2)
	private Integer soTinChi;
	
	@Column(name="so_tiet_li_thuyet", nullable=false, length=3)
	private Integer soTietLiThuyet;
	
	@Column(name="so_tiet_thuc_hanh", nullable=false, length=3)
	private Integer soTietThucHanh;
	
	
	@Column(name="he_so_1", nullable=false)
	private Float heSo1;
	
	@Column(name="he_so_2", nullable=false)
	private Float heSo2;
	
	@Column(name="he_so_3", nullable=false)
	private Float heSo3;
	
//	@OneToMany(mappedBy="khoa")
//	private Collection<LopTinChiEntity> lopTCList = new ArrayList<>();

	public String getMaMon() {
		return maMon;
	}

	public void setMaMon(String maMon) {
		this.maMon = maMon;
	}

	public String getTenMon() {
		return tenMon;
	}

	public void setTenMon(String tenMon) {
		this.tenMon = tenMon;
	}

	public Integer getSoTinChi() {
		return soTinChi;
	}

	public void setSoTinChi(Integer soTinChi) {
		this.soTinChi = soTinChi;
	}

	public Integer getSoTietLiThuyet() {
		return soTietLiThuyet;
	}

	public void setSoTietLiThuyet(Integer soTietLiThuyet) {
		this.soTietLiThuyet = soTietLiThuyet;
	}

	public Integer getSoTietThucHanh() {
		return soTietThucHanh;
	}

	public void setSoTietThucHanh(Integer soTietThucHanh) {
		this.soTietThucHanh = soTietThucHanh;
	}

	public Float getHeSo1() {
		return heSo1;
	}

	public void setHeSo1(Float heSo1) {
		this.heSo1 = heSo1;
	}

	public Float getHeSo2() {
		return heSo2;
	}

	public void setHeSo2(Float heSo2) {
		this.heSo2 = heSo2;
	}

	public Float getHeSo3() {
		return heSo3;
	}

	public void setHeSo3(Float heSo3) {
		this.heSo3 = heSo3;
	}

//	public Collection<LopTinChiEntity> getLopTCList() {
//		return lopTCList;
//	}
//
//	public void setLopTCList(Collection<LopTinChiEntity> lopTCList) {
//		this.lopTCList = lopTCList;
//	}
	
	

}
