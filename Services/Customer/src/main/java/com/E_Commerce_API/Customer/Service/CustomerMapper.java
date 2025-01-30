package com.E_Commerce_API.Customer.Service;

import com.E_Commerce_API.Customer.Entity.Customer;
import com.E_Commerce_API.Customer.Entity.CustomerRequest;
import com.E_Commerce_API.Customer.Entity.CustomerResponse;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer toCustomer(CustomerRequest customerRequest){
        if(customerRequest==null) return null;
        return Customer.builder()
                .id(customerRequest.id())
                .firstName(customerRequest.firstname())
                .lastName(customerRequest.lastname())
                .email(customerRequest.email())
                .address(customerRequest.address())
                .build();
    }
    public CustomerResponse fromCustomer(Customer customer){
        if(customer==null) return null;
        return new CustomerResponse( customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getAddress());
    }
}
