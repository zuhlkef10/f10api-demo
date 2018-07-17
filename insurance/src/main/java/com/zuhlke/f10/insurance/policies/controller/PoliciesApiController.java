package com.zuhlke.f10.insurance.policies.controller;

import com.zuhlke.f10.insurance.model.PolicyDetails;
import com.zuhlke.f10.insurance.policies.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PoliciesApiController implements PoliciesApi{

    @Autowired
    private PolicyService policyService;

    @Override
    @RequestMapping(value = "/policies/{policyId}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    public ResponseEntity<PolicyDetails> getPolicy(@PathVariable("policyId") String policyId) {

        return ResponseEntity.ok().body(policyService.getPolicy(policyId));

    }
}
