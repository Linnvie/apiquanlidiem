package com.ptithcm.service;

import org.springframework.data.domain.Page;

import com.ptithcm.dto.MonDto;

public interface IMonService {
	//public Page<MonDto> findAllMonWithPaginateAndSorting(int offset, int perPage, String field, String sort);
	public MonDto save(MonDto mon);
	public MonDto update(MonDto mon);
	Page<MonDto> findAllMonWithPaginateAndSorting(String maMon, int offset, int perPage, String field, String sort);
}
