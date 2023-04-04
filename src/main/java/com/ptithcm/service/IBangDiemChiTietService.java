package com.ptithcm.service;

import org.springframework.http.ResponseEntity;

import com.ptithcm.dto.BangDiemChiTietDto;
import com.ptithcm.dto.BaseDto;

public interface IBangDiemChiTietService {
	public ResponseEntity<BaseDto> findOneByMSSVAndMaLTC(String mssv, String maLTC);
	public ResponseEntity<BaseDto> save(BangDiemChiTietDto bangDiemChiTiet);
	public ResponseEntity<BaseDto> update(BangDiemChiTietDto bangDiemChiTiet);
	public ResponseEntity<BaseDto> findAllByMSSV(String mssv);
	public ResponseEntity<BaseDto> findAllByMSSVAndHKAndNam(String mssv, int hocKi, int nam);
	

}
