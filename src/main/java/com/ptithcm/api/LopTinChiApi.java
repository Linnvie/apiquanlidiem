package com.ptithcm.api;

import java.time.LocalDate;
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

import com.ptithcm.dto.BaseDto;
import com.ptithcm.dto.LopTinChiDto;
import com.ptithcm.service.impl.LopTinChiService;

@Controller
public class LopTinChiApi {
	@Autowired
	private LopTinChiService ltcService;
	
	@PostMapping("/ltc")
	public ResponseEntity<?> save(@Valid @RequestBody LopTinChiDto newLTC,BindingResult bindingResult) {
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
			return ltcService.save(newLTC);
		} catch (Exception ex) {
			return ResponseEntity.status(404).body(new BaseDto("Lỗi"+ex, true));
		}
	}
	
	@PutMapping("/ltc")
	public ResponseEntity<?> update(@Valid @RequestBody LopTinChiDto newLTC,BindingResult bindingResult) {
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
			return ltcService.update(newLTC);
		} catch (Exception ex) {
			return ResponseEntity.status(404).body(new BaseDto("Lỗi"+ex, true));
		}
	}
	
	@GetMapping("/ltc")
    public ResponseEntity<?> finAllLTCByMaLTC(@RequestParam(name="maMon",defaultValue="",required=false) String maMon,
    		@RequestParam(name="offset",defaultValue="0",required=false) int offset,
   		 @RequestParam(name="perPage",defaultValue="10",required=false) int perPage,
   		 @RequestParam(name= "field",defaultValue="",required=false) String field,
   		 @RequestParam(name= "sort",defaultValue="ASC",required=false) String sort) {
		try {
			return ResponseEntity.ok(new BaseDto("ok", false, ltcService.findAllByMaMonWithPaginateAndSorting(maMon, offset, perPage, field, sort)));
		} catch(Exception ex) {
			return ResponseEntity.status(404).body(new BaseDto("Lỗi "+ex, false));
		}
	}
	
	@GetMapping("/ltchk")
    public ResponseEntity<?> finAllLTCbByMaLTCAndHKAndNam(@RequestParam(name="maMon",defaultValue="",required=false) String maMon,
    		@RequestParam(name="hocKi",defaultValue="1",required=false) int hocKi,
    		@RequestParam(name="nam",defaultValue="0",required=false) int nam,
    		@RequestParam(name="offset",defaultValue="0",required=false) int offset,
   		 @RequestParam(name="perPage",defaultValue="10",required=false) int perPage,
   		 @RequestParam(name= "field",defaultValue="",required=false) String field,
   		 @RequestParam(name= "sort",defaultValue="ASC",required=false) String sort) {
		try {
			if(nam==0) {
				nam=LocalDate.now().getYear();
			}
			return ResponseEntity.ok(new BaseDto("ok", false,
					ltcService.findAllByMaMonAndHocKiAndNamWithPaginateAndSorting(maMon, hocKi, nam, offset, perPage, field, sort)));
		} catch(Exception ex) {
			return ResponseEntity.status(404).body(new BaseDto("Lỗi "+ex, false));
		}
	}

}
