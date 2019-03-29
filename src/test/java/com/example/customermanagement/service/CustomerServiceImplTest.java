package com.example.customermanagement.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.customermanagement.entity.Customer;

@Import(CustomerServiceImpl.class) 
@RunWith(SpringRunner.class)
@ActiveProfiles("junit")
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class CustomerServiceImplTest {

    @TestConfiguration
    static class CustomerServiceImplTestContextConfiguration {
  
        @Bean
        public CustomerService customerService() {
            return new CustomerServiceImpl();
        }
    }
 
    @Autowired
    private CustomerService customerService;
    
    @Test
    public void findAll() {
    	SortCriteria sortCriteria = new SortCriteria("id", "asc");
        List<Customer> result = customerService.findAll(sortCriteria);
        assertEquals(1, result == null ? 0 : result.size());
     }
    
}
