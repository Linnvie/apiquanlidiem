package com.ptithcm.service.impl;

import java.net.URI;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ptithcm.dto.BangDiemChiTietDto;
import com.ptithcm.dto.BaseDto;
import com.ptithcm.dto.TTBangDiemDto;
import com.ptithcm.entity.BangDiemChiTietEntity;
import com.ptithcm.entity.BangDiemChiTietKey;
import com.ptithcm.entity.LopTinChiEntity;
import com.ptithcm.repository.BangDiemChiTietRepository;
import com.ptithcm.repository.LopTinChiRepository;
import com.ptithcm.service.IBangDiemChiTietService;

@Service
@Transactional
public class BangDiemChiTietService implements IBangDiemChiTietService{
	
	@Autowired
	private BangDiemChiTietRepository bangDiemCTRe;
	
	@Autowired
	private LopTinChiRepository ltcCTRe;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ResponseEntity<BaseDto> findOneByMSSVAndMaLTC(String mssv, String maLTC) {
		BangDiemChiTietEntity entity = bangDiemCTRe.findOneById(new BangDiemChiTietKey(mssv, maLTC)).orElse(null);
		return entity==null?ResponseEntity.status(202).body(new BaseDto("Không tồn tại sinh viên phù hợp yêu cầu",false))
				: ResponseEntity.ok().body(new BaseDto("ok", false,modelMapper.map(entity, BangDiemChiTietDto.class)));
	}

	@Override
	public ResponseEntity<BaseDto> save(BangDiemChiTietDto bangDiemChiTiet) {
		LopTinChiEntity ltcEntity = ltcCTRe.findOneByMaLopTinChi(bangDiemChiTiet.getId().getMaLTC()).orElse(null);
		if(ltcEntity==null) {
			return ResponseEntity.status(200).body(new BaseDto("Không tồn tại lớp tín chỉ "+bangDiemChiTiet.getId().getMaLTC()+" để đăng kí", false));
		}
		if(ltcEntity.getTrangThai() && ltcEntity.getSlDangKi()<ltcEntity.getSoSVToiDa()) {
			BangDiemChiTietEntity diemEntity = bangDiemCTRe.findOneById(new BangDiemChiTietKey(bangDiemChiTiet.getId().getMssv(),bangDiemChiTiet.getId().getMaLTC())).orElse(null);
			URI diemURI = URI.create("/diem?mssv=" + bangDiemChiTiet.getId().getMssv()+"&maLTC="+bangDiemChiTiet.getId().getMaLTC());
			return diemEntity==null?ResponseEntity.created(diemURI).body(new BaseDto("ok", false, modelMapper.map(bangDiemCTRe.save(modelMapper.map(bangDiemChiTiet, BangDiemChiTietEntity.class)), BangDiemChiTietDto.class))) 
					:ResponseEntity.status(202).body(new BaseDto("Đã tồn tại sinh viên trong lớp tín chỉ này",false));
		}else {
			return ResponseEntity.status(202).body(new BaseDto("Lớp tín chỉ "+ltcEntity.getMaLopTinChi()+" đã đủ số lượng sinh viên", false));
		}
		
	}

	@Override
	public ResponseEntity<BaseDto> update(BangDiemChiTietDto bangDiemChiTiet) {
		BangDiemChiTietEntity entity = bangDiemCTRe.findOneById(new BangDiemChiTietKey(bangDiemChiTiet.getId().getMssv(),bangDiemChiTiet.getId().getMaLTC())).orElse(null);
		return entity!=null?ResponseEntity.ok().body(new BaseDto("ok", false, modelMapper.map(bangDiemCTRe.save(modelMapper.map(bangDiemChiTiet, BangDiemChiTietEntity.class)), BangDiemChiTietDto.class))) 
				:ResponseEntity.status(202).body(new BaseDto("Không tồn tại sinh viên hoặc lớp tín chỉ này",false));
	}

	@Override
	public ResponseEntity<BaseDto> findAllByMSSV(String mssv) {
		List<TTBangDiemDto> list= bangDiemCTRe.findAllByMSSV(mssv).orElse(null);
		return list==null? ResponseEntity.status(202).body(new BaseDto("Sinh viên chưa đăng kí môn học nào", false))
				: ResponseEntity.status(200).body(new BaseDto("ok", false, list));
	}

	@Override
	public ResponseEntity<BaseDto> findAllByMSSVAndHKAndNam(String mssv, int hocKi, int nam) {
		List<TTBangDiemDto> list= bangDiemCTRe.findAllByMSSVAndHocKiAndNam(mssv, hocKi, nam).orElse(null);
		return list==null? ResponseEntity.status(202).body(new BaseDto("Sinh viên chưa đăng kí môn học nào trong học kì "+hocKi+" năm "+nam, false))
				: ResponseEntity.status(200).body(new BaseDto("ok", false, list));
	}

	

}
