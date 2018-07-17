package com.zuhlke.f10.insurance.products.service;

import com.zuhlke.f10.insurance.model.BuyerSpecifications;
import com.zuhlke.f10.insurance.model.Invoice;
import com.zuhlke.f10.insurance.model.Product;

import java.util.List;


public interface ProductService {

  Invoice buy(String productId, BuyerSpecifications buyerSpecs);

  void deleteProduct( String id);

  Product getProduct(String id);

  List<Product> listProducts();

  Product createProduct(Product product);

  Product updateProduct(String id, Product product);
}
