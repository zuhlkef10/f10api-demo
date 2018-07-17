package com.zuhlke.f10.insurance.products.controller;

import com.zuhlke.f10.insurance.model.BuyerSpecifications;
import com.zuhlke.f10.insurance.model.Invoice;
import com.zuhlke.f10.insurance.model.Product;
import com.zuhlke.f10.insurance.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
    @RequestMapping(value = "/products/{id}/buy",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    public ResponseEntity<Invoice> buyInsurance(@PathVariable("id") String id, @Valid BuyerSpecifications buyerSpecs) {

           return ResponseEntity.ok().body(productService.buy(id,buyerSpecs));
    }

    @Override
    @RequestMapping(value = "/products/{id}",
            produces = {"application/json"},
            method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") String id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    @RequestMapping(value = "/products/{id}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    public ResponseEntity<Product> getProduct(@PathVariable("id") String id) {
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
    @RequestMapping(value = "/products/{id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    public ResponseEntity<Product> updateProduct(@PathVariable("id") String id, @Valid Product body) {
        return ResponseEntity.ok().body(productService.updateProduct(id, body));
    }
}
