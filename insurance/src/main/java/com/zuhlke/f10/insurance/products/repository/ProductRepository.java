package com.zuhlke.f10.insurance.products.repository;

import com.zuhlke.f10.insurance.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,String>, ProductRepositoryCustom {

}
