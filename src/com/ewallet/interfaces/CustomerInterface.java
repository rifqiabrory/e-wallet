package com.ewallet.interfaces;

import java.util.List;

import com.ewallet.entity.CustomerEntity;

public interface CustomerInterface {
	
	List<CustomerEntity> getAllCustomer();
	CustomerEntity getById(int id);
	void addCustomer(CustomerEntity customer);
	
}
