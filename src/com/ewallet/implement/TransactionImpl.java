package com.ewallet.implement;

import com.ewallet.config.Config;
import com.ewallet.controller.TransactionController;
import com.ewallet.controller.WalletController;
import com.ewallet.entity.TransactionEntity;
import com.ewallet.interfaces.TransactionInterface;

public class TransactionImpl implements TransactionInterface{
	
	private static TransactionController transactionController;
	
	public TransactionImpl() {
		transactionController = new TransactionController(Config.getConnection());
	}

	public void addDebit(TransactionEntity trans) {
		transactionController.addDebit(trans);
	}
	
	public void addCredit(TransactionEntity trans) {
		transactionController.addCredit(trans);
	}

	
}
