package com.E_Commerce_API.Customer.Controller;

import com.E_Commerce_API.Customer.Entity.Customer;
import com.E_Commerce_API.Customer.Entity.CustomerRequest;
import com.E_Commerce_API.Customer.Entity.CustomerResponse;
import com.E_Commerce_API.Customer.Service.CustomerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<String> createCustomer(@RequestBody @Valid CustomerRequest customerRequest){
        return ResponseEntity.ok(customerService.createCustomer(customerRequest));
    }
    @PutMapping("/")
    public ResponseEntity<Void> updateCustomer(@RequestBody @Valid CustomerRequest customerRequest){
        customerService.updateCustomer(customerRequest);
        return ResponseEntity.accepted().build();
    }
    @GetMapping("/exists/{customer-id}")
    public ResponseEntity<Boolean> checkCustomer(@PathVariable("customer-id") String customerId){
        return ResponseEntity.ok(customerService.customerExists(customerId));
    }
    @DeleteMapping("/delete/{customer-id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("customer-id") String customerId){
        customerService.deleteCustomer(customerId);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/{customer-id}")
    public ResponseEntity<CustomerResponse> getCustomer(@PathVariable("customer-id") String customerId){
        return ResponseEntity.ok(customerService.getCustomer(customerId));
    }
    @GetMapping("/all")
    public ResponseEntity<List<CustomerResponse>> getAllCustomers(){
        return ResponseEntity.ok(customerService.getAllCustomers());
    }
}
