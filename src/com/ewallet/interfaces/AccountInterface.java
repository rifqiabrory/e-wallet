package com.ewallet.interfaces;

import java.util.List;

import com.ewallet.entity.AccountEntity;

public interface AccountInterface {
	List<AccountEntity> getAllAccount();
	//AccountEntity getById(int id);
	void addAccount(AccountEntity account, int cusnum);
}
