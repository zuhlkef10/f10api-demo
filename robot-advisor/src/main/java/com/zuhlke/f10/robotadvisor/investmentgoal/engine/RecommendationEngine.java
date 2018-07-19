package com.zuhlke.f10.robotadvisor.investmentgoal.engine;

import com.zuhlke.f10.robotadvisor.model.Recommendation;
import com.zuhlke.f10.robotadvisor.model.RecommendationInfo;

import java.util.List;

public interface RecommendationEngine {

    List<Recommendation> generateRecommendations(String customerId, String goalId);


}
