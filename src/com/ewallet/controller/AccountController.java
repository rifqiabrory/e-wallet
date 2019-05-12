package com.ewallet.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ewallet.entity.AccountEntity;
import com.ewallet.entity.CustomerEntity;

public class AccountController {
	
	private Connection connect = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public AccountController(Connection connection) {
		connect = connection;
	}
	
	public void addAccount(AccountEntity account, int cosnum) {
		
		try {
			
			preparedStatement = connect.prepareStatement("INSERT INTO tbl_account (account_number,account_name,open_date,balance,customer_number)"
					+ "VALUE (?,?,?,?,?)");
			preparedStatement.setInt(1, account.getAccount_number());
			preparedStatement.setString(2, account.getAccount_name());
			preparedStatement.setString(3, account.getOpen_date());
			preparedStatement.setInt(4, account.getBalance());
			preparedStatement.setInt(5, cosnum);
			preparedStatement.execute();
			
			System.out.println("Successfully added!");
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("Failed to add!");
		}
	}

	public List<AccountEntity> getAllAccount() throws Exception {
		List<AccountEntity> list = new ArrayList<>();
		try {
			preparedStatement = connect.prepareStatement("SELECT * FROM tbl_account");
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				AccountEntity account = new AccountEntity();
				account.setAccount_number(resultSet.getInt("account_number"));
				account.setAccount_name(resultSet.getString("account_name"));
				account.setOpen_date(resultSet.getString("open_date"));
				account.setBalance(resultSet.getInt("balance"));
				list.add(account);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return list;
	}
}
