package com.ptithcm.dto;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class BangDiemChiTietDto {
	private BangDiemChiTietKeyDto id;
	
	@Digits(integer = 2, fraction = 2,message="Phần thập phân Điểm hệ 1 chỉ gồm 2 chứ số ")
	@DecimalMin(value = "0.0", inclusive = false,message="Điểm hệ 1 phải lớn hơn 0.0")
	@DecimalMax(value = "10.0", inclusive = true,message="Điểm hệ 1 phải bé hơn 10.0")
	private Float diemHe1;
	
	@Digits(integer = 1, fraction = 2,message="Phần thập phân Điểm hệ 2 chỉ gồm 2 chứ số ")
	@DecimalMin(value = "0.0", inclusive = false,message="Điểm hệ 2 phải lớn hơn 0.0")
	@DecimalMax(value = "10.0", inclusive = true,message="Điểm hệ 2 phải bé hơn 10.0")
	private Float diemHe2;
	

	@Digits(integer = 1, fraction = 2,message="Phần thập phân Điểm hệ 3 chỉ gồm 2 chứ số ")
	@DecimalMin(value = "0.0", inclusive = false,message="Điểm hệ 3 phải lớn hơn 0.0")
	@DecimalMax(value = "10.0", inclusive = true,message="Điểm hệ 3 phải bé hơn 10.0")
	private Float diemHe3;
	
	private Float diemTB;
	
	//@NotNull(message="Số tíêt thực hành không được để trống")
	@Min(0)
	@Max(100)
	private Integer lan;

	public BangDiemChiTietKeyDto getId() {
		return id;
	}
	public void setId(BangDiemChiTietKeyDto id) {
		this.id = id;
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
