package com.example.customermanagement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.customermanagement.entity.Customer;
import com.example.customermanagement.exception.ResourceNotFoundException;
import com.example.customermanagement.exception.ValidationException;
import com.example.customermanagement.model.Result;
import com.example.customermanagement.service.CustomerService;
import com.example.customermanagement.service.SortCriteria;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/v1")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/customers")
	public Result<List<Customer>> getAllCustomers(SortCriteria criteria) {
		return new Result<List<Customer>>(true, customerService.findAll(criteria));
	}

	@GetMapping("/customers/conditions")
	public Result<List<Customer>> getAllCustomersByColumns(Customer customer, SortCriteria sortCriteria) {
		return new Result<List<Customer>>(true, customerService.findByColumns(customer, sortCriteria));
	}

	@PostMapping("/customers/updatestatus")
	public void updateStatus(@Valid @RequestBody Customer customer) {
		customerService.updateStatus(customer.getId(), customer.getStatus());
	}

	@PostMapping("/customers")
	public Result<String> createCustomer(@Valid @RequestBody Customer customer) {
		try {
			customerService.insert(customer);
			return new Result<String>(true, "The customer is created successfully.");
		} catch (ValidationException e) {
			return new Result<String>(false, e.getMessage());
		}
	}

	@PutMapping("/customers/{id}")
	public Result<String> updateCustomer(@Valid @RequestBody Customer customer)
			throws ResourceNotFoundException {
		try {
			customerService.update(customer);
			return new Result<String>(true, "This customer has been updated successfully.");
		} catch (ValidationException e) {
			return new Result<String>(false, "This email has been signed up.");
		}
	}

	@DeleteMapping("/customers/{id}")
	public Map<Long, Boolean> deleteCustomer(@PathVariable(value = "id") Long customerId)
			throws ResourceNotFoundException {
		customerService.delete(customerId);
		Map<Long, Boolean> response = new HashMap<Long, Boolean>();
		response.put(customerId, Boolean.TRUE);
		return response;
	}

}