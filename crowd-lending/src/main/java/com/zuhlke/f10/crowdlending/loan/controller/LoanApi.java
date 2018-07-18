package com.zuhlke.f10.crowdlending.loan.controller;

import com.zuhlke.f10.crowdlending.model.*;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Api(value = "loans", description = "the loans API")
public interface LoanApi {

    @ApiOperation(value = "Investment to the loan", nickname = "createInvestment", notes = "", response = InvestmentInfo.class, authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Loans",})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful Response", response = InvestmentInfo.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericError.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 404, message = "Resource Not Found", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/loans/{loan_id}/investments",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<InvestmentInfo> createInvestment(@ApiParam(value = "", required = true) @PathVariable("loan_id") String loanId, @ApiParam(value = "") @Valid @RequestBody Investment body);


    @ApiOperation(value = "Create Loan", nickname = "createLoan", notes = "", response = CreateLoanResponse.class, authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Loans",})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "", response = CreateLoanResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericError.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 404, message = "Resource Not Found", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/loans",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<CreateLoanResponse> createLoan(@ApiParam(value = "") @Valid @RequestBody Loan body);


    @ApiOperation(value = "Repayment of the loan", nickname = "createRepayment", notes = "", response = RepaymentInfo.class, authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Loans",})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful Response", response = RepaymentInfo.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericError.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 404, message = "Resource Not Found", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/loans/{loan_id}/repayments",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<RepaymentInfo> createRepayment(@ApiParam(value = "", required = true) @PathVariable("loan_id") String loanId, @ApiParam(value = "") @Valid @RequestBody Repayment body);


    @ApiOperation(value = "Delete Loan", nickname = "deleteLoan", notes = "", authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Loans",})
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Successful Response"),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericError.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 404, message = "Resource Not Found", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/loans/{loan_id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteLoan(@ApiParam(value = "", required = true) @PathVariable("loan_id") String loanId);


    @ApiOperation(value = "Get Investments of a loan", nickname = "getInvestments", notes = "", response = InvestmentInfo.class, authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Loans",})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful Response", response = InvestmentInfo.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericError.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 404, message = "Resource Not Found", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/loans/{loan_id}/investments",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<List<InvestmentInfo>> getInvestments(@ApiParam(value = "", required = true) @PathVariable("loan_id") String loanId, @ApiParam(value = "Investor Id of the investments") @Valid @RequestParam(value = "investor_id", required = false) String investorId, @ApiParam(value = "From date to get all the investments for a loan") @Valid @RequestParam(value = "from_date", required = false) LocalDate fromDate, @ApiParam(value = "to date to get all the investments for a loan. Default is current date") @Valid @RequestParam(value = "to_date", required = false) LocalDate toDate);


    @ApiOperation(value = "Get Loan", nickname = "getLoan", notes = "", response = LoanInfo.class, authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Loans",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Response", response = LoanInfo.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericError.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 404, message = "Resource Not Found", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/loans/{loan_id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<LoanInfo> getLoan(@ApiParam(value = "", required = true) @PathVariable("loan_id") String loanId);


    @ApiOperation(value = "Get all the Repayment details of the loan", nickname = "getRepayments", notes = "", response = RepaymentInfo.class, authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Loans",})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful Response", response = RepaymentInfo.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericError.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 404, message = "Resource Not Found", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/loans/{loan_id}/repayments",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<List<RepaymentInfo>> getRepayments(@ApiParam(value = "", required = true) @PathVariable("loan_id") String loanId, @ApiParam(value = "From date to get all the repayments for a loan") @Valid @RequestParam(value = "from_date", required = false) LocalDate fromDate, @ApiParam(value = "to date to get all the repayments for a loan. Default is current date") @Valid @RequestParam(value = "to_date", required = false) LocalDate toDate);


    @ApiOperation(value = "List Loans", nickname = "listLoans", notes = "", response = LoanInfo.class, responseContainer = "List", authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Loans",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Response", response = LoanInfo.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericError.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 404, message = "Resource Not Found", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/loans",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<List<LoanInfo>> listLoans(@ApiParam(value = "Investor Id of the investments") @Valid @RequestParam(value = "loan_type", required = false) String loanType, @ApiParam(value = "From date to get all the investments created after this date") @Valid @RequestParam(value = "from_date", required = false) LocalDate fromDate, @ApiParam(value = "to date to get all the investments created before this date. Default is current date") @Valid @RequestParam(value = "to_date", required = false) LocalDate toDate);


    @ApiOperation(value = "Update Loan", nickname = "updateLoan", notes = "", response = LoanInfo.class, authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Loans",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Response", response = LoanInfo.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericError.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 404, message = "Resource Not Found", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/loans/{loan_id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    ResponseEntity<LoanInfo> updateLoan(@ApiParam(value = "", required = true) @PathVariable("loan_id") String loanId, @ApiParam(value = "") @Valid @RequestBody Loan body);

}
