package com.zuhlke.f10.robotadvisor.customer.service;

import com.zuhlke.f10.robotadvisor.model.Customer;
import com.zuhlke.f10.robotadvisor.model.CustomerInfo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public interface CustomerService {

    CustomerInfo createCustomer(@Valid @RequestBody Customer body);

    void deleteCustomer(@PathVariable("customer_id") String customerId);

    CustomerInfo getCustomer(@PathVariable("customer_id") String customerId);

    List<CustomerInfo> listCustomers(String name, String email);

    CustomerInfo updateCustomer(String customerId, Customer body);


}
