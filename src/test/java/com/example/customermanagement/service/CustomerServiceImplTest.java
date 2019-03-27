package com.example.customermanagement.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.customermanagement.entity.Customer;
import com.example.customermanagement.exception.ResourceNotFoundException;
import com.example.customermanagement.repository.CustomerRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
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
 
    @MockBean
    private CustomerRepository customerRepository;
    
    @Test
    public void findByEmailId() {
        String email = "faming.hou@gmail.com";
        Customer result = customerService.findByEmailId(email);
        assertEquals(email, result == null ? null : result.getEmailId());
     }
    
    @Test
    public void findById() throws ResourceNotFoundException {
        Long id = new Long(7);
        Customer result = customerService.findById(id);
        assertEquals(id, result == null ? null : result.getId());
     }
    
}
