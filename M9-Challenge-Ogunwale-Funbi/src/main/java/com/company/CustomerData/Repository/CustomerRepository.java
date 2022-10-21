package com.company.CustomerData.Repository;

import com.company.CustomerData.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository <Customer, Integer>{
    List<Customer> findByState(String state);
    Optional findById(int id);
}
