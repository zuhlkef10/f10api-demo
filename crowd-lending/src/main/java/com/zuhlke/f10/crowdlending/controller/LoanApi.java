package com.zuhlke.f10.crowdlending.controller;

import com.zuhlke.f10.crowdlending.model.GenericError;
import com.zuhlke.f10.crowdlending.model.ListLoanResponse;
import com.zuhlke.f10.crowdlending.model.Loan;
import com.zuhlke.f10.crowdlending.model.ServerError;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Api(value = "loans", description = "the loans API")
public interface LoanApi {

    @ApiOperation(value = "Create Loan", nickname = "createLoan", notes = "", response = Loan.class, authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Loans",})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "", response = Loan.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/loans",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<Loan> createLoan(@ApiParam(value = "") @Valid @RequestBody Loan body);


    @ApiOperation(value = "Delete Loan", nickname = "deleteLoan", notes = "", authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Loans",})
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = ""),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/loans/{loan_id}",
            produces = {"application/json"},
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteLoan(@ApiParam(value = "", required = true) @PathVariable("loan_id") String loanId);


    @ApiOperation(value = "Get Loan", nickname = "getLoan", notes = "", response = Loan.class, authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Loans",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "", response = Loan.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/loans/{loan_id}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<Loan> getLoan(@ApiParam(value = "", required = true) @PathVariable("loan_id") String loanId);


    @ApiOperation(value = "List Loans", nickname = "listLoans", notes = "", response = ListLoanResponse.class, authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Loans",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "", response = ListLoanResponse.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/loans",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<ListLoanResponse> listLoans();


    @ApiOperation(value = "Update Loan", nickname = "updateLoan", notes = "", response = Loan.class, authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Loans",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "", response = Loan.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/loans/{loan_id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    ResponseEntity<Loan> updateLoan(@ApiParam(value = "", required = true) @PathVariable("loan_id") String loanId, @ApiParam(value = "") @Valid @RequestBody Loan body);

}
