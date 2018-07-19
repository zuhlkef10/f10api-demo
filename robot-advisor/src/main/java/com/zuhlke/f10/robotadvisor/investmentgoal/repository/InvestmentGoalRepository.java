package com.zuhlke.f10.robotadvisor.investmentgoal.repository;

import com.zuhlke.f10.robotadvisor.model.InvestmentGoalInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InvestmentGoalRepository extends MongoRepository<InvestmentGoalInfo, String> {
}
