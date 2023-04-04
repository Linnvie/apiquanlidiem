package com.ptithcm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ptithcm.dto.AccountDto;
import com.ptithcm.entity.AccountEntity;
import com.ptithcm.repository.AccountRepository;
import com.ptithcm.service.IAccountService;

@Service
@Transactional
public class AccountService implements IAccountService{
	@Autowired
	private ModelMapper modelMapper;
	

	
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public List<AccountDto> getAll() {
		List<AccountDto> list= new ArrayList<AccountDto>();
		accountRepository.getAll().forEach((account)->{
			account.setPassword("");
			list.add(modelMapper.map(account, AccountDto.class));
		});
		return list;
	}

	@Override
	public AccountDto update(AccountDto accountDto) {
		AccountEntity entity=accountRepository.findOneByUsername(accountDto.getUsername()).orElse(null);
		if(entity==null) {
			return null;
		}
		
	//	accountDto.setPassword(passwordEncoder().encode(accountDto.getPassword()));
		accountDto.setRole(entity.getRole());
		accountDto.setStatus(entity.getStatus());
		accountDto.setUsername(entity.getUsername());
		accountDto.setPassword(BCrypt.hashpw(accountDto.getPassword(), BCrypt.gensalt(12)));
		AccountDto response= modelMapper.map(accountRepository.save(modelMapper.map(accountDto, AccountEntity.class)),AccountDto.class);
		response.setPassword("");
		return response;
	}
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
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
