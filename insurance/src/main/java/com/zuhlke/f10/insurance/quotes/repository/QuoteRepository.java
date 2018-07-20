package com.zuhlke.f10.insurance.quotes.repository;

import com.zuhlke.f10.insurance.model.QuoteDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuoteRepository extends MongoRepository<QuoteDetails,String> {

    @Query("{ 'quoteId' : ?0 }")
    Optional<QuoteDetails> findByQuoteId(String quoteId);
}
