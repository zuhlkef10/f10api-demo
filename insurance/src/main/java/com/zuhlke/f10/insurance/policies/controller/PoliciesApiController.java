package com.zuhlke.f10.insurance.policies.controller;

import com.zuhlke.f10.insurance.model.PolicyDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PoliciesApiController implements PoliciesApi{
    @Override
    @RequestMapping(value = "/policies/{policyId}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.GET)
    public ResponseEntity<PolicyDetails> getPolicy(String policyId) {
        return null;
    }
}
