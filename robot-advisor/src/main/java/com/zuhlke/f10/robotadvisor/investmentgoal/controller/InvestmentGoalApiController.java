package com.zuhlke.f10.robotadvisor.investmentgoal.controller;

import com.zuhlke.f10.robotadvisor.investmentgoal.service.InvestmentGoalService;
import com.zuhlke.f10.robotadvisor.investmentgoal.service.RecommendationService;
import com.zuhlke.f10.robotadvisor.model.InvestmentGoal;
import com.zuhlke.f10.robotadvisor.model.InvestmentGoalInfo;
import com.zuhlke.f10.robotadvisor.model.RecommendationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class InvestmentGoalApiController implements InvestmentGoalApi {

    @Autowired
    private InvestmentGoalService investmentGoalService;

    @Autowired
    private RecommendationService recommendationService;

    @RequestMapping(value = "/customers/{customer_id}/investmentgoals",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    @Override
    public ResponseEntity<InvestmentGoalInfo> createInvestmentGoal(@PathVariable("customer_id") String customerId, @Valid @RequestBody InvestmentGoal body) {
        return ResponseEntity.status(HttpStatus.CREATED).body(investmentGoalService.createInvestmentGoal(customerId, body));
    }

    @RequestMapping(value = "/customers/{customer_id}/investmentgoals/{goal_id}",
            produces = {"application/json"},
            method = RequestMethod.DELETE)
    @Override
    public ResponseEntity<Void> deleteInvestmentGoal(@PathVariable("customer_id") String customerId, @PathVariable("goal_id") String goalId) {
        investmentGoalService.deleteInvestmentGoal(customerId, goalId);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/customers/{customer_id}/investmentgoals/{goal_id}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    @Override
    public ResponseEntity<InvestmentGoalInfo> getInvestmentGoal(@PathVariable("customer_id") String customerId, @PathVariable("goal_id") String goalId) {
        return ResponseEntity.ok().body(investmentGoalService.getInvestmentGoal(customerId, goalId));
    }

    @RequestMapping(value = "/customers/{customer_id}/investmentgoals/{goal_id}/recommendations",
            produces = {"application/json"},
            method = RequestMethod.GET)
    @Override
    public ResponseEntity<List<RecommendationInfo>> getRecommendation(@PathVariable("customer_id") String customerId, @PathVariable("goal_id") String goalId) {
        return ResponseEntity.ok().body(recommendationService.getRecommendation(customerId, goalId));
    }

    @RequestMapping(value = "/customers/{customer_id}/investmentgoals",
            produces = {"application/json"},
            method = RequestMethod.GET)
    @Override
    public ResponseEntity<List<InvestmentGoalInfo>> listInvestmentGoal(@PathVariable("customer_id") String customerId, @RequestParam(value = "investment_type", required = false) String investmentType) {
        return ResponseEntity.ok().body(investmentGoalService.listInvestmentGoal(customerId, investmentType));
    }

    @RequestMapping(value = "/customers/{customer_id}/investmentgoals/{goal_id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    @Override
    public ResponseEntity<InvestmentGoalInfo> updateInvestmentGoal(@PathVariable("customer_id") String customerId, @PathVariable("goal_id") String goalId, @Valid @RequestBody InvestmentGoal body) {
        return ResponseEntity.ok().body(investmentGoalService.updateInvestmentGoal(customerId, goalId, body));
    }
}
