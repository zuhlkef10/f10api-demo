package com.zuhlke.f10.robotadvisor.customer.service;

import com.zuhlke.f10.robotadvisor.config.RaErrorConfigEnum;
import com.zuhlke.f10.robotadvisor.customer.repository.CustomerRepository;
import com.zuhlke.f10.robotadvisor.exception.ResourceNotFoundException;
import com.zuhlke.f10.robotadvisor.model.Customer;
import com.zuhlke.f10.robotadvisor.model.CustomerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerInfo createCustomer(@Valid Customer body) {
        CustomerInfo customerInfo = new CustomerInfo().customer(body);
        return customerRepository.insert(customerInfo);
    }

    @Override
    public void deleteCustomer(String customerId) {
        Optional<CustomerInfo> investorInfoOptional = customerRepository.findById(customerId);
        if (investorInfoOptional.isPresent()) {
            customerRepository.deleteById(customerId);
        } else {
            throw new ResourceNotFoundException(RaErrorConfigEnum.RA_CUSTOMER_NOT_FOUND);
        }
    }

    @Override
    public CustomerInfo getCustomer(String customerId) {
        return customerRepository.findById(customerId).orElseThrow(() -> new ResourceNotFoundException(RaErrorConfigEnum.RA_CUSTOMER_NOT_FOUND));
    }

    @Override
    public List<CustomerInfo> listCustomers(String name, String email) {
        ExampleMatcher customerMatcher = ExampleMatcher.matching().withMatcher("customer.name", contains().ignoreCase())
                .withMatcher("customer.email", exact());

        Customer customer = new Customer()
                .name(name)
                .email(email);
        CustomerInfo customerInfo = new CustomerInfo().customer(customer);
        Example<CustomerInfo> customerInfoExample = Example.of(customerInfo, customerMatcher);
        return customerRepository.findAll(customerInfoExample);
    }

    @Override
    public CustomerInfo updateCustomer(String customerId, Customer body) {
        return customerRepository.findById(customerId).map(customerInfo -> {
            customerInfo.setCustomer(body);
            return customerRepository.save(customerInfo);
        }).orElseThrow(() -> new ResourceNotFoundException(RaErrorConfigEnum.RA_CUSTOMER_NOT_FOUND));
    }
}
