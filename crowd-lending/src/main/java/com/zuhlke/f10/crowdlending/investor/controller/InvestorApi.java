package com.zuhlke.f10.crowdlending.investor.controller;

import com.zuhlke.f10.crowdlending.model.*;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Api(value = "investors", description = "the investors API")
public interface InvestorApi {

    @ApiOperation(value = "Create Investor", nickname = "createInvestor", notes = "", response = CreateInvestorResponse.class, authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Investors",})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "", response = CreateInvestorResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericError.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 404, message = "Resource Not Found", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/investors",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<CreateInvestorResponse> createInvestor(@ApiParam(value = "") @Valid @RequestBody Investor body);


    @ApiOperation(value = "Delete Investor", nickname = "deleteInvestor", notes = "", authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Investors",})
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Successfully Deleted")})
    @RequestMapping(value = "/investors/{investor_id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteInvestor(@ApiParam(value = "", required = true) @PathVariable("investor_id") String investorId);


    @ApiOperation(value = "Get Investor", nickname = "getInvestor", notes = "", response = InvestorInfo.class, authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Investors",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Response", response = InvestorInfo.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericError.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 404, message = "Resource Not Found", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/investors/{investor_id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<InvestorInfo> getInvestor(@ApiParam(value = "", required = true) @PathVariable("investor_id") String investorId);


    @ApiOperation(value = "List Investors", nickname = "listInvestors", notes = "", response = InvestorInfo.class, responseContainer = "List", authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Investors",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Response", response = InvestorInfo.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericError.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 404, message = "Resource Not Found", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/investors",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<List<InvestorInfo>> listInvestors(@ApiParam(value = "Search all investors by name") @Valid @RequestParam(value = "name", required = false) String name, @ApiParam(value = "Search all investors by email") @Valid @RequestParam(value = "email", required = false) String email);


    @ApiOperation(value = "Update Investor", nickname = "updateInvestor", notes = "", response = InvestorInfo.class, authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Investors",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Response", response = InvestorInfo.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericError.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 404, message = "Resource Not Found", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/investors/{investor_id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    ResponseEntity<InvestorInfo> updateInvestor(@ApiParam(value = "", required = true) @PathVariable("investor_id") String investorId, @ApiParam(value = "") @Valid @RequestBody Investor body);

}
