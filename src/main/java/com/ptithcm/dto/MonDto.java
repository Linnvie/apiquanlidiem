package com.ptithcm.dto;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class MonDto {
	@NotBlank(message="Mã môn không được để trống")
	@Length(min = 3, max = 20 ,message="Mã môn phải từ 3-20 kí tự")
	private String maMon;
	
	@NotBlank(message="Tên môn không được để trống")
	@Length(max = 255,message="Tên môn không được vượt quá 255 kí tự")
	private String tenMon;
	
	@NotNull(message="Số tín chỉ không được để trống")
	@Min(0)
	@Max(5)
	private Integer soTinChi;
	
	@NotNull(message="Số tiết lí thuyêt không được để trống")
	@Min(0)
	@Max(200)
	private Integer soTietLiThuyet;
	
	@NotNull(message="Số tíêt thực hành không được để trống")
	@Min(0)
	@Max(200)
	private Integer soTietThucHanh;
	
	@NotNull
	@Digits(integer = 1, fraction = 2,message="Phần thập phân Hệ số 1 chỉ gồm 2 chứ số ")
	@DecimalMin(value = "0.0", inclusive = false,message="Hệ số 1 phải lớn hơn 0.0")
	@DecimalMax(value = "1.0", inclusive = true,message="Hệ số 1 phải bé hơn 1.0")
	private Float heSo1;
	
	@NotNull
	@Digits(integer = 1, fraction = 2,message="Phần thập phân Hệ số 2 chỉ gồm 2 chứ số ")
	@DecimalMin(value = "0.0", inclusive = false,message="Hệ số 2 phải lớn hơn 0.0")
	@DecimalMax(value = "1.0", inclusive = true,message="Hệ số 2 phải bé hơn 1.0")
	private Float heSo2;
	
	@NotNull
	@Digits(integer = 1, fraction = 2,message="Phần thập phân Hệ số 3 chỉ gồm 2 chứ số ")
	@DecimalMin(value = "0.0", inclusive = false,message="Hệ số 3 phải lớn hơn 0.0")
	@DecimalMax(value = "1.0", inclusive = true,message="Hệ số 3 phải bé hơn 1.0")
	private Float heSo3;

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

	public MonDto() {
		super();
	}

	public MonDto(String maMon, String tenMon, Integer soTinChi, Integer soTietLiThuyet, Integer soTietThucHanh,
			Float heSo1, Float heSo2, Float heSo3) {
		super();
		this.maMon = maMon;
		this.tenMon = tenMon;
		this.soTinChi = soTinChi;
		this.soTietLiThuyet = soTietLiThuyet;
		this.soTietThucHanh = soTietThucHanh;
		this.heSo1 = heSo1;
		this.heSo2 = heSo2;
		this.heSo3 = heSo3;
	}
	
	
}
