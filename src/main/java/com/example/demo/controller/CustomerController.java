package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@GetMapping("/customer")
	public ResponseEntity<List<Customer>> findAll() {
		return ResponseEntity.ok(customerService.findAll());
	}

	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> findById(@PathVariable(value = "id") long id) throws ResourceNotFoundException {
		return ResponseEntity.ok().body(customerService.findById(id));
	}

	@PostMapping("/customer")
	public Customer save(@RequestBody(required = true) Customer customer) {
		return customerService.saveCustomer(customer);
	}

	@PutMapping("/customer/{id}")
	public ResponseEntity<Customer> update(@PathVariable(value = "id") Long custId, @RequestBody(required = true) Customer customer)
			throws ResourceNotFoundException {
		return ResponseEntity.ok(customerService.updateCustomer(custId, customer));
	}

	@DeleteMapping("/customer/{id}")
	public Customer delete(@PathVariable(value = "id") long id) {
		return customerService.delete(id);
	}
}
