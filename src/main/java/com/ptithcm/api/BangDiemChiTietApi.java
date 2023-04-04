package com.ptithcm.api;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.ptithcm.dto.BangDiemChiTietDto;
import com.ptithcm.dto.BaseDto;
import com.ptithcm.service.IBangDiemChiTietService;

@Controller
public class BangDiemChiTietApi {
	@Autowired
	private IBangDiemChiTietService bangDiemCTService;
	
	@PostMapping("/dangkiltc")
	public ResponseEntity<?> save(@Valid @RequestBody BangDiemChiTietDto newBangDiemCT, BindingResult bindingResult){
		try {
			if(bindingResult.hasErrors()){
				Map<String, String> errors= new HashMap<>();
	            bindingResult.getFieldErrors().forEach(
	                    error -> errors.put(error.getField(), error.getDefaultMessage())
	            );
	            String errorMsg= "";
	            for(String key: errors.keySet()){
	                errorMsg+= key + ": " + errors.get(key) + "; ";
	            }
				return ResponseEntity.badRequest().body(new BaseDto(errorMsg, true));
			}
			return  bangDiemCTService.save(newBangDiemCT);
		} catch (Exception e) {
			return ResponseEntity.status(404).body(new BaseDto("Lỗi"+e, true));
		}
	}
	
	@PutMapping("/diem")
	public ResponseEntity<?> update(@Valid @RequestBody BangDiemChiTietDto newBangDiemCT, BindingResult bindingResult){
		try {
			if(bindingResult.hasErrors()){
				Map<String, String> errors= new HashMap<>();
	            bindingResult.getFieldErrors().forEach(
	                    error -> errors.put(error.getField(), error.getDefaultMessage())
	            );
	            String errorMsg= "";
	            for(String key: errors.keySet()){
	                errorMsg+= key + ": " + errors.get(key) + "; ";
	            }
				return ResponseEntity.badRequest().body(new BaseDto(errorMsg, true));
			}
			return  bangDiemCTService.update(newBangDiemCT);
		} catch (Exception e) {
			return ResponseEntity.status(404).body(new BaseDto("Lỗi"+e, true));
		}
	}
	
	@GetMapping("/diem")
    public ResponseEntity<?> findOneByMSSVAndMaLTC( @RequestParam(name="mssv",defaultValue="",required=false) String mssv,
    		@RequestParam(name="maLTC",defaultValue="",required=false) String maLTC) {
		try {
			return bangDiemCTService.findOneByMSSVAndMaLTC(mssv, maLTC);
		} catch(Exception ex) {
			return ResponseEntity.status(404).body(new BaseDto("Lỗi"+ex, false));
		}
	}
}
