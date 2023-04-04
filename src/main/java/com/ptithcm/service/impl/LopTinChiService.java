package com.ptithcm.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ptithcm.dto.BaseDto;
import com.ptithcm.dto.LopTinChiDto;
import com.ptithcm.entity.LopTinChiEntity;
import com.ptithcm.entity.MonEntity;
import com.ptithcm.repository.LopTinChiRepository;
import com.ptithcm.repository.MonRepository;
import com.ptithcm.service.ILopTinChiService;

@Service
@Transactional
public class LopTinChiService implements ILopTinChiService {
	@Autowired
	private LopTinChiRepository ltcRepository;
	
	@Autowired
	private MonRepository monRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	

	@Override
	public Page<LopTinChiDto> findAllByMaMonWithPaginateAndSorting(String maMon,int offset, int perPage, String field, String sort) {
//		List<LopTinChiEntity> listEntity = ltcRepository.findAllByMaMon(maMon).orElse(null);
//		if(listEntity==null) {
//			return null;
//		}
//		List<LopTinChiDto> listDto= new ArrayList<LopTinChiDto>();
//		for(LopTinChiEntity entity:listEntity) {
//			listDto.add(modelMapper.map(entity, LopTinChiDto.class));
//		}
//		return listDto;
		
		if(field.isEmpty()) {
			return ltcRepository.findAllByMaMon(maMon,new PageRequest(offset, perPage)).orElse(null).map(new Converter<LopTinChiEntity, LopTinChiDto>(){
				@Override
				public LopTinChiDto convert(LopTinChiEntity source) {
					return modelMapper.map(source, LopTinChiDto.class);
				}
				
			});
			   
		}else {
			Sort a= sort.equals("ASC") ? new Sort(Direction.ASC, field):new Sort(Direction.DESC, field);
			return ltcRepository.findAllByMaMon(maMon,new PageRequest(offset, perPage, a)).orElse(null).map(new Converter<LopTinChiEntity, LopTinChiDto>(){
				@Override
				public LopTinChiDto convert(LopTinChiEntity source) {
					return modelMapper.map(source, LopTinChiDto.class);
				}			
			});
		}
		
	}

	@Override
	public LopTinChiDto findOneByMaLopTinChi(String maLTC) {
		return modelMapper.map(ltcRepository.findOneByMaLopTinChi(maLTC), LopTinChiDto.class);
	}

	@Override
	public ResponseEntity<BaseDto> save(LopTinChiDto newLTC) {
		MonEntity monEntity = monRepository.findOneByMaMon(newLTC.getMaMon()).orElse(null);
		if(monEntity==null) {
			return ResponseEntity.status(202).body(new BaseDto("Mã môn không tồn tại", false));
		}
		LopTinChiEntity ltcEntity = ltcRepository.findOneByMaLopTinChi(newLTC.getMaLopTinChi()).orElse(null);
		return ltcEntity==null 
				? ResponseEntity.ok().body(new BaseDto("ok", false, modelMapper.map(ltcRepository.save(modelMapper.map(newLTC, LopTinChiEntity.class)), LopTinChiDto.class)))
				: ResponseEntity.status(202).body(new BaseDto("Mã lớp tín chỉ đã tồn tại", true));
	}

	@Override
	public ResponseEntity<BaseDto> update(LopTinChiDto newLTC) {
		MonEntity monEntity = monRepository.findOneByMaMon(newLTC.getMaMon()).orElse(null);
		if(monEntity==null) {
			return ResponseEntity.status(202).body(new BaseDto("Mã môn không tồn tại", false));
		}
		LopTinChiEntity ltcEntity = ltcRepository.findOneByMaLopTinChi(newLTC.getMaLopTinChi()).orElse(null);
		return ltcEntity!=null 
				? ResponseEntity.ok().body(new BaseDto("ok", false, modelMapper.map(ltcRepository.save(modelMapper.map(newLTC, LopTinChiEntity.class)), LopTinChiDto.class)))
				: ResponseEntity.status(202).body(new BaseDto("Mã lớp tín chỉ chưa tồn tại không thể sửa", true));
	}

	@Override
	public Page<LopTinChiDto> findAllByMaMonAndHocKiAndNamWithPaginateAndSorting(String maMon, int hocKi, int nam,
			int offset, int perPage, String field, String sort) {
		if(field.equals("")) {
			return ltcRepository.findAllByMaMonAndHocKiAndNam(maMon, hocKi, nam ,new PageRequest(offset, perPage)).orElse(null).map(new Converter<LopTinChiEntity, LopTinChiDto>(){
				@Override
				public LopTinChiDto convert(LopTinChiEntity source) {
					return modelMapper.map(source, LopTinChiDto.class);
				}
				
			});
			   
		}else {
			Sort a= sort.equals("ASC") ? new Sort(Direction.ASC, field):new Sort(Direction.DESC, field);
			return ltcRepository.findAllByMaMonAndHocKiAndNam(maMon, hocKi, nam,new PageRequest(offset, perPage, a)).orElse(null).map(new Converter<LopTinChiEntity, LopTinChiDto>(){
				@Override
				public LopTinChiDto convert(LopTinChiEntity source) {
					return modelMapper.map(source, LopTinChiDto.class);
				}			
			});
		}
	}

	

	
}
