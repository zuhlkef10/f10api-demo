package com.zuhlke.f10.insurance.quotes.service;

import com.zuhlke.f10.insurance.model.PolicyInfo;
import com.zuhlke.f10.insurance.model.QuoteDetails;



public interface QuoteService {

    QuoteDetails computeCost(String productId, PolicyInfo policyInfo);
}
