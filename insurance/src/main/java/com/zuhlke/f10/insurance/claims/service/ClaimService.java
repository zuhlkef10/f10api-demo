package com.zuhlke.f10.insurance.claims.service;

import com.zuhlke.f10.insurance.model.ClaimDetails;
import com.zuhlke.f10.insurance.model.ClaimSettlement;

public interface ClaimService {

    ClaimSettlement claimInsurance(String policyId, ClaimDetails claimDetails);
}
