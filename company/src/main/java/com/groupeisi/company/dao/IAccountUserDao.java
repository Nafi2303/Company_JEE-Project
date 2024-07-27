package com.groupeisi.company.dao;

import java.util.List;
import java.util.Optional;

import com.groupeisi.company.entities.AccountUserEntity;

public interface IAccountUserDao extends Repository<AccountUserEntity>{
	
	Optional<AccountUserEntity> login(String email, String password);
}
