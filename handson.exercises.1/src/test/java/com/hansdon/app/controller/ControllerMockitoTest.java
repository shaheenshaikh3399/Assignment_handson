package com.hansdon.app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hansdon.app.entity.Customer;
import com.hansdon.app.payload.ApiResponse;
import com.hansdon.app.serviceImpl.CustomerServiceImpl;

@SpringBootTest(classes= ControllerMockitoTest.class)
public class ControllerMockitoTest {
	
	@Mock
	CustomerServiceImpl customerServiceImpl;
	
	@InjectMocks
	CustomerController customerController;
	
	List<Customer> myCustomers;
	Customer customer;
	
	@Test
	public void test_getCustomer() {
		List<Customer> myCustomers= new ArrayList<>();
		myCustomers.add(new Customer(1,"Shaheen", "Mumbai"));
		myCustomers.add(new Customer(2,"Aamir", "Delhi"));
		
		when(customerServiceImpl.getAllCustomer()).thenReturn(myCustomers);
		 ResponseEntity<List<Customer>> res= customerController.getAllCustomers();
		 assertEquals(HttpStatus.FOUND, res.getStatusCode());
		 assertEquals(2,res.getBody().size());
	}
	
	@Test
	public void test_addCustomer() {
		Customer customer = new Customer(1,"Shaheen", "Mumbai");

		when(customerServiceImpl.addCustomer(customer)).thenReturn(customer);
		ResponseEntity<Customer> response = customerController.addCustomer(customer);
		
		assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
		assertEquals(customer, response.getBody());
	}
	@Test
	public void test_updateCustomer() {
		Customer customer = new Customer(1,"Shaheen", "Mumbai");
        int customerId= 1;
       when(customerServiceImpl.updateCustomer(customer, customerId)).thenReturn(customer);
       ResponseEntity<Customer> response= customerController.updateCustomer(customer, customerId);
       assertEquals(HttpStatus.OK, response.getStatusCode());
       assertEquals(1, response.getBody().getCustomerId());
       assertEquals("Shaheen", response.getBody().getCustomerName());
       
       
		
	}
	@Test
	public void test_deleteCustomer() {
		Customer customer = new Customer(1,"Shaheen", "Mumbai");
		//ApiResponse apiResponse= new ApiResponse("Customer Deleted", true);
		ResponseEntity<ApiResponse> res=  customerController.deleteCustomer(customer)  ;
		verify(customerServiceImpl,times(1)).deleteCustomer(customer);
		
		assertEquals(HttpStatus.OK, res.getStatusCode());
		assertEquals("Customer Deleted", res.getBody().getMessage());
	

	}

}
