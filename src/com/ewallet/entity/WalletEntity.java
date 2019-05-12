package com.ewallet.entity;

public class WalletEntity {
	//wallet account
	private int id_wallet;
	private int account_number;
	//wallet
	private int wallet_id;
	private String description;
	private String created_date;
	
	//wallet account setter & getter
	public int getId_wallet() {
		return id_wallet;
	}
	public void setId_wallet(int id_wallet) {
		this.id_wallet = id_wallet;
	}
	public int getAccount_number() {
		return account_number;
	}
	public void setAccount_number(int account_number) {
		this.account_number = account_number;
	}
	//wallet setter & getter
	public int getWallet_id() {
		return wallet_id;
	}
	public void setWallet_id(int wallet_id) {
		this.wallet_id = wallet_id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreated_date() {
		return created_date;
	}
	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}
	
	
}
