package com.ptithcm.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class LopTinChiDto {
	@NotBlank(message = "Mã lớp tín chỉ không được để trống")
	@Length(max = 20)
	private String maLopTinChi;
	
	@NotBlank(message = "Mã môn không được để trống")
	private String maMon;
	
	@NotNull(message = "Học kì không được để trống")
	@Min(1)
	@Max(4)
	private int hocKi;
	
	@NotNull(message = "Năm không được để trống")
	private int nam;
	
	@NotNull(message = "Trạng thái không được để trống")
	private Boolean trangThai;
	
	@NotNull(message = "Số sinh viên tối thiểu không được để trống")
	@Min(1)
	@Max(200)
	private int soSVToiThieu;
	
	@NotNull(message = "Số sinh viên tối đa không được để trống")
	@Min(1)
	@Max(200)
	private int soSVToiDa;
	
	private int slDangKi;
	
	public String getMaLopTinChi() {
		return maLopTinChi;
	}
	public void setMaLopTinChi(String maLopTinChi) {
		this.maLopTinChi = maLopTinChi;
	}
	public String getMaMon() {
		return maMon;
	}
	public void setMaMon(String maMon) {
		this.maMon = maMon;
	}
	public int getHocKi() {
		return hocKi;
	}
	public void setHocKi(int hocKi) {
		this.hocKi = hocKi;
	}
	public int getNam() {
		return nam;
	}
	public void setNam(int nam) {
		this.nam = nam;
	}
	public Boolean getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(Boolean trangThai) {
		this.trangThai = trangThai;
	}
	public int getSoSVToiThieu() {
		return soSVToiThieu;
	}
	public void setSoSVToiThieu(int soSVToiThieu) {
		this.soSVToiThieu = soSVToiThieu;
	}
	public int getSoSVToiDa() {
		return soSVToiDa;
	}
	public void setSoSVToiDa(int soSVToiDa) {
		this.soSVToiDa = soSVToiDa;
	}
	public int getSlDangKi() {
		return slDangKi;
	}
	public void setSlDangKi(int slDangKi) {
		this.slDangKi = slDangKi;
	}
	
	
}
