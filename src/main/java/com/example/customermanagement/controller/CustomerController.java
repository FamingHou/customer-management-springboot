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
import com.example.customermanagement.service.CustomerSearchCriteria;
import com.example.customermanagement.service.CustomerService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/v1")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public Result<List<Customer>> getAllCustomers(CustomerSearchCriteria criteria) {
        
        return new Result<List<Customer>>(true, customerService.findAll(criteria));
    }
//
//    @GetMapping("/customers/{id}")
//    public Customer getCustomerById(@PathVariable(value = "id") Long customerId)
//            throws ResourceNotFoundException {
//        return customerService.findById(customerId);
//    }
//
//    @PostMapping("/customers")
//    public Result createCustomer(@Valid @RequestBody Customer customer) {
//        try {
//            return new Result<Customer>(true, customerService.save(customer));
//        } catch (ValidationException e) {
//            return new Result<String>(false, e.getMessage());
//        }
//    }
//
//    @PutMapping("/customers/{id}")
//    public Result updateCustomer(@PathVariable(value = "id") Long customerId,
//            @Valid @RequestBody Customer customerDetails) throws ResourceNotFoundException {
//        Customer customer = customerService.findById(customerId);
//
//        customer.setEmailId(customerDetails.getEmailId());
//        customer.setLastName(customerDetails.getLastName());
//        customer.setFirstName(customerDetails.getFirstName());
//        Customer updatedCustomer;
//        try {
//            updatedCustomer = customerService.save(customer);
//            return new Result<Customer>(true, updatedCustomer);
//        } catch (ValidationException e) {
//            return new Result<String>(false, "Duplicated email address.");
//        }
//
//    }
//
//    @DeleteMapping("/customers/{id}")
//    public Map<String, Boolean> deleteCustomer(@PathVariable(value = "id") Long customerId)
//            throws ResourceNotFoundException {
//        Customer customer = customerService.findById(customerId);
//
//        customerService.delete(customer);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted", Boolean.TRUE);
//        return response;
//    }

}