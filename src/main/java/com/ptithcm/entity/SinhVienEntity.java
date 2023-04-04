package com.ptithcm.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

@Entity
@Table(name="sinhvien")
public class SinhVienEntity {
	@Id
	@Column(name="mssv", length=20)
	private String mssv;
	
	@Column(name="ho_lot", nullable=false, length=100)
	private String hoLot;
	
	@Column(name="ten", nullable=false, length=20)
	private String ten;
	
	@Column(name="gioi_tinh", nullable=false)
	private Boolean gioiTinh;
	
//	@Temporal(TemporalType.DATE)
//	@DateTimeFormat(pattern="dd/MM/yyyy")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	@Column(name="ngay_sinh")
	private Date ngaySinh;
	
	@Column(name="ma_khoa", nullable=false, length=20)
	private String maKhoa;
	
	@Column(name="ma_lop", nullable=false, length=20)
	private String maLop;
	
	@Column(name="nien_khoa", nullable=false, length=20)
	private String nienKhoa;
	
	@Column(name="he_hoc", nullable=false)
	private String heHoc;
	
	@OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name="mssv")
	private AccountEntity account;
	
//	@OneToMany(mappedBy="sinhVien")
//	private Collection<BangDiemChiTietEntity> listBangDiemChiTiet = new ArrayList<>();

	public String getMssv() {
		return mssv;
	}

	public void setMssv(String mssv) {
		this.mssv = mssv;
	}

	public String getHoLot() {
		return hoLot;
	}

	public void setHoLot(String hoLot) {
		this.hoLot = hoLot;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public Boolean getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(Boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getMaKhoa() {
		return maKhoa;
	}

	public void setMaKhoa(String maKhoa) {
		this.maKhoa = maKhoa;
	}

	public String getMaLop() {
		return maLop;
	}

	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}

	public String getNienKhoa() {
		return nienKhoa;
	}

	public void setNienKhoa(String nienKhoa) {
		this.nienKhoa = nienKhoa;
	}

	public String getHeHoc() {
		return heHoc;
	}

	public void setHeHoc(String heHoc) {
		this.heHoc = heHoc;
	}

	public AccountEntity getAccount() {
		return account;
	}

	public void setAccount(AccountEntity account) {
		this.account = account;
	}

//	public Collection<BangDiemChiTietEntity> getListBangDiemChiTiet() {
//		return listBangDiemChiTiet;
//	}
//
//	public void setListBangDiemChiTiet(Collection<BangDiemChiTietEntity> listBangDiemChiTiet) {
//		this.listBangDiemChiTiet = listBangDiemChiTiet;
//	}
	
	
	
	
}
