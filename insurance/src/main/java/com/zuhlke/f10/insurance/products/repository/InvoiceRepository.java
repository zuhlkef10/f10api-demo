package com.zuhlke.f10.insurance.products.repository;

import com.zuhlke.f10.insurance.model.Invoice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends MongoRepository<Invoice,String> {
}
