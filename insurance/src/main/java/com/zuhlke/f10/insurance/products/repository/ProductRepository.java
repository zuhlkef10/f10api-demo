package com.zuhlke.f10.insurance.products.repository;

import com.zuhlke.f10.insurance.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product,String>, ProductRepositoryCustom {

    @Query("{ 'productName' : ?0 }")
    Optional<Product>  findByProductName(String productName);
}
