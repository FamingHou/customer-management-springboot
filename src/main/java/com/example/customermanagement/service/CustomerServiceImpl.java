package com.example.customermanagement.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.customermanagement.entity.Customer;
import com.example.customermanagement.exception.ResourceNotFoundException;
import com.example.customermanagement.exception.ValidationException;
import com.example.customermanagement.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer findByEmailId(String emailId) {
        return customerRepository.findByEmailId(emailId);
    }

    @Override
    public List<Customer> findAll(CustomerSearchCriteria criteria) {
        Direction direction = Sort.Direction.ASC;
        String sortColumn = "Id";
        if (criteria != null && criteria.getSortDirection() != null && criteria.getSortColumn() != null) {
            direction = criteria.getSortDirection().equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
            sortColumn = criteria.getSortColumn();
        }

        Sort sort = new Sort(direction, sortColumn);
        return customerRepository.findAll(sort);
    }

    @Override
    public Customer findById(Long id) throws ResourceNotFoundException {
        return customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found for the id: " + id));
    }

    @Override
    public Customer save(@Valid Customer customer) throws ValidationException {
        Customer result = customerRepository.findByEmailId(customer.getEmailId());
        if (result != null) {
            throw new ValidationException("This email address has already been registered.");
        }
        customer.setCreatedTime(System.currentTimeMillis()); // Unix Timestamp in milliseconds
        return customerRepository.save(customer);
    }

    @Override
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }

}
