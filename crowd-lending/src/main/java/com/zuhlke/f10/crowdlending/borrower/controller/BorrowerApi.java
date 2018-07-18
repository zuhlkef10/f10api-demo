package com.zuhlke.f10.crowdlending.borrower.controller;

import com.zuhlke.f10.crowdlending.model.*;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "borrowers", description = "the borrowers API")
public interface BorrowerApi {

    @ApiOperation(value = "Create Borrower", nickname = "createBorrower", notes = "", response = CreateBorrowerResponse.class, authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Borrowers",})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully created Borrower", response = CreateBorrowerResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericError.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 404, message = "Resource Not Found", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/borrowers",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<CreateBorrowerResponse> createBorrower(@ApiParam(value = "") @Valid @RequestBody Borrower body);


    @ApiOperation(value = "Delete Borrower", nickname = "deleteBorrower", notes = "", authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Borrowers",})
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Successfully deleted"),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericError.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 404, message = "Resource Not Found", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/borrowers/{borrower_id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteBorrower(@ApiParam(value = "", required = true) @PathVariable("borrower_id") String borrowerId);


    @ApiOperation(value = "Get Borrower", nickname = "getBorrower", notes = "", response = BorrowerInfo.class, authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Borrowers",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Response", response = BorrowerInfo.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericError.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 404, message = "Resource Not Found", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/borrowers/{borrower_id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<BorrowerInfo> getBorrower(@ApiParam(value = "", required = true) @PathVariable("borrower_id") String borrowerId);


    @ApiOperation(value = "List Borrowers", nickname = "listBorrowers", notes = "", response = BorrowerInfo.class, responseContainer = "List", authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Borrowers",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Response", response = BorrowerInfo.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericError.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 404, message = "Resource Not Found", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/borrowers",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<List<BorrowerInfo>> listBorrowers(@ApiParam(value = "Search all borrowers by name") @Valid @RequestParam(value = "name", required = false) String name, @ApiParam(value = "Search all borrowers by email") @Valid @RequestParam(value = "email", required = false) String email);


    @ApiOperation(value = "Update Borrower", nickname = "updateBorrower", notes = "", response = BorrowerInfo.class, authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Borrowers",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Response", response = BorrowerInfo.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericError.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 404, message = "Resource Not Found", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/borrowers/{borrower_id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    ResponseEntity<BorrowerInfo> updateBorrower(@ApiParam(value = "", required = true) @PathVariable("borrower_id") String borrowerId, @ApiParam(value = "") @Valid @RequestBody Borrower body);

}
