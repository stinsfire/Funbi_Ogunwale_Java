package com.company.CustomerData.Controller;

import com.company.CustomerData.Model.Customer;
import com.company.CustomerData.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerrepo;

    //Create a new customer record
    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Customer createCustomerRecord(@RequestBody Customer customer) {
        return customerrepo.save(customer);
    }


    // Update an existing customer record
    @RequestMapping(value = "/customers", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateCustomerRecordById(@RequestBody Customer customer) {
         customerrepo.save(customer);
    }


    //Delete an existing customer record
    @RequestMapping(value = "/customers/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteCustomerRecordById(@PathVariable int id) {
        customerrepo.deleteById(id);
    }

    // Find a customer record by id.
    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Customer getCustomerRecordById(@PathVariable int id) {
        Optional<Customer> returnVal = customerrepo.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

     // Find customer records by state
    @RequestMapping(value = "/customers/{state}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Customer> getCustomerByState(@PathVariable String state) {

        List<Customer> returnVal = customerrepo.findByState(state);
        return customerrepo.findByState(state);
    }

}
