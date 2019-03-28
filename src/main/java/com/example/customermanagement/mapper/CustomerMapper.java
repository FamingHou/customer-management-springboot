package com.example.customermanagement.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.example.customermanagement.entity.Customer;
import com.example.customermanagement.service.CustomerSearchCriteria;

@Mapper
public interface CustomerMapper {

    @Select("select * from customer order by id asc")
    @Results({
        @Result(property = "firstName", column = "first_name"),
        @Result(property = "lastName", column = "last_name"),
        @Result(property = "emailId", column = "email_address"),
        @Result(property = "createdTime", column = "created_time"),
    })    
    List<Customer> findAll(CustomerSearchCriteria criteria);
    
    @Insert("insert into customer() values()")
    void insert(Customer customer);
    
}
