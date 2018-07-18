package com.zuhlke.f10.insurance.claims.service;

import com.zuhlke.f10.insurance.claims.repository.ClaimRepository;
import com.zuhlke.f10.insurance.model.ClaimDetails;
import com.zuhlke.f10.insurance.model.ClaimSettlement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class ClaimServiceImpl implements ClaimService{

    @Autowired
    private ClaimRepository claimRepository;

    @Override
    public ClaimSettlement claimInsurance(String policyId, ClaimDetails claimDetails) {

        ClaimSettlement settlement = new ClaimSettlement();
        settlement.setApprovedAmount(claimDetails.getTotalAmountClaimed());
        settlement.setApprovedCurrency(claimDetails.getAmountCurrency());
        settlement.setPolicyId(policyId);
        settlement.setReferenceId(UUID.randomUUID().toString());
        settlement.settlementDate(LocalDate.now());

        ClaimSettlement savedSettlement = claimRepository.save(settlement);

        return savedSettlement;

    }
}
