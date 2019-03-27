package com.example.customermanagement.controller;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.customermanagement.service.CustomerService;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
@ActiveProfiles("junit")
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class CustomerControllerTest {
   
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;
    
    @Test
    public void getCustomers() throws Exception {
        this.mockMvc.perform(get("/api/v1/customers")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Frank")));
        
    }


}
