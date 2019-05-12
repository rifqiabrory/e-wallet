package com.ewallet.entity;

public class TransactionEntity {
	//transaction type setter & getter
	private int transaction_type;
	private String description;
	//transaction setter & getter
	private int id_transaction;
	private String date;
	private int account_number;
	private int amount;
	private int transaction_typeTr;
	
	public int getTransaction_type() {
		return transaction_type;
	}
	public void setTransaction_type(int transaction_type) {
		this.transaction_type = transaction_type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId_transaction() {
		return id_transaction;
	}
	public void setId_transaction(int id_transaction) {
		this.id_transaction = id_transaction;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public int getAccount_number() {
		return account_number;
	}
	public void setAccount_number(int account_number) {
		this.account_number = account_number;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getTransaction_typeTr() {
		return transaction_typeTr;
	}
	public void setTransaction_typeTr(int transaction_typeTr) {
		this.transaction_typeTr = transaction_typeTr;
	}
	
	
}
