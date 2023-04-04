package com.ptithcm.dto;

import java.util.Date;

public class SinhVienDto {
	private String mssv;
	private String hoLot;
	private String ten;
	private Boolean gioiTinh;
	private Date ngaySinh;
	private String maKhoa;
	private String maLop;
	private String nienKhoa;
	private String heHoc;
	private AccountDto account;
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
	public AccountDto getAccount() {
		return account;
	}
	public void setAccount(AccountDto account) {
		this.account = account;
	}
	
	
}
