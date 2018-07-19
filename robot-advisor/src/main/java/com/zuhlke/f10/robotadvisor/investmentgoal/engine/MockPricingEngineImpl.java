package com.zuhlke.f10.robotadvisor.investmentgoal.engine;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class MockPricingEngineImpl implements PricingEngine {
    @Override
    public BigDecimal calculatePrice(String customerId, String goalId) {
        return new BigDecimal(String.valueOf(Math.random())).multiply(new BigDecimal(String.valueOf(Math.random() * 100))).setScale(2, RoundingMode.UP);
    }
}
