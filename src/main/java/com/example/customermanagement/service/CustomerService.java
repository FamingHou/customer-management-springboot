package com.example.customermanagement.service;

import java.util.List;

import com.example.customermanagement.entity.Customer;
import com.example.customermanagement.exception.ValidationException;

public interface CustomerService {

    List<Customer> findAll(SortCriteria criteria);

//    Customer findById(Long id) throws ResourceNotFoundException;

    void insert(Customer customer) throws ValidationException;

//    void delete(Customer customer);

}
