package com.ptithcm.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ptithcm.dto.MonDto;
import com.ptithcm.entity.MonEntity;
import com.ptithcm.repository.MonRepository;
import com.ptithcm.service.IMonService;


@Service
@Transactional
public class MonService implements IMonService{
	@Autowired
	private MonRepository monRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Page<MonDto> findAllMonWithPaginateAndSorting(String maMon, int offset, int perPage, String field, String sort) {
		if(field.isEmpty()) {
			return monRepository.findByMaMonContaining(maMon, new PageRequest(offset, perPage)).map(new Converter<MonEntity, MonDto>(){
			    @Override
			    public MonDto convert(MonEntity entity) { 
			        return modelMapper.map(entity, MonDto.class);
			    }
			});
		}else {
			Sort a= sort.equals("ASC") ? new Sort(Direction.ASC, field):new Sort(Direction.DESC, field);
			return monRepository.findByMaMonContaining(maMon,new PageRequest(offset, perPage, a)).map(new Converter<MonEntity, MonDto>(){
			    @Override
			    public MonDto convert(MonEntity entity) { 
			        return modelMapper.map(entity, MonDto.class);
			    }
			});
		}
//		if(field != null) {
//			Collections.sort(response.getContent(), new Comparator<MonDto>() {
//				@Override
//				public int compare(MonDto o1, MonDto o2) {
//					if(field.equals("maMon")) {
//						if(o1.getMaMon().compareTo(o2.getMaMon())) {
//							return 1;
//						}
//					}
//					return 0;
//				}
//			});
//		}
	}

	@Override
	public MonDto save(MonDto mon) {
		MonEntity entity = monRepository.findOneByMaMon(mon.getMaMon()).orElse(null);
		return entity==null ? modelMapper.map(monRepository.save(modelMapper.map(mon, MonEntity.class)), MonDto.class):null;
		//return null;
	}

	@Override
	public MonDto update(MonDto mon) {
		MonEntity entity = monRepository.findOneByMaMon(mon.getMaMon()).orElse(null);
		return entity!=null ? modelMapper.map(monRepository.save(modelMapper.map(mon, MonEntity.class)), MonDto.class):null;
	}


}
