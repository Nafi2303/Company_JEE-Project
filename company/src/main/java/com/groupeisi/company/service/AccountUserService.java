package com.groupeisi.company.service;

import java.util.List;
import java.util.Optional;

import com.groupeisi.company.dao.AccountUserDao;
import com.groupeisi.company.dao.IAccountUserDao;
import com.groupeisi.company.dto.AccountUserDto;
import com.groupeisi.company.entities.AccountUserEntity;
import com.groupeisi.company.mapper.AccountUserMapper;
import com.groupeisi.company.service.IAccountUserService;

public class AccountUserService implements IAccountUserService{

	private IAccountUserDao accountUserDao = new AccountUserDao();
	
	/**
	 * Cette méthode permet de vérifier les identifiants d'un utilisateur à partir de son mail et de son mot de passe.
	 * @email : représente l'email de l'utilisateur.
	 * @password : représente le mot de passe de l'utilisateur.
	 * La fonction retourne un Optional de AccountUserDto qui peut être vide ou pas.
	 */
	@Override
	public Optional<AccountUserDto> login(String email, String password) {
		
		if(email.isBlank() || password.isBlank()) {
			return Optional.empty();
		}
		else {
			return testLogin(email, password);
		}
	}

	private Optional<AccountUserDto> testLogin(String email, String password) {
		
		Optional<AccountUserEntity> accountUserEntity = accountUserDao.login(email, password);

		if(accountUserEntity.isPresent()) {
			AccountUserDto accountUserDto = AccountUserMapper.toAccountUserDto(accountUserEntity.get());
			return Optional.of(accountUserDto);
		}
		else {
			return Optional.empty();
		}
	}

	@Override
	public Optional<List<AccountUserDto>> findAll() {
		List<AccountUserEntity> accountUserEntityList = accountUserDao.list(new AccountUserEntity());
		
		return Optional.of(AccountUserMapper.toListeAccountUserDto(accountUserEntityList));  //toListAccountUserDto(accountUserEntityList));
	}

	public void setAccountUserDao(IAccountUserDao accountUserDao) {
		this.accountUserDao = accountUserDao;
	}

	@Override
	public boolean save(AccountUserDto accountUserDto) {
		return accountUserDao.save(AccountUserMapper.toAccountUserEntity(accountUserDto));
	}
	
	

}
