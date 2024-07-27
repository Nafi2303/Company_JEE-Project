package com.groupeisi.company.service;

import java.util.List;
import java.util.Optional;

import com.groupeisi.company.dto.AccountUserDto;

public interface IAccountUserService {

Optional<AccountUserDto> login(String email, String password);
	
	Optional<List<AccountUserDto>> findAll();
	
	boolean save(AccountUserDto accountUserDto);

}
