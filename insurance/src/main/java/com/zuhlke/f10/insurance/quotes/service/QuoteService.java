package com.zuhlke.f10.insurance.quotes.service;

import com.zuhlke.f10.insurance.model.Invoice;
import com.zuhlke.f10.insurance.model.PurchaseDetails;
import com.zuhlke.f10.insurance.model.QuoteCriteria;
import com.zuhlke.f10.insurance.model.QuoteDetails;


public interface QuoteService {

    QuoteDetails computeCost(String productId, QuoteCriteria quoteCriteria);

    Invoice purchase(String quoteId, PurchaseDetails purchaseDetails);

}
