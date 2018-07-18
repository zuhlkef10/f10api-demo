package com.zuhlke.f10.crowdlending.loan.repository;

import com.zuhlke.f10.crowdlending.model.InvestmentInfo;
import com.zuhlke.f10.crowdlending.model.LoanInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InvestmentRepository extends MongoRepository<InvestmentInfo, String> {
}
