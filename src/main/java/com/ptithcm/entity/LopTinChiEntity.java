package com.ptithcm.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="loptinchi")
public class LopTinChiEntity {
	@Id
	@Column(name="ma_lop_tin_chi", length=50)
	private String maLopTinChi;
	
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="ma_mon",insertable = false, updatable = false)
//	private MonEntity Mon;
	
//	@OneToMany(mappedBy="lopTinChi")
//	private Collection<BangDiemChiTietEntity> listBangDiemChiTiet = new ArrayList<>();
	
//	@OneToMany(mappedBy="lopTinChi")
//	private Collection<GiangVienLTCEntity> listGiangVienLTC = new ArrayList<>();
	
	@Column(name="ma_mon", nullable=false)
	private String maMon;
	
	@Column(name="hoc_ki", nullable=false, length=2)
	private Integer hocKi;
	
	@Column(name="nam", nullable=false, length=5)
	private Integer nam;
	
	@Column(name="trang_thai", nullable=false)
	private Boolean trangThai;
	
	@Column(name="so_sv_toi_thieu", nullable=false, length=3)
	private Integer soSVToiThieu;
	
	@Column(name="so_sv_toi_da", nullable=false,length=4)
	private Integer soSVToiDa;
	
	@Column(name="sl_dang_ki", nullable=false, length=4)
	private Integer slDangKi;

	public String getMaMon() {
		return maMon;
	}

	public void setMaMon(String maMon) {
		this.maMon = maMon;
	}

	public String getMaLopTinChi() {
		return maLopTinChi;
	}

	public void setMaLopTinChi(String maLopTinChi) {
		this.maLopTinChi = maLopTinChi;
	}

	public Integer getHocKi() {
		return hocKi;
	}

//	public MonEntity getMon() {
//		return Mon;
//	}
//
//	public void setMon(MonEntity mon) {
//		Mon = mon;
//	}

	public void setHocKi(Integer hocKi) {
		this.hocKi = hocKi;
	}

	public Integer getNam() {
		return nam;
	}

	public void setNam(Integer nam) {
		this.nam = nam;
	}

	public Boolean getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(Boolean trangThai) {
		this.trangThai = trangThai;
	}

	public Integer getSoSVToiThieu() {
		return soSVToiThieu;
	}

	public void setSoSVToiThieu(Integer soSVToiThieu) {
		this.soSVToiThieu = soSVToiThieu;
	}

	public Integer getSoSVToiDa() {
		return soSVToiDa;
	}

	public void setSoSVToiDa(Integer soSVToiDa) {
		this.soSVToiDa = soSVToiDa;
	}

	public Integer getSlDangKi() {
		return slDangKi;
	}

	public void setSlDangKi(Integer slDangKi) {
		this.slDangKi = slDangKi;
	}

//	public Collection<GiangVienLTCEntity> getListGiangVienLTC() {
//		return listGiangVienLTC;
//	}
//
//	public void setListGiangVienLTC(Collection<GiangVienLTCEntity> listGiangVienLTC) {
//		this.listGiangVienLTC = listGiangVienLTC;
//	}

//	public Collection<BangDiemChiTietEntity> getListBangDiemChiTiet() {
//		return listBangDiemChiTiet;
//	}
//
//	public void setListBangDiemChiTiet(Collection<BangDiemChiTietEntity> listBangDiemChiTiet) {
//		this.listBangDiemChiTiet = listBangDiemChiTiet;
//	}
	
	
	
	
	
	
}
