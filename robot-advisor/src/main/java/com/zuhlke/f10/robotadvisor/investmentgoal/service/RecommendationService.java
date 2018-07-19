package com.zuhlke.f10.robotadvisor.investmentgoal.service;

import com.zuhlke.f10.robotadvisor.model.RecommendationInfo;

import java.util.List;

public interface RecommendationService {

    List<RecommendationInfo> getRecommendation(String customerId, String goalId);



}
