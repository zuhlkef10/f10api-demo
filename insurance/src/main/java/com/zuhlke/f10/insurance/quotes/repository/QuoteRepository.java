package com.zuhlke.f10.insurance.quotes.repository;

import com.zuhlke.f10.insurance.model.QuoteDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteRepository extends MongoRepository<QuoteDetails,String> {
}
