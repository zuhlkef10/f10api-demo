package com.zuhlke.f10.crowdlending.investor.controller;

import com.zuhlke.f10.crowdlending.investor.service.InvestorService;
import com.zuhlke.f10.crowdlending.model.CreateInvestorResponse;
import com.zuhlke.f10.crowdlending.model.Investor;
import com.zuhlke.f10.crowdlending.model.InvestorInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InvestorApiController implements InvestorApi {

    @Autowired
    private InvestorService investorService;

    @RequestMapping(value = "/investors",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    @Override
    public ResponseEntity<CreateInvestorResponse> createInvestor(@RequestBody Investor body) {
        String investorId = investorService.createInvestor(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CreateInvestorResponse().investorId(investorId));
    }

    @RequestMapping(value = "/investors/{investor_id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.DELETE)
    @Override
    public ResponseEntity<Void> deleteInvestor(@PathVariable("investor_id") String investorId) {
        investorService.deleteInvestor(investorId);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/investors/{investor_id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.GET)
    @Override
    public ResponseEntity<InvestorInfo> getInvestor(@PathVariable("investor_id") String investorId) {
        return ResponseEntity.ok().body(investorService.getInvestor(investorId));
    }

    @RequestMapping(value = "/investors",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.GET)
    @Override
    public ResponseEntity<List<InvestorInfo>> listInvestors(String name, String email) {
        return ResponseEntity.ok().body(investorService.listInvestors(name, email));
    }

    @RequestMapping(value = "/investors/{investor_id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    @Override
    public ResponseEntity<InvestorInfo> updateInvestor(@PathVariable("investor_id") String investorId, @RequestBody Investor body) {
        return ResponseEntity.ok().body(investorService.updateInvestor(investorId, body));
    }
}
