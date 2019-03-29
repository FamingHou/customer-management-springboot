package com.example.customermanagement.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.example.customermanagement.entity.Customer;
import com.example.customermanagement.service.SortCriteria;

@Mapper
public interface CustomerMapper {

    List<Customer> findAll(@Param("sc") SortCriteria sc);
    
    List<Customer> findByColumns(@Param("c") Customer c, @Param("sc") SortCriteria sc);

    Customer findById(Long id);
    
    Customer findByEmailId(Customer c);

    void insert(Customer customer);

    void updateStatus(Long id, String status);
    
    void delete(Long id);
    
}
