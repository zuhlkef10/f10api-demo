package com.zuhlke.f10.robotadvisor.customer.controller;

import com.zuhlke.f10.robotadvisor.customer.service.CustomerService;
import com.zuhlke.f10.robotadvisor.model.Customer;
import com.zuhlke.f10.robotadvisor.model.CustomerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerApiController implements CustomerApi {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/customers",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    @Override
    public ResponseEntity<CustomerInfo> createCustomer(@RequestBody Customer body) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.createCustomer(body));
    }

    @RequestMapping(value = "/customers/{customer_id}",
            produces = {"application/json"},
            method = RequestMethod.DELETE)
    @Override
    public ResponseEntity<Void> deleteCustomer(@PathVariable("customer_id") String customerId) {
        customerService.deleteCustomer(customerId);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/customers/{customer_id}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    @Override
    public ResponseEntity<CustomerInfo> getCustomer(@PathVariable("customer_id") String customerId) {
        return ResponseEntity.ok().body(customerService.getCustomer(customerId));
    }

    @RequestMapping(value = "/customers",
            produces = {"application/json"},
            method = RequestMethod.GET)
    @Override
    public ResponseEntity<List<CustomerInfo>> listCustomers(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "email", required = false) String email) {
        return ResponseEntity.ok().body(customerService.listCustomers(name, email));
    }

    @RequestMapping(value = "/customers/{customer_id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    @Override
    public ResponseEntity<CustomerInfo> updateCustomer(@PathVariable("customer_id") String customerId, @RequestBody Customer body) {
        return ResponseEntity.ok().body(customerService.updateCustomer(customerId, body));
    }
}
