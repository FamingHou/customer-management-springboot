package com.example.customermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.customermanagement.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    /**
     * Returns the first customer with the value of firstName 
     * 
     * @param name
     * @return
     */
    public Customer findByEmailId(String emailId);
    
}