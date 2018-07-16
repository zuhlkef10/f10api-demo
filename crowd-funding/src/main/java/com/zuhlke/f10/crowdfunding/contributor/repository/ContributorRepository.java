package com.zuhlke.f10.crowdfunding.contributor.repository;

import com.zuhlke.f10.crowdfunding.model.Contributor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContributorRepository extends MongoRepository<Contributor, String> {
}
