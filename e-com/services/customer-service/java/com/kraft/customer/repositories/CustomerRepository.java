package com.kraft.customer.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.kraft.customer.models.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer,String>{

}
