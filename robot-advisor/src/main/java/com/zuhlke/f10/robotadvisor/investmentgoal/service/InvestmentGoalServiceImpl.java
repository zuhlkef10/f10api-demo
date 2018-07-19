package com.zuhlke.f10.robotadvisor.investmentgoal.service;

import com.zuhlke.f10.robotadvisor.config.RaErrorConfigEnum;
import com.zuhlke.f10.robotadvisor.exception.ResourceNotFoundException;
import com.zuhlke.f10.robotadvisor.investmentgoal.repository.InvestmentGoalRepository;
import com.zuhlke.f10.robotadvisor.model.InvestmentGoal;
import com.zuhlke.f10.robotadvisor.model.InvestmentGoalInfo;
import com.zuhlke.f10.robotadvisor.model.RecommendationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;

@Service
public class InvestmentGoalServiceImpl implements InvestmentGoalService {

    @Autowired
    private InvestmentGoalRepository investmentGoalRepository;


    @Override
    public InvestmentGoalInfo createInvestmentGoal(String customerId, InvestmentGoal body) {
        InvestmentGoalInfo investmentGoalInfo = new InvestmentGoalInfo().investmentGoal(body).customerId(customerId);
        return investmentGoalRepository.insert(investmentGoalInfo);
    }

    @Override
    public void deleteInvestmentGoal(String customerId, String goalId) {
        Optional<InvestmentGoalInfo> investmentGoalInfoOptional = investmentGoalRepository.findById(goalId);
        if (investmentGoalInfoOptional.isPresent()) {
            investmentGoalRepository.deleteById(goalId);
        } else {
            throw new ResourceNotFoundException(RaErrorConfigEnum.RA_INVESTMENT_GOAL_NOT_FOUND);
        }
    }

    @Override
    public InvestmentGoalInfo getInvestmentGoal(String customerId, String goalId) {
        return investmentGoalRepository.findById(goalId).orElseThrow(() -> new ResourceNotFoundException(RaErrorConfigEnum.RA_INVESTMENT_GOAL_NOT_FOUND));
    }

    @Override
    public List<InvestmentGoalInfo> listInvestmentGoal(String customerId, String investmentType) {
        ExampleMatcher investmentGoalMatcher = ExampleMatcher.matching().withMatcher("investment_goal.investmentType", exact())
                .withMatcher("customerId", exact());

        InvestmentGoal investmentGoal = new InvestmentGoal()
                .investmentType(investmentType == null ? null : InvestmentGoal.InvestmentTypeEnum.valueOf(investmentType));

        InvestmentGoalInfo investmentGoalInfo = new InvestmentGoalInfo().investmentGoal(investmentGoal).customerId(customerId);
        Example<InvestmentGoalInfo> investmentGoalInfoExample = Example.of(investmentGoalInfo, investmentGoalMatcher);
        return investmentGoalRepository.findAll(investmentGoalInfoExample);
    }

    @Override
    public InvestmentGoalInfo updateInvestmentGoal(String customerId, String goalId, InvestmentGoal body) {
        return investmentGoalRepository.findById(goalId).map(investmentGoalInfo -> {
            investmentGoalInfo.setInvestmentGoal(body);
            return investmentGoalRepository.save(investmentGoalInfo);
        }).orElseThrow(() -> new ResourceNotFoundException(RaErrorConfigEnum.RA_INVESTMENT_GOAL_NOT_FOUND));
    }
}
