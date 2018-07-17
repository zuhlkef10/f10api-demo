package com.zuhlke.f10.insurance.products.repository;

import com.zuhlke.f10.insurance.model.Product;
import com.zuhlke.f10.insurance.model.SearchCriteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepositoryCustom{
    @Override
    public List<Product> searchProducts(int limit, String sort, SearchCriteria searchCriteria) {
        return null;
    }
}
