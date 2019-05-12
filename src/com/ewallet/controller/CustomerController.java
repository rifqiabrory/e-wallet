package com.ewallet.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ewallet.entity.CustomerEntity;

public class CustomerController {
	
	private Connection connect = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public CustomerController(Connection connection) {
		connect = connection;
	}
	
	
	public List<CustomerEntity> getAllCustomer() throws Exception {
		List<CustomerEntity> list = new ArrayList<>();
		try {
			preparedStatement = connect.prepareStatement("SELECT * FROM tbl_customer");
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				CustomerEntity customer = new CustomerEntity();
				customer.setCustomer_number(resultSet.getInt("customer_number"));
				customer.setFirstname(resultSet.getString("firstname"));
				customer.setLastname(resultSet.getString("lastname"));
				customer.setBirthdate(resultSet.getString("birthdate"));
				list.add(customer);
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
	
	public CustomerEntity getDetail(int id) {
		CustomerEntity customer = new CustomerEntity();
		
		try {
			preparedStatement = connect.prepareStatement("SELECT * FROM tbl_customer WHERE customer_number=?");
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				customer.setCustomer_number(resultSet.getInt("customer_number"));
				customer.setFirstname(resultSet.getString("firstname"));
				customer.setLastname(resultSet.getString("lastname"));
				customer.setBirthdate(resultSet.getString("birthdate"));
			}
			preparedStatement.close();
		} catch (Exception e) {
			//e.printStackTrace();
		}
		return customer;
	}
	
	public void addCustomer(CustomerEntity customer) {
		
		try {
			preparedStatement = connect.prepareStatement("INSERT INTO tbl_customer (customer_number,firstname,lastname,birthdate)" + "VALUE (?,?,?,?)");
			preparedStatement.setInt(1, customer.getCustomer_number());
			preparedStatement.setString(2, customer.getFirstname());
			preparedStatement.setString(3, customer.getLastname());
			preparedStatement.setString(4, customer.getBirthdate());
			preparedStatement.execute();
			
			System.out.println("Successfully added!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
