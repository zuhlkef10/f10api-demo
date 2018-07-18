package com.zuhlke.f10.crowdlending.investor.repository;

import com.zuhlke.f10.crowdlending.model.InvestorInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InvestorRepository extends MongoRepository<InvestorInfo, String> {
}
