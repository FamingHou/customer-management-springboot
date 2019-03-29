package com.example.customermanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.customermanagement.entity.Customer;
import com.example.customermanagement.exception.ResourceNotFoundException;
import com.example.customermanagement.exception.ValidationException;
import com.example.customermanagement.mapper.CustomerMapper;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerMapper customerMapper;

	@Override
	public List<Customer> findAll(SortCriteria sortCriteria) {
		return customerMapper.findAll(sortCriteria);
	}

	@Override
	public List<Customer> findByColumns(Customer customer, SortCriteria sortCriteria) {
		return customerMapper.findByColumns(customer, sortCriteria);
	}

	@Override
	public Customer findById(Long id) throws ResourceNotFoundException {
		return customerMapper.findById(id);
	}

	@Override
	public void insert(Customer customer) throws ValidationException {
		Customer found = customerMapper.findByEmailId(customer);
		if (found != null) {
			throw new ValidationException("This email address has already been registered.");
		}
		customer.setCreatedTime(System.currentTimeMillis()); // Unix Timestamp in milliseconds
		customerMapper.insert(customer);
	}

	@Override
	public void updateStatus(Long id, String status) {
		customerMapper.updateStatus(id, status);
	}

	@Override
	public void delete(Long id) {
		customerMapper.delete(id);
	}

	@Override
	public void update(Customer customer) throws ValidationException {
		// TODO Auto-generated method stub
	}

}
