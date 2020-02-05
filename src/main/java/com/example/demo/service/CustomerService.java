package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	public Customer findById(Long id) throws ResourceNotFoundException {
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + id));
		return customer;
	}

	public Customer delete(Long id) {
		Optional<Customer> cust = customerRepository.findById(id);
		if (cust.isPresent()) {
			customerRepository.deleteById(id);
			return cust.get();
		}
		return null;
	}

	public Customer updateCustomer(Long custId, Customer customerDetails) throws ResourceNotFoundException {
		Customer existCustomer = customerRepository.findById(custId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + custId));

		existCustomer.setEmailId(customerDetails.getEmailId());
		existCustomer.setLastName(customerDetails.getLastName());
		existCustomer.setFirstName(customerDetails.getFirstName());
		final Customer updatedEmployee = customerRepository.save(existCustomer);
		return updatedEmployee;
	}
}
