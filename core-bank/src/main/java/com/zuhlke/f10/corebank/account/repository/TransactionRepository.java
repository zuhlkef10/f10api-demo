package com.zuhlke.f10.corebank.account.repository;

import com.zuhlke.f10.corebank.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction,String> {


    @Query("{ 'accountId' : ?0 }")
    List<Transaction> findByAccountId(String accountId);

}
