package com.hansdon.app.service;

import java.util.List;

import com.hansdon.app.entity.Customer;

public interface CustomerService {
	
public List<Customer> getAllCustomer();
	
	public Customer addCustomer(Customer customer);
	
	public Customer updateCustomer(Customer customer, Integer customerId);
	
	public void deleteCustomerById(Integer customerId);
	
	public void deleteCustomer(Customer customer);

}
