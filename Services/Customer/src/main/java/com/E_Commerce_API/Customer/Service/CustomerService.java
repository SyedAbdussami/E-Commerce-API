package com.E_Commerce_API.Customer.Service;

import ch.qos.logback.core.util.StringUtil;
import com.E_Commerce_API.Customer.Entity.Customer;
import com.E_Commerce_API.Customer.Entity.CustomerRequest;
import com.E_Commerce_API.Customer.Entity.CustomerResponse;
import com.E_Commerce_API.Customer.Exception.CustomerNotFoundException;
import com.E_Commerce_API.Customer.Repository.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {

//    @Autowired
     private final CustomerRepo customerRepo;

//     @Autowired
    private final CustomerMapper customerMapper;

    public String createCustomer(CustomerRequest customerRequest){
        var customer=customerRepo.save(customerMapper.toCustomer(customerRequest));
        return customer.getId();
    }

    public void updateCustomer(CustomerRequest customerRequest){
        var customer=customerRepo.findById(customerRequest.id())
                .orElseThrow(()->new CustomerNotFoundException(
                        String.format("Cannot update customer:: No customer found with the provided ID: %s", customerRequest.id())
        ));
        mergeCustomer(customerRequest,customer);
        customerRepo.save(customer);
    }

    public void mergeCustomer(CustomerRequest customerRequest, Customer customer){
        if(StringUtils.isNotBlank(customerRequest.firstname())){
            customer.setFirstName(customerRequest.firstname());
        }
        if(StringUtils.isNotBlank(customerRequest.email())){
            customer.setEmail(customerRequest.email());
        }
        if (customerRequest.address() != null) {
            customer.setAddress(customerRequest.address());
        }
    }

    public boolean customerExists(String customerId){
        return customerRepo.existsById(customerId);
    }

    public void deleteCustomer(String customerId){
//        var customer =customerRepo.findById(customerId);
        if(!customerExists(customerId)) throw new CustomerNotFoundException(String.format("Cannot update customer:: No customer found with the provided ID: %s", customerId));
        customerRepo.deleteById(customerId);
    }

    public CustomerResponse getCustomer(String customerId){
        return customerRepo.findById(customerId).map(customerMapper::fromCustomer)
                .orElseThrow(() -> new CustomerNotFoundException(String.format("No customer found with the provided ID: %s", customerId)));
    }

    public List<CustomerResponse> getAllCustomers(){
        return customerRepo.findAll().stream().map(customerMapper::fromCustomer).collect(Collectors.toList());
    }


}
