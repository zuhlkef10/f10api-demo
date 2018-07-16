package com.zuhlke.f10.crowdlending.controller;

import com.zuhlke.f10.crowdlending.model.Borrower;
import com.zuhlke.f10.crowdlending.model.GenericError;
import com.zuhlke.f10.crowdlending.model.ListBorrowerResponse;
import com.zuhlke.f10.crowdlending.model.ServerError;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Api(value = "borrowers", description = "the borrowers API")
public interface BorrowerApi {

    @ApiOperation(value = "Create Borrower", nickname = "createBorrower", notes = "", response = Borrower.class, authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Borrowers",})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "", response = Borrower.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/borrowers",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<Borrower> createBorrower(@ApiParam(value = "") @Valid @RequestBody Borrower body);


    @ApiOperation(value = "Delete Borrower", nickname = "deleteBorrower", notes = "", authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Borrowers",})
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = ""),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/borrowers/{borrower_id}",
            produces = {"application/json"},
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteBorrower(@ApiParam(value = "", required = true) @PathVariable("borrower_id") String borrowerId);


    @ApiOperation(value = "Get Borrower", nickname = "getBorrower", notes = "", response = Borrower.class, authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Borrowers",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "", response = Borrower.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/borrowers/{borrower_id}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<Borrower> getBorrower(@ApiParam(value = "", required = true) @PathVariable("borrower_id") String borrowerId);


    @ApiOperation(value = "List Borrowers", nickname = "listBorrowers", notes = "", response = ListBorrowerResponse.class, authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Borrowers",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Response", response = ListBorrowerResponse.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/borrowers",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<ListBorrowerResponse> listBorrowers();


    @ApiOperation(value = "Update Borrower", nickname = "updateBorrower", notes = "", response = Borrower.class, authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Borrowers",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "", response = Borrower.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/borrowers/{borrower_id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    ResponseEntity<Borrower> updateBorrower(@ApiParam(value = "", required = true) @PathVariable("borrower_id") String borrowerId, @ApiParam(value = "") @Valid @RequestBody Borrower body);

}
