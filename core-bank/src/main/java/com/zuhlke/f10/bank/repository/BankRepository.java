package com.zuhlke.f10.bank.repository;

import com.zuhlke.f10.bank.model.Bank;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BankRepository extends MongoRepository<Bank, String> {

}
