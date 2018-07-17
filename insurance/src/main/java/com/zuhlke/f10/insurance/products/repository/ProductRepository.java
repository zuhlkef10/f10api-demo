package com.zuhlke.f10.insurance.products.repository;

import com.zuhlke.f10.insurance.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product,String> {

   // @Query("{ 'productId' : ?0 }")
   // Optional<Product>  findByProductId(String productId);

   // @Query(value="{ 'productId' : ?0 }", delete = true)
   // void deleteByProductId(String productId);



}
