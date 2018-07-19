package com.zuhlke.f10.robotadvisor.portfolio.controller;

import com.zuhlke.f10.robotadvisor.model.GenericError;
import com.zuhlke.f10.robotadvisor.model.Portfolio;
import com.zuhlke.f10.robotadvisor.model.PortfolioInfo;
import com.zuhlke.f10.robotadvisor.model.ServerError;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public interface PortfolioApi {

    @ApiOperation(value = "Create Portfolio", nickname = "createPortfolio", notes = "", response = PortfolioInfo.class, authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Portfolios",})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "", response = PortfolioInfo.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericError.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 404, message = "Resource Not Found", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/customers/{customer_id}/portfolios",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<PortfolioInfo> createPortfolio(@ApiParam(value = "", required = true) @PathVariable("customer_id") String customerId, @ApiParam(value = "") @Valid @RequestBody Portfolio body);

    @ApiOperation(value = "Delete Portfolio", nickname = "deletePortfolio", notes = "", authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Portfolios",})
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Successfully Deleted"),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericError.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 404, message = "Resource Not Found", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/customers/{customer_id}/portfolios/{portfolio_id}",
            produces = {"application/json"},
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deletePortfolio(@ApiParam(value = "", required = true) @PathVariable("customer_id") String customerId, @ApiParam(value = "", required = true) @PathVariable("portfolio_id") String portfolioId);

    @ApiOperation(value = "Get Portfolio", nickname = "getPortfolio", notes = "", response = PortfolioInfo.class, authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Portfolios",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "", response = PortfolioInfo.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericError.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 404, message = "Resource Not Found", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/customers/{customer_id}/portfolios/{portfolio_id}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<PortfolioInfo> getPortfolio(@ApiParam(value = "", required = true) @PathVariable("customer_id") String customerId, @ApiParam(value = "", required = true) @PathVariable("portfolio_id") String portfolioId);


    @ApiOperation(value = "List Portfolios", nickname = "listPortfolios", notes = "", response = PortfolioInfo.class, responseContainer = "List", authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Portfolios",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Response", response = PortfolioInfo.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericError.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 404, message = "Resource Not Found", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/customers/{customer_id}/portfolios",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<List<PortfolioInfo>> listPortfolios(@ApiParam(value = "", required = true) @PathVariable("customer_id") String customerId, @ApiParam(value = "") @Valid @RequestParam(value = "status", required = false) String status);

    @ApiOperation(value = "Update Portfolio", nickname = "updatePortfolio", notes = "", response = PortfolioInfo.class, authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Portfolios",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response", response = PortfolioInfo.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericError.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 404, message = "Resource Not Found", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/customers/{customer_id}/portfolios/{portfolio_id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    ResponseEntity<PortfolioInfo> updatePortfolio(@ApiParam(value = "", required = true) @PathVariable("customer_id") String customerId, @ApiParam(value = "", required = true) @PathVariable("portfolio_id") String portfolioId, @ApiParam(value = "") @Valid @RequestBody Portfolio body);


}
