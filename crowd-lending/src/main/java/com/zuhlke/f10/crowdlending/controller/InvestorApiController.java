package com.zuhlke.f10.crowdlending.controller;

import com.zuhlke.f10.crowdlending.model.Investor;
import com.zuhlke.f10.crowdlending.model.ListInvestorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class InvestorApiController implements InvestorApi {
    @RequestMapping(value = "/investors",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    @Override
    public ResponseEntity<Investor> createInvestor(@Valid @RequestBody Investor body) {
        return null;
    }

    @RequestMapping(value = "/investors/{investor_id}",
            produces = {"application/json"},
            method = RequestMethod.DELETE)
    @Override
    public ResponseEntity<Void> deleteInvestor(@PathVariable("investor_id") String investorId) {
        return null;
    }

    @RequestMapping(value = "/investors/{investor_id}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    @Override
    public ResponseEntity<Investor> getInvestor(@PathVariable("investor_id") String investorId) {
        return null;
    }

    @RequestMapping(value = "/investors",
            produces = {"application/json"},
            method = RequestMethod.GET)
    @Override
    public ResponseEntity<ListInvestorResponse> listInvestors() {
        return null;
    }

    @RequestMapping(value = "/investors/{investor_id}",
            produces = {"application/json"},
            method = RequestMethod.PUT)
    @Override
    public ResponseEntity<Investor> updateInvestor(@PathVariable("investor_id") String investorId, @Valid @RequestBody Investor body) {
        return null;
    }
}
