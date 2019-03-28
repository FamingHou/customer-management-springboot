package com.example.customermanagement.service;

import java.util.List;

import com.example.customermanagement.entity.Customer;
import com.example.customermanagement.exception.ResourceNotFoundException;
import com.example.customermanagement.exception.ValidationException;

public interface CustomerService {


    List<Customer> findByColumns(Customer conds, SortCriteria sortCriteria);

    List<Customer> findAll(SortCriteria sortCriteria);

//    Customer findById(Long id) throws ResourceNotFoundException;

    void insert(Customer customer) throws ValidationException;

    void updateStatus(Long id, String status);

//    void delete(Customer customer);

}
