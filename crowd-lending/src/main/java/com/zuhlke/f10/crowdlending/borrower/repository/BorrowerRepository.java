package com.zuhlke.f10.crowdlending.borrower.repository;

import com.zuhlke.f10.crowdlending.model.BorrowerInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BorrowerRepository extends MongoRepository<BorrowerInfo, String> {
}
