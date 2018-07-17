package com.zuhlke.f10.insurance.products.controller;

import com.zuhlke.f10.insurance.model.BuyerSpecifications;
import com.zuhlke.f10.insurance.model.Invoice;
import com.zuhlke.f10.insurance.model.Product;
import com.zuhlke.f10.insurance.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductsApiController implements ProductsApi{

    @Autowired
    private ProductService productService;

    @Override
    @RequestMapping(value = "/products/{productId}/buy",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    public ResponseEntity<Invoice> buyInsurance(String productId, @Valid BuyerSpecifications buyerSpecs) {
        return ResponseEntity.ok().body(productService.buy(productId,buyerSpecs));
    }

    @Override
    @RequestMapping(value = "/products/{productId}",
            produces = {"application/json"},
            method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteProduct(String id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    @RequestMapping(value = "/products/{productId}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    public ResponseEntity<Product> getProduct(String id) {
        return ResponseEntity.ok().body(productService.getProduct(id));
    }

    @Override
    @RequestMapping(value = "/products",
            produces = {"application/json"},
            method = RequestMethod.GET)
    public ResponseEntity<List<Product>> listProducts() {
        return ResponseEntity.ok().body(productService.listProducts());
    }

    @Override
    @RequestMapping(value = "/products",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    public ResponseEntity<Product> createProduct(@Valid Product body) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(body));
    }

    @Override
    @RequestMapping(value = "/products/{productId}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    public ResponseEntity<Product> updateProduct(String id, @Valid Product body) {
        return ResponseEntity.ok().body(productService.updateProduct(id, body));
    }
}
