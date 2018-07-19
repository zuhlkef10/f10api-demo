package com.zuhlke.f10.robotadvisor.portfolio.controller;

import com.zuhlke.f10.robotadvisor.model.Portfolio;
import com.zuhlke.f10.robotadvisor.model.PortfolioInfo;
import com.zuhlke.f10.robotadvisor.portfolio.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PortfolioApiController implements PortfolioApi {

    @Autowired
    private PortfolioService portfolioService;

    @RequestMapping(value = "/customers/{customer_id}/portfolios",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    @Override
    public ResponseEntity<PortfolioInfo> createPortfolio(@PathVariable("customer_id") String customerId, @Valid @RequestBody Portfolio body) {
        return ResponseEntity.status(HttpStatus.CREATED).body(portfolioService.createPortfolio(customerId, body));
    }

    @RequestMapping(value = "/customers/{customer_id}/portfolios/{portfolio_id}",
            produces = {"application/json"},
            method = RequestMethod.DELETE)
    @Override
    public ResponseEntity<Void> deletePortfolio(@PathVariable("customer_id") String customerId, @PathVariable("portfolio_id") String portfolioId) {
        portfolioService.deletePortfolio(customerId, portfolioId);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/customers/{customer_id}/portfolios/{portfolio_id}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    @Override
    public ResponseEntity<PortfolioInfo> getPortfolio(@PathVariable("customer_id") String customerId, @PathVariable("portfolio_id") String portfolioId) {
        return ResponseEntity.ok().body(portfolioService.getPortfolio(customerId, portfolioId));
    }

    @RequestMapping(value = "/customers/{customer_id}/portfolios",
            produces = {"application/json"},
            method = RequestMethod.GET)
    @Override
    public ResponseEntity<List<PortfolioInfo>> listPortfolios(@PathVariable("customer_id") String customerId, @RequestParam(value = "status", required = false) String status) {
        return ResponseEntity.ok().body(portfolioService.listPortfolios(customerId, status));
    }

    @RequestMapping(value = "/customers/{customer_id}/portfolios/{portfolio_id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    @Override
    public ResponseEntity<PortfolioInfo> updatePortfolio(@PathVariable("customer_id") String customerId, @PathVariable("portfolio_id") String portfolioId, @Valid @RequestBody Portfolio body) {
        return ResponseEntity.ok().body(portfolioService.updatePortfolio(customerId, portfolioId, body));
    }
}
