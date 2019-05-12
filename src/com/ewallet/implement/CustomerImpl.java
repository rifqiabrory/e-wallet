package com.ewallet.implement;

import java.util.ArrayList;
import java.util.List;

import com.ewallet.config.Config;
import com.ewallet.controller.CustomerController;
import com.ewallet.entity.CustomerEntity;
import com.ewallet.interfaces.CustomerInterface;

public class CustomerImpl implements CustomerInterface{

	private static CustomerController customerController;
	
	public CustomerImpl() {
		customerController = new CustomerController(Config.getConnection());
	}
	
	@Override
	public List<CustomerEntity> getAllCustomer() {
		List<CustomerEntity> list = new ArrayList<>();
		try {
			list = customerController.getAllCustomer();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public CustomerEntity getById(int id) {
		return customerController.getDetail(id);
	}

	@Override
	public void addCustomer(CustomerEntity customer) {
		customerController.addCustomer(customer);
	}

}
