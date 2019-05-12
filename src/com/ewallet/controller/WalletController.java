package com.ewallet.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ewallet.entity.WalletEntity;

public class WalletController {

	private Connection connect = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public WalletController(Connection connection) {
		connect = connection;
	}
	
	public void addWalletAccount(WalletEntity walletAccount) {
		
		try {
			preparedStatement = connect.prepareStatement("INSERT INTO tbl_wallet_account (id_wallet,account_number)" + "VALUE (?,?)");
			preparedStatement.setInt(1, walletAccount.getId_wallet());
			preparedStatement.setInt(2, walletAccount.getAccount_number());
			preparedStatement.execute();
			
			//System.out.println("Successfully added!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addWallet(WalletEntity wallet, int idWallet) {
		try {
			
			preparedStatement = connect.prepareStatement("INSERT INTO tbl_wallet (id_wallet,description,created_date)"
					+ "VALUE (?,?,?)");
			preparedStatement.setInt(1, idWallet);
			preparedStatement.setString(2, wallet.getDescription());
			preparedStatement.setString(3, wallet.getCreated_date());
			preparedStatement.execute();
			
			System.out.println("Successfully added!");
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("Failed to add!");
		}
	}
	
}
