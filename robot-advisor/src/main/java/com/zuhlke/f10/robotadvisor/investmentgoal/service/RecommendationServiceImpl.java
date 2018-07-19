package com.zuhlke.f10.robotadvisor.investmentgoal.service;

import com.zuhlke.f10.robotadvisor.investmentgoal.engine.PaymentEngine;
import com.zuhlke.f10.robotadvisor.investmentgoal.engine.PricingEngine;
import com.zuhlke.f10.robotadvisor.investmentgoal.engine.RecommendationEngine;
import com.zuhlke.f10.robotadvisor.investmentgoal.repository.RecommendationRepository;
import com.zuhlke.f10.robotadvisor.model.Recommendation;
import com.zuhlke.f10.robotadvisor.model.RecommendationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    @Autowired
    private RecommendationEngine recommendationEngine;

    @Autowired
    private PricingEngine pricingEngine;

    @Autowired
    private PaymentEngine paymentEngine;

    @Autowired
    private RecommendationRepository recommendationRepository;

    @Override
    public List<RecommendationInfo> getRecommendation(String customerId, String goalId) {
        List<Recommendation> recommendations = recommendationEngine.generateRecommendations(customerId, goalId);
        List<RecommendationInfo> recommendationInfos = recommendations.stream().map(recommendation -> {
            BigDecimal feesAmount = pricingEngine.calculatePrice(customerId, goalId);
            return new RecommendationInfo()
                    .recommendation(recommendation)
                    .customerId(customerId)
                    .goalId(goalId)
                    .recommendedDate(LocalDate.now())
                    .feesCurrency("USD")
                    .feesAmount(feesAmount)
                    .paymentTransactionId(paymentEngine.debitAmountFromCustomer(customerId, feesAmount));
        }).collect(Collectors.toList());
        return saveRecommendationInfo(recommendationInfos);
    }

    private List<RecommendationInfo> saveRecommendationInfo(List<RecommendationInfo> recommendationInfos) {
        return recommendationRepository.saveAll(recommendationInfos);
    }


}
