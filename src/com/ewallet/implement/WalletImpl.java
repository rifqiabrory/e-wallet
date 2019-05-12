package com.ewallet.implement;

import com.ewallet.config.Config;
import com.ewallet.controller.WalletController;
import com.ewallet.entity.AccountEntity;
import com.ewallet.entity.WalletEntity;
import com.ewallet.interfaces.WalletInterface;

public class WalletImpl implements WalletInterface{

	private static WalletController walletController;
	
	public WalletImpl() {
		walletController = new WalletController(Config.getConnection());
	}

	@Override
	public void addWalletAccount(WalletEntity walletAccount) {
		walletController.addWalletAccount(walletAccount);
	}

	public void addWallet(WalletEntity wallet, int idWallet) {
		walletController.addWallet(wallet,idWallet);
	}
	
}
