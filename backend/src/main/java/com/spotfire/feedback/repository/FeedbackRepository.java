package com.spotfire.feedback.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spotfire.feedback.model.Customer;
import com.spotfire.feedback.model.Feedback;

@Repository
public interface FeedbackRepository extends CrudRepository<Feedback, Long>{

	List<Feedback> findByCust(Customer cust);
} 