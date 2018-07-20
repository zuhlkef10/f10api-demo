package com.zuhlke.f10.insurance.quotes.controller;

import com.zuhlke.f10.insurance.model.Invoice;
import com.zuhlke.f10.insurance.model.PurchaseDetails;
import com.zuhlke.f10.insurance.model.QuoteCriteria;
import com.zuhlke.f10.insurance.model.QuoteDetails;
import com.zuhlke.f10.insurance.quotes.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class QuotesApiController implements QuotesApi {


    @Autowired
    private QuoteService  quoteService;

    @Override
    @RequestMapping(value = "/quotes/{productId}",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    public ResponseEntity<QuoteDetails> requestQuote(@PathVariable("productId") String productId
            ,@Valid @RequestBody QuoteCriteria body){
        return ResponseEntity.ok().body(quoteService.computeCost(productId, body));

    }


    @Override
    @RequestMapping(value = "/quotes/{quoteId}/purchase",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    public ResponseEntity<Invoice> purchase(@PathVariable("quoteId") String quoteId, @Valid @RequestBody PurchaseDetails body) {
        return ResponseEntity.ok().body(quoteService.purchase(quoteId,body));
    }


}
