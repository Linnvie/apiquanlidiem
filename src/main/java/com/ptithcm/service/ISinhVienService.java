package com.ptithcm.service;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import com.ptithcm.dto.BaseDto;
import com.ptithcm.dto.SinhVienDto;
import com.ptithcm.dto.TTSinhVienDto;

public interface ISinhVienService {
	SinhVienDto save(SinhVienDto sinhVienDto);
	ResponseEntity<BaseDto> findOneByMSSV(String mssv);
	public Page<TTSinhVienDto> findAllByMaLTCWithPaginateAndSorting(String maLTC,int offset, int perPage, String field, String sort);
	public Page<SinhVienDto> findAllByMaLopCWithPaginateAndSorting(String maLop,int offset, int perPage, String field, String sort);
}
