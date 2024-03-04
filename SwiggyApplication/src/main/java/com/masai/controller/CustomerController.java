package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.masai.model.Customer;
import com.masai.service.CustomerServiceImpl;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	private CustomerServiceImpl customerService;
	
	@PostMapping("/")
	public ResponseEntity<Customer> addCustomers(@Valid @RequestBody Customer customer){
		Customer addedCustomer = customerService.addCustomer(customer);
		return new ResponseEntity<Customer>(addedCustomer, HttpStatus.CREATED);
	}
	
	@GetMapping("/{customerId}")
	public ResponseEntity<Customer> getCustomer(@PathVariable int customerId){
		Customer returnedCustomer = customerService.getCustomer(customerId);
		
		return new ResponseEntity<Customer>(returnedCustomer, HttpStatus.OK);
	}
	
	@GetMapping("/byName/{name}")
	public ResponseEntity<Customer> customerByName(@PathVariable String name){
		Customer returnedCustomer = customerService.customerByName(name);
		
		return new ResponseEntity<Customer>(returnedCustomer, HttpStatus.OK);
	}
	
	@PutMapping("/update/{customerId}/{customerName}")
	public ResponseEntity<Customer> updateCustomerName(@PathVariable int customerId, @PathVariable String customerName){
		Customer updatedCustomer = customerService.updateCustomerName(customerId, customerName);
		
		return new ResponseEntity<Customer>(updatedCustomer, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{customerId}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable int customerId){
		Customer deletedCustomer = customerService.deleteCustomer(customerId);
		
		return new ResponseEntity<Customer>(deletedCustomer, HttpStatus.OK);
	}
}
