package com.ptithcm.api;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ptithcm.dto.AccountDto;
import com.ptithcm.dto.BaseDto;
import com.ptithcm.dto.SinhVienDto;
import com.ptithcm.service.IAccountService;
import com.ptithcm.service.ISinhVienService;

@RestController
public class account {
	@Autowired
	private IAccountService accountService;
	
	@Autowired
	private ISinhVienService svService;

	@GetMapping("/account")
	public ResponseEntity<BaseDto> testAPI() {
		return ResponseEntity.status(200).body(new BaseDto("ok",false,accountService.getAll()));
	}

	@PostMapping("/account")
	public ResponseEntity<BaseDto> createSV(@RequestBody SinhVienDto newSV) {
		System.out.print(newSV.toString());
		//Object a= new SinhVienDto();
		//return ResponseEntity.status(200).body(new BaseDto("ok", false, svService.save(newSV)));
		if(newSV.getAccount().getUsername().equals(newSV.getMssv())==false) {
			return ResponseEntity.status(202).body(new BaseDto("Mã số sinh viên chính là username, buộc phải trùng nhau " , false));
		}
		SinhVienDto saved= svService.save(newSV);
		if(saved==null) {
			return ResponseEntity.status(202).body(new BaseDto("Đã tồn tai sinh viên "+newSV.getMssv() , false));
		}
		URI productURI = URI.create("/students/" + saved.getMssv());
        return ResponseEntity.created(productURI).body(new BaseDto("ok", false, saved));
		
	}
	
	@PutMapping("/accountchangePw")
	public ResponseEntity<BaseDto> updatePassword(@RequestBody AccountDto newAccount) {
		AccountDto saved= accountService.update(newAccount);
		if(saved==null) {
			return ResponseEntity.status(202).body(new BaseDto("Không tồn tại tài khoản "+newAccount.getUsername() , false));
		}
        return ResponseEntity.ok().body(new BaseDto("ok", false, saved));
		
	}

}
