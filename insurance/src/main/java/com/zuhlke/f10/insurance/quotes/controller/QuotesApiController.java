package com.zuhlke.f10.insurance.quotes.controller;

import com.zuhlke.f10.insurance.model.Quotes;
import com.zuhlke.f10.insurance.model.SearchCriteria;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.math.BigDecimal;

@RestController
public class QuotesApiController implements QuotesApi {
    @Override
    @RequestMapping(value = "/quotes",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    public ResponseEntity<Quotes> getQuotes(@Valid BigDecimal limit, @Valid String sort, @Valid SearchCriteria body) {
        return null;
    }
}
