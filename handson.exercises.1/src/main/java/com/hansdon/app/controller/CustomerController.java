package com.hansdon.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hansdon.app.entity.Customer;
import com.hansdon.app.payload.ApiResponse;
import com.hansdon.app.serviceImpl.CustomerServiceImpl;

@RestController
@RequestMapping("api/customers")
public class CustomerController {
	
	@Autowired
	CustomerServiceImpl customerServiceImpl;
	
	@PostMapping("/add")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
		Customer savedcustomer = this.customerServiceImpl.addCustomer(customer);
		return new ResponseEntity<Customer>(savedcustomer, HttpStatus.ACCEPTED);
		
	}
	@GetMapping("/get")
	public ResponseEntity<List<Customer>> getAllCustomers ()
	{
		
				List<Customer> custL= customerServiceImpl.getAllCustomer();
				return new ResponseEntity<List<Customer>>(custL, HttpStatus.FOUND);
	}
	
	@PutMapping("/{customerId}")
	public ResponseEntity<Customer> updateCustomer (@RequestBody Customer customer, @PathVariable Integer customerId){
		Customer updatedCust = this.customerServiceImpl.updateCustomer(customer, customerId);
		return ResponseEntity.ok(updatedCust);
	}
	
	@DeleteMapping("/{customerId}")
	public ResponseEntity<ApiResponse> deleteCustomerById (@PathVariable Integer customerId ){
		this.customerServiceImpl.deleteCustomerById(customerId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Customer Deleted Successfully", true), HttpStatus.OK);
	}
	
	@DeleteMapping()
	public ResponseEntity<ApiResponse> deleteCustomer(@RequestBody Customer customer){
		this.customerServiceImpl.deleteCustomer(customer);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Customer Deleted", true), HttpStatus.OK);
	}
}
