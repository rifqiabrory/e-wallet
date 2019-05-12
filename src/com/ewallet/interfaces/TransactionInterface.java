package com.ewallet.interfaces;

import com.ewallet.entity.TransactionEntity;

public interface TransactionInterface {
	void addDebit(TransactionEntity trans);
	void addCredit(TransactionEntity trans);
}
