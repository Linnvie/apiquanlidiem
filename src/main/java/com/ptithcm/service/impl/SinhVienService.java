package com.ptithcm.service.impl;

import org.mindrot.jbcrypt.BCrypt;
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
import com.ptithcm.dto.SinhVienDto;
import com.ptithcm.dto.TTSinhVienDto;
import com.ptithcm.entity.SinhVienEntity;
import com.ptithcm.repository.SinhVienRepository;
import com.ptithcm.service.ISinhVienService;

@Service
@Transactional
public class SinhVienService implements ISinhVienService{
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private SinhVienRepository svRepository;

	@Override
	public SinhVienDto save(SinhVienDto sinhVienDto) {
		if(svRepository.findOneByMssv(sinhVienDto.getMssv()).orElse(null)!=null) {
			return null;
		}
		
		sinhVienDto.getAccount().setPassword(BCrypt.hashpw(sinhVienDto.getAccount().getPassword(), BCrypt.gensalt(12)));
		//sinhVienDto.setPassword(BCrypt.hashpw(SinhVienDto.getPassword(), BCrypt.gensalt(12)));
		SinhVienDto response= modelMapper.map(svRepository.save(modelMapper.map(sinhVienDto, SinhVienEntity.class)),SinhVienDto.class);
		response.getAccount().setPassword("");
		return response;
	}

	@Override
	public Page<TTSinhVienDto> findAllByMaLTCWithPaginateAndSorting(String maLTC, int offset, int perPage, String field,
			String sort) {
		if(field.equals("")) {
			return svRepository.findAllByMaLTC(maLTC, new PageRequest(offset, perPage)).orElse(null);
			//List<TTSinhVienDto> objs2= new ArrayList<TTSinhVienDto>();
//			return svRepository.findAllByMaLTC(maLTC, new PageRequest(offset, perPage)).orElse(null).map(new Converter<Object, TTSinhVienDto>() {
//
//				@Override
//				public TTSinhVienDto convert(Object source) {
//					return modelMapper.map(source, TTSinhVienDto.class);
//				}
//			});
//			for(Object obj : objs.getContent()) {
//				objs2.add(modelMapper.map(obj, TTSinhVienDto.class));
//			};
		}else {
			Sort a= sort.equals("ASC") ? new Sort(Direction.ASC, field):new Sort(Direction.DESC, field);
			return svRepository.findAllByMaLTC(maLTC, new PageRequest(offset, perPage,a)).orElse(null);
		}
	}

	@Override
	public Page<SinhVienDto> findAllByMaLopCWithPaginateAndSorting(String maLop, int offset, int perPage, String field,
			String sort) {
		if(field.equals("")) {
			return svRepository.findAllByMaLop(maLop, new PageRequest(offset, perPage)).orElse(null).map(new Converter<SinhVienEntity, SinhVienDto>() {

				@Override
				public SinhVienDto convert(SinhVienEntity source) {
					return modelMapper.map(source, SinhVienDto.class);
				}
			});
			   
		}else {
			Sort a= sort.equals("ASC") ? new Sort(Direction.ASC, field):new Sort(Direction.DESC, field);
			return svRepository.findAllByMaLop(maLop, new PageRequest(offset, perPage,a)).orElse(null).map(new Converter<SinhVienEntity, SinhVienDto>() {

				@Override
				public SinhVienDto convert(SinhVienEntity source) {
					return modelMapper.map(source, SinhVienDto.class);
				}
			});
		}
	}

	@Override
	public ResponseEntity<BaseDto> findOneByMSSV(String mssv) {
		SinhVienEntity entity = svRepository.findOneByMssv(mssv).orElse(null);
		return entity==null ? ResponseEntity.status(202).body(new BaseDto("Không tồn tại sinh viên mã "+mssv, false))
				:ResponseEntity.ok().body(new BaseDto("ok", false,modelMapper.map(entity, SinhVienDto.class)));
	}



//	@Override
//	public AccountDto saveAccount(AccountDto accountDto) {
//		AccountEntity accountEntity= modelMapper.map(accountDto, AccountEntity.class);
////		AccountEntity c = accountRepository.saveAccount(b.getUsername(),b.getPassword(),b.getStatus(),b.getMaQuyen(),
////				nvDto.getMaNV(), nvDto.getHo(), nvDto.getTen(), nvDto.getDiaChi(), nvDto.getNgaySinh(), nvDto.getGioiTinh(), nvDto.getLaQL());
//		AccountEntity c = accountRepository.save(accountEntity);
//		return modelMapper.map(c, AccountDto.class);
//	}



}
