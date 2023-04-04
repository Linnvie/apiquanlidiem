package com.ptithcm.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ptithcm.dto.BaseDto;
import com.ptithcm.dto.SinhVienDto;
import com.ptithcm.dto.TTSinhVienDto;
import com.ptithcm.service.ILopTinChiService;
import com.ptithcm.service.ISinhVienService;

@RestController
public class SinhVienApi {
	@Autowired
	private ISinhVienService svService;
	
	@Autowired
	private ILopTinChiService ltcService;
	
	@GetMapping("/svltc")
    public ResponseEntity<?> findAllByMaLTCWithPaginateAndSorting(@RequestParam(name="maLTC",defaultValue="",required=false) String maLTC,
    		@RequestParam(name="offset",defaultValue="0",required=false) int offset,
    		 @RequestParam(name="perPage",defaultValue="10",required=false) int perPage,
    		 @RequestParam(name= "field",defaultValue="",required=false) String field,
    		 @RequestParam(name= "sort",defaultValue="ASC",required=false) String sort) {
		try {
			if(ltcService.findOneByMaLopTinChi(maLTC)==null) {
				return ResponseEntity.status(202).body(new BaseDto("Lớp "+maLTC +"không tồn tại!",false));
			}
			Page<TTSinhVienDto> page=svService.findAllByMaLTCWithPaginateAndSorting(maLTC, offset, perPage, field, sort);
			return page.getContent().size()==0? ResponseEntity.status(202).body(new BaseDto("Lớp "+maLTC +" chưa có sinh viên nào",false))
					:ResponseEntity.ok(new BaseDto("ok" ,false,page));
		} catch(Exception ex) {
			return ResponseEntity.status(404).body(new BaseDto("Lỗi"+ex, false));
		}
	}
	
	@GetMapping("/svlop")
    public ResponseEntity<?> findAllByMaLopCWithPaginateAndSorting(@RequestParam(name="maLop",defaultValue="",required=false) String maLop,
    		@RequestParam(name="offset",defaultValue="0",required=false) int offset,
    		 @RequestParam(name="perPage",defaultValue="10",required=false) int perPage,
    		 @RequestParam(name= "field",defaultValue="",required=false) String field,
    		 @RequestParam(name= "sort",defaultValue="ASC",required=false) String sort) {
		try {
//			if(ltcService.findOneByMaLop(maLop)==null) {
//				return ResponseEntity.ok(new BaseDto("Lớp "+maLTC +"không tồn tại!",false));
//			}
			Page<SinhVienDto> page=svService.findAllByMaLopCWithPaginateAndSorting(maLop, offset, perPage, field, sort);
			return page.getContent().size()==0? ResponseEntity.status(202).body(new BaseDto("Lớp "+maLop +" chưa có sinh viên nào",false))
					:ResponseEntity.ok(new BaseDto("ok" ,false,page));
		} catch(Exception ex) {
			return ResponseEntity.status(404).body(new BaseDto("Lỗi"+ex, false));
		}
	}
	
	@GetMapping("/sv")
    public ResponseEntity<?> findOneByMSSV(@RequestParam(name="mssv",defaultValue="",required=false) String mssv) {
		try {
			return svService.findOneByMSSV(mssv);
		} catch(Exception ex) {
			return ResponseEntity.status(404).body(new BaseDto("Lỗi"+ex, false));
		}
	}
}
