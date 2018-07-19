package com.zuhlke.f10.robotadvisor.investmentgoal.repository;

import com.zuhlke.f10.robotadvisor.model.InvestmentGoalInfo;
import com.zuhlke.f10.robotadvisor.model.RecommendationInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecommendationRepository extends MongoRepository<RecommendationInfo, String> {
}
