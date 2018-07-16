package com.zuhlke.f10.insurance.claims.controller;

import com.zuhlke.f10.insurance.model.ClaimDetails;
import com.zuhlke.f10.insurance.model.ClaimResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ClaimsApiController implements ClaimsApi {
    @Override
    @RequestMapping(value = "/claims/policies/{policyId}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    public ResponseEntity<ClaimResponse> claimInsurance(String policyId, @Valid ClaimDetails body) {
        return null;
    }
}
