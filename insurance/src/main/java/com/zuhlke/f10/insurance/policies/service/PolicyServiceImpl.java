package com.zuhlke.f10.insurance.policies.service;

import com.zuhlke.f10.insurance.exception.ResourceNotFoundException;
import com.zuhlke.f10.insurance.model.PolicyDetails;
import com.zuhlke.f10.insurance.policies.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PolicyServiceImpl  implements PolicyService{

   @Autowired
   private PolicyRepository policyRepository;

    @Override
    public PolicyDetails getPolicy(String policyId) {

         return policyRepository.findByPolicyId(policyId)
                .orElseThrow(()-> new ResourceNotFoundException("404","Policy Not Found"));
    }
}
