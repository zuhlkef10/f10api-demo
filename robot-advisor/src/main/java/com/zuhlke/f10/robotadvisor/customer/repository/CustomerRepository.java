package com.zuhlke.f10.robotadvisor.customer.repository;

import com.zuhlke.f10.robotadvisor.model.CustomerInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<CustomerInfo, String> {
}
