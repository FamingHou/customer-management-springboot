package com.example.customermanagement.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.example.customermanagement.entity.Customer;
import com.example.customermanagement.service.SortCriteria;

@Mapper
public interface CustomerMapper {

    @Results({ @Result(property = "firstName", column = "first_name"),
            @Result(property = "lastName", column = "last_name"),
            @Result(property = "emailId", column = "email_address"),
            @Result(property = "createdTime", column = "created_time"), })

    @Select("select * from customer order by id asc")
    List<Customer> findAll(SortCriteria criteria);

    @Select("select * from customer where email_address=#{emailId}")
    Customer findByEmailId(Customer c);
    
    @Insert("insert into customer(first_name, last_name, email_address, created_time) values(#{firstName}, #{lastName}, #{emailId}, #{createdTime} )")
    void insert(Customer customer);

    
}
