package com.zuhlke.f10.robotadvisor.controller;

import com.zuhlke.f10.robotadvisor.model.Customer;
import com.zuhlke.f10.robotadvisor.model.InlineResponse200;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CustomerApiController implements CustomerApi {

    @RequestMapping(value = "/customers",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    @Override
    public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer body) {
        return null;
    }

    @RequestMapping(value = "/customers/{customer_id}",
            produces = {"application/json"},
            method = RequestMethod.DELETE)
    @Override
    public ResponseEntity<Void> deleteCustomer(@PathVariable("customer_id")String customerId) {
        return null;
    }

    @RequestMapping(value = "/customers/{customer_id}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    @Override
    public ResponseEntity<Customer> getCustomer(@PathVariable("customer_id") String customerId) {
        return null;
    }

    @RequestMapping(value = "/customers",
            produces = {"application/json"},
            method = RequestMethod.GET)
    @Override
    public ResponseEntity<InlineResponse200> listCustomers() {
        return null;
    }

    @RequestMapping(value = "/customers/{customer_id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    @Override
    public ResponseEntity<Customer> updateCustomer(String customerId, @Valid Customer body) {
        return null;
    }
}
