package com.company.CustomerData.Repository;


import com.company.CustomerData.Model.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CustomerRepositoryTest {
    @Autowired
    CustomerRepository customerRepository;

    @Before
    public void setUp() throws Exception {

        customerRepository.deleteAll();
    }

    @Test
    public void contextLoads() {
    }

    //Add and delete customer record test
    @Test
    public void addGetDeleteCustomerRecord() {

        Customer customer = new Customer();
        customer.setFirst_name("John");
        customer.setLast_name("Doe");
        customer.setEmail("jdoe@netflix.com");
        customer.setCompany("Netflix");
        customer.setPhone("123-456-789");
        customer.setAddress1("1234 NW Bobcat Lane");
        customer.setAddress2("5678 SE Bobcat Lane");
        customer.setCity("St.Robert");
        customer.setState("Missouri");
        customer.setPostal_code("65584");
        customer.setCountry("USA");


        customer = customerRepository.save(customer);

        //find customer by id
        Optional<Customer> customer_search = customerRepository.findById(customer.getId());

        assertEquals(customer_search.get(), customer);

        //delete customer by id
        customerRepository.deleteById(customer.getId());

        customer_search = customerRepository.findById(customer.getId());

        assertFalse(customer_search.isPresent());
    }

    // Update customer record test
    @Test
    public void updateCustomerRecord() {

        Customer customer = new Customer();

        customer.setFirst_name("John");
        customer.setLast_name("Doe");
        customer.setEmail("jdoe@netflix.com");
        customer.setCompany("Netflix");
        customer.setPhone("123-456-789");
        customer.setAddress1("1234 NW Bobcat Lane");
        customer.setAddress2("5678 SE Bobcat Lane");
        customer.setCity("St.Robert");
        customer.setState("Missouri");
        customer.setPostal_code("65584");
        customer.setCountry("USA");

        customer = customerRepository.save(customer);

        customer.setPhone("987-654-321");
        customer.setAddress1("1759 SW Fincat Str");
        customer.setAddress2("2022 NE Henry Close");
        customer.setCity("Detroit");

        customerRepository.save(customer);

        Optional<Customer> customer_search = customerRepository.findById(customer.getId());
        assertEquals(customer_search.get(), customer);
    }

    //find customer by state test
    @Test
    public void getCustomerByState() {

        Customer customer1 = new Customer();

        customer1.setFirst_name("John");
        customer1.setLast_name("Doe");
        customer1.setEmail("jdoe@netflix.com");
        customer1.setCompany("Netflix");
        customer1.setPhone("123-456-789");
        customer1.setAddress1("1234 NW Bobcat Lane");
        customer1.setAddress2("5678 SE Bobcat Lane");
        customer1.setCity("Annapolis");
        customer1.setState("Maryland");
        customer1.setPostal_code("65584");
        customer1.setCountry("USA");

        customer1 = customerRepository.save(customer1);

        Customer customer2 = new Customer();
        customer2.setFirst_name("Mike");
        customer2.setLast_name("Lewis");
        customer2.setEmail("mlew@netflix.com");
        customer2.setCompany("Netflix");
        customer2.setPhone("123-482-739");
        customer2.setAddress1("12987 east ridge lane");
        customer2.setAddress2("5678 old court rd");
        customer2.setCity("Branson");
        customer2.setState("Missouri");
        customer2.setPostal_code("66784");
        customer2.setCountry("USA");

        customer2 = customerRepository.save(customer2);


        Customer customer3 = new Customer();
        customer3.setFirst_name("James");
        customer3.setLast_name("Hatcher");
        customer3.setEmail("jhat@netflix.com");
        customer3.setCompany("Netflix");
        customer3.setPhone("7333-2712-739");
        customer3.setAddress1("6895 edmondson ave");
        customer3.setAddress2("2345 white heart lanee");
        customer3.setCity("Columbia");
        customer3.setState("Missouri");
        customer3.setPostal_code("89214");
        customer3.setCountry("USA");

        customer3 = customerRepository.save(customer3);


        List<Customer> CustomerList = customerRepository.findByState("Missouri");

        assertEquals(CustomerList.size(), 2);
    }

}
