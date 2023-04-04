package com.ptithcm.service;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import com.ptithcm.dto.BaseDto;
import com.ptithcm.dto.LopTinChiDto;

public interface ILopTinChiService {
	public Page<LopTinChiDto> findAllByMaMonWithPaginateAndSorting(String maMon,int offset, int perPage, String field, String sort);
	public Page<LopTinChiDto> findAllByMaMonAndHocKiAndNamWithPaginateAndSorting(String maMon,int hocKi, int nam, int offset, int perPage, String field, String sort);
	public LopTinChiDto findOneByMaLopTinChi(String maLTC);
	public ResponseEntity<BaseDto> save(LopTinChiDto newLTC);
	public ResponseEntity<BaseDto> update(LopTinChiDto newLTC);
}
