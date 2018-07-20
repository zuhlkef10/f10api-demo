package com.zuhlke.f10.insurance.products.service;

import com.zuhlke.f10.insurance.InsuranceConstants;
import com.zuhlke.f10.insurance.exception.ResourceNotFoundException;
import com.zuhlke.f10.insurance.model.*;
import com.zuhlke.f10.insurance.policies.repository.PolicyRepository;
import com.zuhlke.f10.insurance.products.repository.InvoiceRepository;
import com.zuhlke.f10.insurance.products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private InvoiceRepository  invoiceRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PolicyRepository policyRepository;


    @Override
    public void deleteProduct(String id) {
        getProduct(id); //call this to throw ResourceNotFoundException if it does not exist
        productRepository.deleteById(id);
    }

    @Override
    public Product getProduct(String id) {

        Optional<Product> product = productRepository.findById(id);
        return product.orElseThrow(() -> new ResourceNotFoundException("404","Product not found"));
    }

    @Override
    public List<Product> listProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(String id, Product product) {
        getProduct(id); //call this to throw ResourceNotFoundException if it does not exist

        return productRepository.save(product);
    }
}
