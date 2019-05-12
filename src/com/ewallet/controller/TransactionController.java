package com.ewallet.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ewallet.entity.AccountEntity;
import com.ewallet.entity.CustomerEntity;
import com.ewallet.entity.TransactionEntity;

public class TransactionController {
	private Connection connect = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public TransactionController(Connection connection) {
		connect = connection;
	}

	public void addDebit(TransactionEntity trans) {
		AccountEntity account =new AccountEntity();
		if(account.getBalance() >= trans.getAmount()) {
			System.out.print("Saldo tidak mencukupi!");
		}else {
			try {
				
				preparedStatement = connect.prepareStatement("INSERT INTO tbl_transaction (date,an_debit,an_credit,amount,transaction_type)" + "VALUE (?,?,null,?,?)");
				preparedStatement.setString(1, trans.getDate());
				preparedStatement.setInt(2, trans.getAccount_number());
				preparedStatement.setInt(3, trans.getAmount());
				preparedStatement.setInt(4, trans.getTransaction_typeTr());
				preparedStatement.execute();
				//Select
				preparedStatement = connect.prepareStatement("SELECT * FROM tbl_account WHERE account_number =?");
				preparedStatement.setInt(1, trans.getAccount_number());
				resultSet = preparedStatement.executeQuery();
					while (resultSet.next()) {
						account.setAccount_number(resultSet.getInt("account_number"));
						account.setAccount_name(resultSet.getString("account_name"));
						account.setOpen_date(resultSet.getString("open_date"));
						account.setBalance(resultSet.getInt("balance"));
						account.setCustomer_number(resultSet.getInt("customer_number"));
						
					}
				
				
				int lm = account.getBalance();
				int br = lm + trans.getAmount();
				account.setBalance(br);
				preparedStatement = connect.prepareStatement("UPDATE tbl_account SET balance = ? WHERE account_number =?");
				preparedStatement.setInt(1, br);
				preparedStatement.setInt(2, trans.getAccount_number());
				preparedStatement.execute();
				System.out.println("Successfully!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	
	public void addCredit(TransactionEntity trans) {
		AccountEntity account =new AccountEntity();
		if(account.getBalance() >= trans.getAmount()) {
			System.out.print("Saldo tidak mencukupi!");
		}else {
			try {
				
				preparedStatement = connect.prepareStatement("INSERT INTO tbl_transaction (date,an_debit,an_credit,amount,transaction_type)" + "VALUE (?,null,?,?,?)");
				preparedStatement.setString(1, trans.getDate());
				preparedStatement.setInt(2, trans.getAccount_number());
				preparedStatement.setInt(3, trans.getAmount());
				preparedStatement.setInt(4, trans.getTransaction_typeTr());
				preparedStatement.execute();
				//Select
				preparedStatement = connect.prepareStatement("SELECT * FROM tbl_account WHERE account_number =?");
				preparedStatement.setInt(1, trans.getAccount_number());
				resultSet = preparedStatement.executeQuery();
					while (resultSet.next()) {
						account.setAccount_number(resultSet.getInt("account_number"));
						account.setAccount_name(resultSet.getString("account_name"));
						account.setOpen_date(resultSet.getString("open_date"));
						account.setBalance(resultSet.getInt("balance"));
						account.setCustomer_number(resultSet.getInt("customer_number"));
						
					}
				
				int lm = account.getBalance();
				int br = lm - trans.getAmount();
				account.setBalance(br);
				preparedStatement = connect.prepareStatement("UPDATE tbl_account SET balance = ? WHERE account_number =?");
				preparedStatement.setInt(1, br);
				preparedStatement.setInt(2, trans.getAccount_number());
				preparedStatement.execute();
				System.out.println("Successfully!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
