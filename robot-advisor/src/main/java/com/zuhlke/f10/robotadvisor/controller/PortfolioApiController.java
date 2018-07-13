package com.zuhlke.f10.robotadvisor.controller;

import com.zuhlke.f10.robotadvisor.model.Portfolio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class PortfolioApiController implements PortfolioApi {

    @RequestMapping(value = "/customers/{customer_id}/portfolios",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    @Override
    public ResponseEntity<Portfolio> createPortfolio(@PathVariable("customer_id") String customerId, @Valid @RequestBody Portfolio body) {
        return null;
    }

    @RequestMapping(value = "/customers/{customer_id}/portfolios/{portfolio_id}",
            produces = {"application/json"},
            method = RequestMethod.DELETE)
    @Override
    public ResponseEntity<Void> deletePortfolio(@PathVariable("customer_id") String customerId, @PathVariable("portfolio_id") String portfolioId) {
        return null;
    }

    @RequestMapping(value = "/customers/{customer_id}/portfolios/{portfolio_id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.GET)
    @Override
    public ResponseEntity<Portfolio> getPortfolio(@PathVariable("customer_id") String customerId, @PathVariable("portfolio_id") String portfolioId) {
        return null;
    }

    @RequestMapping(value = "/customers/{customer_id}/portfolios/{portfolio_id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    @Override
    public ResponseEntity<Portfolio> updatePortfolio(@PathVariable("customer_id") String customerId, @PathVariable("portfolio_id") String portfolioId, @Valid @RequestBody Portfolio body) {
        return null;
    }
}
