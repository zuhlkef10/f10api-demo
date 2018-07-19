package com.zuhlke.f10.robotadvisor.investmentgoal.engine;

import java.math.BigDecimal;

public interface PaymentEngine {
    String debitAmountFromCustomer(String customerId, BigDecimal feesAmount);
}
