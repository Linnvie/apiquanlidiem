package com.ptithcm.api;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ptithcm.dto.BaseDto;
import com.ptithcm.dto.MonDto;
import com.ptithcm.service.IMonService;

@RestController
public class MonApi {
	@Autowired
	private IMonService monService;
	
	@PostMapping("/mon")
	public ResponseEntity<?> save(@Valid @RequestBody MonDto mon, BindingResult bindingResult){
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

			if(mon.getHeSo1()+mon.getHeSo2()+mon.getHeSo3()!=1) {
				return ResponseEntity.status(400).body(new BaseDto("Tổng các hệ số phải bằng 1", true));
			}
			MonDto monDto= monService.save(mon);
			return  monDto==null?ResponseEntity.status(202).body(new BaseDto("Mã môn đã tồn tại", true))
					:ResponseEntity.ok(new BaseDto("Lưu thành công",false,monDto));
		} catch (Exception e) {
			return ResponseEntity.status(404).body(new BaseDto("Lỗi", true));
		}
	}
	
	@PutMapping("/mon")
	public ResponseEntity<?> update(@Valid @RequestBody MonDto mon,
			BindingResult bindingResult){
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
			if(mon.getHeSo1()+mon.getHeSo2()+mon.getHeSo3()!=1) {
				return ResponseEntity.status(400).body(new BaseDto("Tổng các hệ số phải bằng 1", true));
			}
			MonDto monDto= monService.update(mon);
			return  monDto==null?ResponseEntity.status(202).body(new BaseDto("Mã môn "+mon.getMaMon() +" chưa tồn tại", true))
					:ResponseEntity.ok(new BaseDto("Sửa thành công",false,monDto));
		} catch (Exception e) {
			return ResponseEntity.status(404).body(new BaseDto("Lỗi"+e, true));
		}
	}
	
	@GetMapping("/mon")
    public ResponseEntity<?> finAllMonWithPaginateAndSorting( @RequestParam(name="maMon",defaultValue="",required=false) String maMon,
    		@RequestParam(name="offset",defaultValue="0",required=false) int offset,
    		 @RequestParam(name="perPage",defaultValue="10",required=false) int perPage,
    		 @RequestParam(name= "field",defaultValue="",required=false) String field,
    		 @RequestParam(name= "sort",defaultValue="ASC",required=false) String sort) {
		try {
			return ResponseEntity.ok(monService.findAllMonWithPaginateAndSorting(maMon, offset, perPage, field, sort));
		} catch(Exception ex) {
			return ResponseEntity.status(404).body(new BaseDto("Lỗi"+ex, false));
		}
	}
}
