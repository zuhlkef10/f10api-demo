package com.zuhlke.f10.account.repository;

import com.zuhlke.f10.account.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account,String>{


}
