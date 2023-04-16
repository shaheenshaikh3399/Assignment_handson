package com.hansdon.app.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hansdon.app.entity.Customer;
import com.hansdon.app.exception.ResourceNotFoundException;
import com.hansdon.app.repository.CustomerRepository;
import com.hansdon.app.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		List<Customer> allCust = new ArrayList<>();
		 allCust = customerRepository.findAll();
		return allCust;
	}

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);		
		 
	}

	@Override
	public Customer updateCustomer(Customer customer, Integer customerId) {
		// TODO Auto-generated method stub
		
		Customer oldCustomer = customerRepository.findById(customerId).orElseThrow(()-> new ResourceNotFoundException("customer", "customer Id", customerId));
		
		//oldCustomer.setCustomerId(customer.getCustomerId());
		oldCustomer.setCustomerName(customer.getCustomerName());
		oldCustomer.setCustomerAddress(customer.getCustomerAddress());
		Customer updatedCust= customerRepository.save(oldCustomer);
		return updatedCust;
		
	}

	@Override
	public void deleteCustomerById(Integer customerId) {
		Customer existustomer = customerRepository.findById(customerId).orElseThrow(()-> new ResourceNotFoundException("customer", "customer Id", customerId));
	customerRepository.delete(existustomer);

		// TODO Auto-generated method stub
		
	}
	
	public void deleteCustomer(Customer customer) {
		customerRepository.delete(customer);
	}

}
