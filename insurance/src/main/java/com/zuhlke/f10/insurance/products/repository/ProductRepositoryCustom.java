package com.zuhlke.f10.insurance.products.repository;

import com.zuhlke.f10.insurance.model.Product;
import com.zuhlke.f10.insurance.model.SearchCriteria;

import java.util.List;

public interface ProductRepositoryCustom {

    List<Product> searchProducts(int limit, String sort, SearchCriteria searchCriteria);
}
