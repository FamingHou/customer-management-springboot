package com.example.customermanagement.service;

import java.util.List;

import com.example.customermanagement.entity.Customer;

public interface CustomerService {

//    Customer findByEmailId(String emailId);
    
    List<Customer> findAll(CustomerSearchCriteria criteria);
    
//    Customer findById(Long id) throws ResourceNotFoundException;
//
//    Customer save(@Valid Customer customer) throws ValidationException;
//
//    void delete(Customer customer);
//    
}
