package com.spotfire.feedback.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spotfire.feedback.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{
    List<Customer> findByLastName(String lastName);
    Customer findById(long id);
} 