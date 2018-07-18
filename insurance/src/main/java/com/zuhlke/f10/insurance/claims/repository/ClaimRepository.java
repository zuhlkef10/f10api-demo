package com.zuhlke.f10.insurance.claims.repository;

import com.zuhlke.f10.insurance.model.ClaimSettlement;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimRepository extends MongoRepository<ClaimSettlement, String> {
}
