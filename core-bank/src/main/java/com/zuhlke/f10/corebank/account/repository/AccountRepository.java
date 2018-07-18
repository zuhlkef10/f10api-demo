package com.zuhlke.f10.corebank.account.repository;

import com.zuhlke.f10.corebank.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountRepository extends MongoRepository<Account,String>, AccountRepositoryCustom{



}
