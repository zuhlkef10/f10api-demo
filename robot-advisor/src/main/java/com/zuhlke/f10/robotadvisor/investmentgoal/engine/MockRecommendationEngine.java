package com.zuhlke.f10.robotadvisor.investmentgoal.engine;

import com.zuhlke.f10.robotadvisor.config.RaErrorConfigEnum;
import com.zuhlke.f10.robotadvisor.customer.repository.CustomerRepository;
import com.zuhlke.f10.robotadvisor.exception.ResourceNotFoundException;
import com.zuhlke.f10.robotadvisor.investmentgoal.repository.InvestmentGoalRepository;
import com.zuhlke.f10.robotadvisor.model.Asset;
import com.zuhlke.f10.robotadvisor.model.Recommendation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class MockRecommendationEngine implements RecommendationEngine {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private InvestmentGoalRepository investmentGoalRepository;

    @Override
    public List<Recommendation> generateRecommendations(String customerId, String goalId) {
        return customerRepository.findById(customerId).map(customerInfo -> {
            return investmentGoalRepository.findById(goalId).map(investmentGoalInfo -> {
                List<Recommendation> recommendations = new ArrayList<>();
                Recommendation recommendation1 = new Recommendation()
                        .commission(String.valueOf(Math.random() * 10) + "%")
                        .name("Reco - " + customerId.substring(customerId.length() - 5, customerId.length() - 1) + " - I")
                        .rank(BigDecimal.ONE)
                        .asset(new Asset()
                                .assetType("Stock")
                                .averageReturns("Expected 20% per year")
                                .name("Stock ABC")
                                .description("Fortune 500 Company")
                                .status("INITIAL"));
                recommendations.add(recommendation1);

                Recommendation recommendation2 = new Recommendation()
                        .commission(String.valueOf(Math.random() * 10) + "%")
                        .name("Reco - " + customerId.substring(customerId.length() - 5, customerId.length() - 1) + " - II")
                        .rank(new BigDecimal("2"))
                        .asset(new Asset()
                                .assetType("Stock")
                                .averageReturns("Expected 25% per year")
                                .name("Stock XYZ")
                                .description("Leading Telecom Provider in Swiss")
                                .status("INITIAL"));
                recommendations.add(recommendation2);
                return recommendations;
            }).orElseThrow(() -> new ResourceNotFoundException(RaErrorConfigEnum.RA_INVESTMENT_GOAL_NOT_FOUND));
        }).orElseThrow(() -> new ResourceNotFoundException(RaErrorConfigEnum.RA_CUSTOMER_NOT_FOUND));
    }
}
