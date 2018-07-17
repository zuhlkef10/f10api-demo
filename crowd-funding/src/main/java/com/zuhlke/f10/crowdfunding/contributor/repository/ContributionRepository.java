package com.zuhlke.f10.crowdfunding.contributor.repository;

import com.zuhlke.f10.crowdfunding.model.ContributionInfo;
import com.zuhlke.f10.crowdfunding.model.ContributorInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContributionRepository extends MongoRepository<ContributionInfo, String> {
}
