package com.zuhlke.f10.robotadvisor.investmentgoal.service;

import com.zuhlke.f10.robotadvisor.model.InvestmentGoal;
import com.zuhlke.f10.robotadvisor.model.InvestmentGoalInfo;
import com.zuhlke.f10.robotadvisor.model.RecommendationInfo;

import java.util.List;

public interface InvestmentGoalService {

    InvestmentGoalInfo createInvestmentGoal(String customerId, InvestmentGoal body);

    void deleteInvestmentGoal(String customerId, String goalId);

    InvestmentGoalInfo getInvestmentGoal(String customerId, String goalId);

    List<InvestmentGoalInfo> listInvestmentGoal(String customerId, String investmentType);

    InvestmentGoalInfo updateInvestmentGoal(String customerId, String goalId, InvestmentGoal body);

}
