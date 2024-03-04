package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;
import com.masai.repository.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepo;

	@Override
	public Customer addCustomer(Customer customer){
		if(customer == null) {
			throw new CustomerException("You've provided a null value, Please provide the required data!");
		}
		
		if(customerRepo.findById(customer.getCustomerId()).isPresent()){
			throw new CustomerException("Customer already exits with the same Id: " + customer.getCustomerId());
		}
		
		Customer savedCustomer = customerRepo.save(customer);
		
		return savedCustomer;
	}
	
	
	@Override
	public Customer getCustomer(int id) throws CustomerException {
		Customer customer = customerRepo.findById(id).orElseThrow(() -> new CustomerException("Customer with id " + id + " not found"));
		return customer;
	}

	
	@Override
	public Customer updateCustomerName(int customerId, String customerName) throws CustomerException {
		Customer customer = customerRepo.findById(customerId).orElseThrow(() -> new CustomerException("Customer with id " + customerId + " not found"));
		
		customer.setUsername(customerName);
		
		Customer savedCustomer = customerRepo.save(customer);
		
		return savedCustomer;
	}

	
	@Override
	public Customer deleteCustomer(int customerId) throws CustomerException {
		Customer customer = customerRepo.findById(customerId).orElseThrow(() -> new CustomerException("Customer with id " + customerId + " not found"));
		
		customerRepo.delete(customer);
		
		return customer;
	}

	
	@Override
	public Customer customerByName(String name) throws CustomerException {
		Customer customer = customerRepo.findByUsername(name).orElseThrow(() -> new CustomerException("Customer not found with name: " + name));
		
		return customer;
	}

}
