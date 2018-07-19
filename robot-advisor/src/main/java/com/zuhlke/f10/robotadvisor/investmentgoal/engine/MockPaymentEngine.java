package com.zuhlke.f10.robotadvisor.investmentgoal.engine;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Component
public class MockPaymentEngine implements PaymentEngine{
    @Override
    public String debitAmountFromCustomer(String customerId, BigDecimal feesAmount) {
        return UUID.randomUUID().toString();
    }
}
