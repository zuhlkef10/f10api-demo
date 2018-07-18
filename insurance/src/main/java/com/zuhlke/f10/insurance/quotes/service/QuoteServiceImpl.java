package com.zuhlke.f10.insurance.quotes.service;

import com.zuhlke.f10.insurance.model.*;
import com.zuhlke.f10.insurance.products.repository.ProductRepository;
import com.zuhlke.f10.insurance.products.service.ProductService;
import com.zuhlke.f10.insurance.quotes.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;


@Service
public class QuoteServiceImpl implements QuoteService {

    @Autowired
    private ProductRepository  productRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private QuoteRepository  quoteRepository;

    @Override
    public QuoteDetails computeCost(String productId, PolicyInfo policyInfo) {

        Product product = productService.getProduct(productId);

        QuoteDetails quoteDetails = new QuoteDetails();
        quoteDetails.setQuoteId(UUID.randomUUID().toString());
        quoteDetails.setProductId(product.getId());
        quoteDetails.setProductDescription(product.getProductDescription());
        quoteDetails.setPremiumCurrency(product.getPremiumCurrency());

        //compute number of days covered
        LocalDate from = policyInfo.getCoverageDate().getFrom();
        LocalDate to = policyInfo.getCoverageDate().getTo();

        long numDays = ChronoUnit.DAYS.between(from, to) + 1;
        BigDecimal cost = product.getPremiumAmount().multiply(new BigDecimal(numDays));
        quoteDetails.setPremiumAmount(cost);
        quoteDetails.setNumberOfDaysCovered((int)numDays);

        //save quote
        quoteRepository.save(quoteDetails);

        return quoteDetails;
    }
}
