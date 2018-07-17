package com.zuhlke.f10.insurance.quotes.controller;

import com.zuhlke.f10.insurance.model.PolicyInfo;
import com.zuhlke.f10.insurance.model.QuoteDetails;
import com.zuhlke.f10.insurance.model.Quotes;
import com.zuhlke.f10.insurance.model.SearchCriteria;
import com.zuhlke.f10.insurance.quotes.service.QuoteService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;

@RestController
public class QuotesApiController implements QuotesApi {


    @Autowired
    private QuoteService  quoteService;

    @Override
    @RequestMapping(value = "/quotes/{productId}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
        public   ResponseEntity<QuoteDetails> getQuotes(@ApiParam(value = "",required=true) @PathVariable("productId") String productId, @ApiParam(value = ""  )  @Valid @RequestBody PolicyInfo body) {

           return ResponseEntity.ok().body(quoteService.computeCost(productId, body));

       }
}
