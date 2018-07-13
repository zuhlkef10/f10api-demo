package com.zuhlke.f10.robotadvisor.controller;

import com.zuhlke.f10.robotadvisor.model.InvestmentGoal;
import com.zuhlke.f10.robotadvisor.model.Recommendation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class InvestmentGoalApiController implements InvestmentGoalApi {

    @RequestMapping(value = "/customers/{customer_id}/investmentgoals",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    @Override
    public ResponseEntity<InvestmentGoal> createInvestmentgoal(@PathVariable("customer_id") String customerId, @Valid @RequestBody InvestmentGoal body) {
        return null;
    }

    @RequestMapping(value = "/customers/{customer_id}/investmentgoals/{goal_id}",
            produces = {"application/json"},
            method = RequestMethod.DELETE)
    @Override
    public ResponseEntity<Void> deleteInvestmentgoal(@PathVariable("customer_id") String customerId, @PathVariable("goal_id") String goalId) {
        return null;
    }

    @RequestMapping(value = "/customers/{customer_id}/investmentgoals/{goal_id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.GET)
    @Override
    public ResponseEntity<InvestmentGoal> getInvestmentgoal(@PathVariable("customer_id") String customerId, @PathVariable("goal_id") String goalId) {
        return null;
    }

    @RequestMapping(value = "/customers/{customer_id}/investmentgoals/{goal_id}/recommendations",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.GET)
    @Override
    public ResponseEntity<List<Recommendation>> getRecommendation(@PathVariable("customer_id") String customerId, @PathVariable("goal_id") String goalId) {
        return null;
    }

    @RequestMapping(value = "/customers/{customer_id}/investmentgoals/{goal_id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    @Override
    public ResponseEntity<InvestmentGoal> updateInvestmentgoal(@PathVariable("customer_id") String customerId, @PathVariable("goal_id") String goalId, @Valid @RequestBody InvestmentGoal body) {
        return null;
    }
}
