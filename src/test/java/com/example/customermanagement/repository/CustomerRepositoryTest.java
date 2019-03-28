//package com.example.customermanagement.repository;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertThat;
//
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.example.customermanagement.entity.Customer;
//import com.example.customermanagement.exception.ResourceNotFoundException;
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//@ActiveProfiles("junit")
//@AutoConfigureTestDatabase(replace = Replace.NONE)
//public class CustomerRepositoryTest {
//
//    @Autowired
//    private TestEntityManager entityManager;
//
//    @Autowired
//    private CustomerRepository customerRepository;
//
//    @Test
//    public void save() {
//        String email = "faming.hou@gmail.com";
//        Customer customer = new Customer("Frank", "Hou", email, System.currentTimeMillis());
//        entityManager.persist(customer);
//        entityManager.flush();
//
//        Customer result = customerRepository.findByEmailId(email);
//        assertEquals(email, result == null ? null : result.getEmailId());
//    }
//
//    @Test
//    public void findById() throws ResourceNotFoundException {
//        Long id = new Long(7);
//        Customer result = customerRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + id));
//        assertEquals(id, result == null ? null : result.getId());
//    }
//
//    @Test
//    public void findAll() {
//        List<Customer> customers = customerRepository.findAll();
//        for (Object customer : customers) {
//            System.out.println(customer);
//        }
//    }
//
//}
