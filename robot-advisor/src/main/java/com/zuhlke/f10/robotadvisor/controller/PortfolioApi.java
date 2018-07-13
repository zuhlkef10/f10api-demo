package com.zuhlke.f10.robotadvisor.controller;

import com.zuhlke.f10.robotadvisor.model.GenericError;
import com.zuhlke.f10.robotadvisor.model.Portfolio;
import com.zuhlke.f10.robotadvisor.model.ServerError;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

public interface PortfolioApi {

    @ApiOperation(value = "Create Portfolio", nickname = "createPortfolio", notes = "", response = Portfolio.class, authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Portfolios",})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "", response = Portfolio.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/customers/{customer_id}/portfolios",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<Portfolio> createPortfolio(@ApiParam(value = "", required = true) @PathVariable("customer_id") String customerId, @ApiParam(value = "") @Valid @RequestBody Portfolio body);

    @ApiOperation(value = "Delete Portfolio", nickname = "deletePortfolio", notes = "", authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Portfolios",})
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = ""),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/customers/{customer_id}/portfolios/{portfolio_id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deletePortfolio(@ApiParam(value = "", required = true) @PathVariable("customer_id") String customerId, @ApiParam(value = "", required = true) @PathVariable("portfolio_id") String portfolioId);

    @ApiOperation(value = "Get Portfolio", nickname = "getPortfolio", notes = "", response = Portfolio.class, authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Portfolios",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "", response = Portfolio.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/customers/{customer_id}/portfolios/{portfolio_id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<Portfolio> getPortfolio(@ApiParam(value = "", required = true) @PathVariable("customer_id") String customerId, @ApiParam(value = "", required = true) @PathVariable("portfolio_id") String portfolioId);


    @ApiOperation(value = "Update Portfolio", nickname = "updatePortfolio", notes = "", response = Portfolio.class, authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Portfolios",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "", response = Portfolio.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/customers/{customer_id}/portfolios/{portfolio_id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    ResponseEntity<Portfolio> updatePortfolio(@ApiParam(value = "", required = true) @PathVariable("customer_id") String customerId, @ApiParam(value = "", required = true) @PathVariable("portfolio_id") String portfolioId, @ApiParam(value = "") @Valid @RequestBody Portfolio body);


}
