package com.zuhlke.f10.robotadvisor.investmentgoal.controller;

import com.zuhlke.f10.robotadvisor.model.*;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public interface InvestmentGoalApi {

    @ApiOperation(value = "Create InvestmentGoal", nickname = "createInvestmentgoal", notes = "", response = InvestmentGoal.class, authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Investmentgoals",})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully created", response = InvestmentGoalInfo.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericError.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 404, message = "Resource Not Found", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/customers/{customer_id}/investmentgoals",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<InvestmentGoalInfo> createInvestmentGoal(@ApiParam(value = "", required = true) @PathVariable("customer_id") String customerId, @ApiParam(value = "") @Valid @RequestBody InvestmentGoal body);

    @ApiOperation(value = "Delete InvestmentGoal", nickname = "deleteInvestmentgoal", notes = "", authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Investmentgoals",})
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Successfully Deleted"),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericError.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 404, message = "Resource Not Found", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/customers/{customer_id}/investmentgoals/{goal_id}",
            produces = {"application/json"},
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteInvestmentGoal(@ApiParam(value = "", required = true) @PathVariable("customer_id") String customerId, @ApiParam(value = "", required = true) @PathVariable("goal_id") String goalId);

    @ApiOperation(value = "Get InvestmentGoal", nickname = "getInvestmentgoal", notes = "", response = InvestmentGoalInfo.class, authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Investmentgoals",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Response", response = InvestmentGoalInfo.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericError.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 404, message = "Resource Not Found", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/customers/{customer_id}/investmentgoals/{goal_id}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<InvestmentGoalInfo> getInvestmentGoal(@ApiParam(value = "", required = true) @PathVariable("customer_id") String customerId, @ApiParam(value = "", required = true) @PathVariable("goal_id") String goalId);

    @ApiOperation(value = "Get Recommendation", nickname = "getRecommendation", notes = "", response = RecommendationInfo.class, responseContainer = "List", authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Investmentgoals",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "", response = RecommendationInfo.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericError.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 404, message = "Resource Not Found", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/customers/{customer_id}/investmentgoals/{goal_id}/recommendations",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<List<RecommendationInfo>> getRecommendation(@ApiParam(value = "", required = true) @PathVariable("customer_id") String customerId, @ApiParam(value = "", required = true) @PathVariable("goal_id") String goalId);

    @ApiOperation(value = "List InvestmentGoals", nickname = "listInvestmentgoal", notes = "", response = InvestmentGoalInfo.class, responseContainer = "List", authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Investmentgoals",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Response", response = InvestmentGoalInfo.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericError.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 404, message = "Resource Not Found", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/customers/{customer_id}/investmentgoals",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<List<InvestmentGoalInfo>> listInvestmentGoal(@ApiParam(value = "", required = true) @PathVariable("customer_id") String customerId, @ApiParam(value = "Investment Type to filter records") @Valid @RequestParam(value = "investment_type", required = false) String investmentType);


    @ApiOperation(value = "Update InvestmentGoal", nickname = "updateInvestmentgoal", notes = "", response = InvestmentGoalInfo.class, authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Investmentgoals",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "", response = InvestmentGoalInfo.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericError.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 404, message = "Resource Not Found", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/customers/{customer_id}/investmentgoals/{goal_id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    ResponseEntity<InvestmentGoalInfo> updateInvestmentGoal(@ApiParam(value = "", required = true) @PathVariable("customer_id") String customerId, @ApiParam(value = "", required = true) @PathVariable("goal_id") String goalId, @ApiParam(value = "") @Valid @RequestBody InvestmentGoal body);


}
