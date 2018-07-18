package com.zuhlke.f10.corebank.account.repository;

import com.zuhlke.f10.corebank.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction,String> {
}
