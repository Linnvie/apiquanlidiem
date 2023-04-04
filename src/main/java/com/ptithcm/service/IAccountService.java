package com.ptithcm.service;

import java.util.List;

import com.ptithcm.dto.AccountDto;

public interface IAccountService {
	List<AccountDto> getAll();
	AccountDto update(AccountDto accountDto);
}
