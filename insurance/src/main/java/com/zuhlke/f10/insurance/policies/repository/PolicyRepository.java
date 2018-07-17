package com.zuhlke.f10.insurance.policies.repository;

import com.zuhlke.f10.insurance.model.PolicyDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PolicyRepository extends MongoRepository<PolicyDetails, String> {

    @Query("{ 'policyId' : ?0 }")
    Optional<PolicyDetails> findByPolicyId(String policyId);
}
