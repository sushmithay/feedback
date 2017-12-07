package com.spotfire.feedback.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.spotfire.feedback.model.Customer;


public interface CustomerRepository extends CrudRepository<Customer, Long>{
    List<Customer> findByLastName(String lastName);
} 