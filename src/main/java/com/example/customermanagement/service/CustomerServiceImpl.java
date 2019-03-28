package com.example.customermanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.customermanagement.entity.Customer;
import com.example.customermanagement.mapper.CustomerMapper;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public List<Customer> findAll(CustomerSearchCriteria criteria) {
        return customerMapper.findAll(criteria);
    }
//
//    @Override
//    public List<Customer> findAll(CustomerSearchCriteria criteria) {
//        Direction direction = Sort.Direction.ASC;
//        String sortColumn = "Id";
//        if (criteria != null && criteria.getSortDirection() != null && criteria.getSortColumn() != null) {
//            direction = criteria.getSortDirection().equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
//            sortColumn = criteria.getSortColumn();
//        }
//
//        Sort sort = new Sort(direction, sortColumn);
//        return customerRepository.findAll(sort);
//    }
//
//    @Override
//    public Customer findById(Long id) throws ResourceNotFoundException {
//        return customerRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Customer not found for the id: " + id));
//    }
//
//    @Override
//    public Customer save(@Valid Customer customer) throws ValidationException {
//        Customer result = customerRepository.findByEmailId(customer.getEmailId());
//        if (result != null) {
//            throw new ValidationException("This email address has already been registered.");
//        }
//        customer.setCreatedTime(System.currentTimeMillis()); // Unix Timestamp in milliseconds
//        return customerRepository.save(customer);
//    }
//
//    @Override
//    public void delete(Customer customer) {
//        customerRepository.delete(customer);
//    }

}
