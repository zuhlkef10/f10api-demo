package com.zuhlke.f10.crowdlending.controller;

import com.zuhlke.f10.crowdlending.model.GenericError;
import com.zuhlke.f10.crowdlending.model.Investor;
import com.zuhlke.f10.crowdlending.model.ListInvestorResponse;
import com.zuhlke.f10.crowdlending.model.ServerError;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


@Api(value = "investors", description = "the investors API")
public interface InvestorApi {

    @ApiOperation(value = "Create Investor", nickname = "createInvestor", notes = "", response = Investor.class, authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Investors",})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "", response = Investor.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/investors",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<Investor> createInvestor(@ApiParam(value = "") @Valid @RequestBody Investor body);


    @ApiOperation(value = "Delete Investor", nickname = "deleteInvestor", notes = "", authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Investors",})
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Successfully Deleted")})
    @RequestMapping(value = "/investors/{investor_id}",
            produces = {"application/json"},
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteInvestor(@ApiParam(value = "", required = true) @PathVariable("investor_id") String investorId);


    @ApiOperation(value = "Get Investor", nickname = "getInvestor", notes = "", response = Investor.class, authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Investors",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "", response = Investor.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/investors/{investor_id}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<Investor> getInvestor(@ApiParam(value = "", required = true) @PathVariable("investor_id") String investorId);


    @ApiOperation(value = "List Investors", nickname = "listInvestors", notes = "", response = ListInvestorResponse.class, authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Investors",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Response", response = ListInvestorResponse.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/investors",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<ListInvestorResponse> listInvestors();


    @ApiOperation(value = "Update Investor", nickname = "updateInvestor", notes = "", response = Investor.class, authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Investors",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "", response = Investor.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/investors/{investor_id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    ResponseEntity<Investor> updateInvestor(@ApiParam(value = "", required = true) @PathVariable("investor_id") String investorId, @ApiParam(value = "") @Valid @RequestBody Investor body);

}
