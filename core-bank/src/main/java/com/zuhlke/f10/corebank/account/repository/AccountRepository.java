package com.zuhlke.f10.corebank.account.repository;

import com.zuhlke.f10.corebank.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AccountRepository extends MongoRepository<Account,String>, AccountRepositoryCustom{

    @Query("{ 'accountNumber' : ?0 }")
    Optional<Account> findByAccountNumber(String accountNumber);

}
