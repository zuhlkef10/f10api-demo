package com.zuhlke.f10.crowdlending.loan.repository;

import com.zuhlke.f10.crowdlending.model.LoanInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LoanRepository extends MongoRepository<LoanInfo, String> {
}
