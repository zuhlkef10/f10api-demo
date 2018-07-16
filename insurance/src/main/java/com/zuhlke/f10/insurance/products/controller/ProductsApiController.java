package com.zuhlke.f10.insurance.products.controller;

import com.zuhlke.f10.insurance.model.BuyerSpecifications;
import com.zuhlke.f10.insurance.model.Invoice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ProductsApiController implements ProductsApi{
    @Override
    @RequestMapping(value = "/products/{productId}/buy",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    public ResponseEntity<Invoice> buyInsurance(String productId, @Valid BuyerSpecifications body) {
        return null;
    }
}
