package com.ewallet.interfaces;

import com.ewallet.entity.WalletEntity;

public interface WalletInterface {
	void addWalletAccount(WalletEntity walletAccount);
	void addWallet(WalletEntity wallet, int idWallet);
}
