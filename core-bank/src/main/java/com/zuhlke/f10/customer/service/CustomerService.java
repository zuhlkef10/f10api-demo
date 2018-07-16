package com.zuhlke.f10.customer.service;

import com.zuhlke.f10.customer.model.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    public Customer create(String bankId, Customer customer){
        return customer;
    }

}
