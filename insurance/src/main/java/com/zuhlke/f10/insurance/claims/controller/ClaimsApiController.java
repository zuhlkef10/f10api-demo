package com.zuhlke.f10.insurance.claims.controller;

import com.zuhlke.f10.insurance.claims.service.ClaimService;
import com.zuhlke.f10.insurance.model.ClaimDetails;

import com.zuhlke.f10.insurance.model.ClaimSettlement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ClaimsApiController implements ClaimsApi {

    @Autowired
    private ClaimService claimService;

    @Override
    @RequestMapping(value = "/claims/policies/{policyId}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    public ResponseEntity<ClaimSettlement> claimInsurance(String policyId, @Valid @RequestBody ClaimDetails body) {

        return ResponseEntity.ok().body(claimService.claimInsurance(policyId,body));
    }
}
