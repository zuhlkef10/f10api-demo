package com.zuhlke.f10.robotadvisor.controller;

import com.zuhlke.f10.robotadvisor.model.Customer;
import com.zuhlke.f10.robotadvisor.model.GenericError;
import com.zuhlke.f10.robotadvisor.model.InlineResponse200;
import com.zuhlke.f10.robotadvisor.model.ServerError;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

public interface CustomerApi {

    @ApiOperation(value = "Create Customer", nickname = "createCustomer", notes = "", response = Customer.class, authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Customers",})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "", response = Customer.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/customers",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<Customer> createCustomer(@ApiParam(value = "") @Valid @RequestBody Customer body);


    @ApiOperation(value = "Delete Customer", nickname = "deleteCustomer", notes = "", authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Customers",})
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = ""),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/customers/{customer_id}",
            produces = {"application/json"},
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteCustomer(@ApiParam(value = "", required = true) @PathVariable("customer_id") String customerId);


    @ApiOperation(value = "Get Customer", nickname = "getCustomer", notes = "", response = Customer.class, authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Customers",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "", response = Customer.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/customers/{customer_id}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<Customer> getCustomer(@ApiParam(value = "", required = true) @PathVariable("customer_id") String customerId);

    @ApiOperation(value = "List Customers", nickname = "listCustomers", notes = "", response = InlineResponse200.class, authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Customers",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "", response = InlineResponse200.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/customers",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<InlineResponse200> listCustomers();


    @ApiOperation(value = "Update Customer", nickname = "updateCustomer", notes = "", response = Customer.class, authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Customers",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "", response = Customer.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/customers/{customer_id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    ResponseEntity<Customer> updateCustomer(@ApiParam(value = "", required = true) @PathVariable("customer_id") String customerId, @ApiParam(value = "") @Valid @RequestBody Customer body);


}
