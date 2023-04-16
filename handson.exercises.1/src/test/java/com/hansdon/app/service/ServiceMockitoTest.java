package com.hansdon.app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.hansdon.app.entity.Customer;
import com.hansdon.app.repository.CustomerRepository;
import com.hansdon.app.serviceImpl.CustomerServiceImpl;

@SpringBootTest(classes= {ServiceMockitoTest.class})
public class ServiceMockitoTest {
	
	@Mock
	CustomerRepository customerRepository;
	
	@InjectMocks
	CustomerServiceImpl customerService;
	
	public List<Customer> myCustomers;
	
	@Test
	public void test_getAllCustomer() {
		List<Customer> myCustomers = new ArrayList<>();
		myCustomers.add(new Customer(1,"Shaheen", "Mumbai"));
		myCustomers.add(new Customer(2,"Aamir", "Delhi"));

		myCustomers.add(new Customer(3,"Snehal", "Banglore"));

		when(customerRepository.findAll()).thenReturn(myCustomers);//Mocking
		assertEquals(3, customerService.getAllCustomer().size());
		
		
	}
	@Test
	public void test_addCustomer() {
		Customer customer = new Customer(1,"Shaheen", "Mumbai");
		when(customerRepository.save(customer)).thenReturn(customer);
	 assertEquals(customer, customerService.addCustomer(customer));
	 
	}
	
	//@Test
	/*
	 * public void test_updateCustomer() { Optional<Customer> customer =
	 * Optional.ofNullable(new Customer(1,"Shaheen", "Mumbai"));
	 * 
	 * Integer customerId=1;
	 * when(customerRepository.findById(customerId)).thenReturn(customer);
	 * assertEquals(customerId, customerService.updateCustomer(customer,
	 * customerId).getCustomerId());
	 * 
	 * }
	 */
	
	@Test
	public void test_deleteCustomer() {
		Customer customer = new Customer(1,"Shaheen", "Mumbai");

		customerService.deleteCustomer(customer);
		verify(customerRepository,times(1)).delete(customer);
	}
	

}
