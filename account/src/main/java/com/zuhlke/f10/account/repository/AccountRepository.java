package com.zuhlke.f10.account.repository;

import com.zuhlke.f10.account.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import java.util.List;


public interface AccountRepository extends MongoRepository<Account,String>{

   @Query("{ 'bankId' : ?0 , '_id' : ?1}")
   public List<Account> findByBankIdAndAccountId(String bankId, String accountId);

}
