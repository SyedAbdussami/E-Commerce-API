package com.E_Commerce_API.Customer.Repository;

import com.E_Commerce_API.Customer.Entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends MongoRepository<Customer,String> {
}
