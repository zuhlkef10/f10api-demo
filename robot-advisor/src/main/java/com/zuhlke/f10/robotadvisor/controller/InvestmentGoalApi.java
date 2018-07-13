package com.zuhlke.f10.robotadvisor.controller;

import com.zuhlke.f10.robotadvisor.model.GenericError;
import com.zuhlke.f10.robotadvisor.model.InvestmentGoal;
import com.zuhlke.f10.robotadvisor.model.Recommendation;
import com.zuhlke.f10.robotadvisor.model.ServerError;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

public interface InvestmentGoalApi {

    @ApiOperation(value = "Create InvestmentGoal", nickname = "createInvestmentgoal", notes = "", response = InvestmentGoal.class, authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Investmentgoals",})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "", response = InvestmentGoal.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/customers/{customer_id}/investmentgoals",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<InvestmentGoal> createInvestmentgoal(@ApiParam(value = "", required = true) @PathVariable("customer_id") String customerId, @ApiParam(value = "") @Valid @RequestBody InvestmentGoal body);

    @ApiOperation(value = "Delete InvestmentGoal", nickname = "deleteInvestmentgoal", notes = "", authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Investmentgoals",})
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = ""),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/customers/{customer_id}/investmentgoals/{goal_id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteInvestmentgoal(@ApiParam(value = "", required = true) @PathVariable("customer_id") String customerId, @ApiParam(value = "", required = true) @PathVariable("goal_id") String goalId);


    @ApiOperation(value = "Get InvestmentGoal", nickname = "getInvestmentgoal", notes = "", response = InvestmentGoal.class, authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Investmentgoals",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Response", response = InvestmentGoal.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/customers/{customer_id}/investmentgoals/{goal_id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<InvestmentGoal> getInvestmentgoal(@ApiParam(value = "", required = true) @PathVariable("customer_id") String customerId, @ApiParam(value = "", required = true) @PathVariable("goal_id") String goalId);


    @ApiOperation(value = "Get Recommendation", nickname = "getRecommendation", notes = "", response = Recommendation.class, responseContainer = "List", authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Investmentgoals",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "", response = Recommendation.class, responseContainer = "List"),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/customers/{customer_id}/investmentgoals/{goal_id}/recommendations",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<List<Recommendation>> getRecommendation(@ApiParam(value = "", required = true) @PathVariable("customer_id") String customerId, @ApiParam(value = "", required = true) @PathVariable("goal_id") String goalId);

    @ApiOperation(value = "Update InvestmentGoal", nickname = "updateInvestmentgoal", notes = "", response = InvestmentGoal.class, authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Investmentgoals",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "", response = InvestmentGoal.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/customers/{customer_id}/investmentgoals/{goal_id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    ResponseEntity<InvestmentGoal> updateInvestmentgoal(@ApiParam(value = "", required = true) @PathVariable("customer_id") String customerId, @ApiParam(value = "", required = true) @PathVariable("goal_id") String goalId, @ApiParam(value = "") @Valid @RequestBody InvestmentGoal body);

}
