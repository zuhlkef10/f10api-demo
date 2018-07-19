package com.zuhlke.f10.robotadvisor.investmentgoal.engine;

import java.math.BigDecimal;

public interface PricingEngine {

    BigDecimal calculatePrice(String customerId, String goalId);
}
