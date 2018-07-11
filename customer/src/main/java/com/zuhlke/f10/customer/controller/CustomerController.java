package com.zuhlke.f10.customer.controller;

import com.zuhlke.f10.customer.model.Customer;
import com.zuhlke.f10.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/banks")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value="/{bankId}/customers", method = RequestMethod.POST)
    public Customer createCustomer(@PathVariable("bankId") String bankId, Customer customer){

       return customerService.create(bankId, customer);
    }

}
