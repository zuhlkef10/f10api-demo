package com.zuhlke.f10.account.repository;

import com.zuhlke.f10.account.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends MongoRepository<Account,String>, AccountRepositoryCustom{

   @Query("{ 'bankId' : ?0 , '_id' : ?1}")
   public Optional<Account> findByBankIdAndAccountId(String bankId, String accountId);


}
