package com.example.customermanagement.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Sort;

import com.example.customermanagement.entity.Customer;
import com.example.customermanagement.exception.ResourceNotFoundException;
import com.example.customermanagement.exception.ValidationException;

public interface CustomerService {

    Customer findByEmailId(String emailId);
    
    List<Customer> findAll(CustomerSearchCriteria criteria);
    
    Customer findById(Long id) throws ResourceNotFoundException;

    Customer save(@Valid Customer customer) throws ValidationException;

    void delete(Customer customer);
    
}
