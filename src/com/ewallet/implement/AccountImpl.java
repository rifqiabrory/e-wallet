package com.ewallet.implement;

import java.util.ArrayList;
import java.util.List;

import com.ewallet.config.Config;
import com.ewallet.controller.AccountController;
import com.ewallet.entity.AccountEntity;
import com.ewallet.interfaces.AccountInterface;

public class AccountImpl implements AccountInterface{

	private static AccountController accountController;
	
	public AccountImpl() {
		accountController = new AccountController(Config.getConnection());
	}
	
	@Override
	public List<AccountEntity> getAllAccount() {
		List<AccountEntity> list = new ArrayList<>();
		try {
			list = accountController.getAllAccount();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

//	@Override
//	public AccountEntity getById(int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public void addAccount(AccountEntity account, int cusnum) {
		accountController.addAccount(account,cusnum);
	}


}
