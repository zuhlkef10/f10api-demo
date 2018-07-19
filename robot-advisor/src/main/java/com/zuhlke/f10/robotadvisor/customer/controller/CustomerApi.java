package com.zuhlke.f10.robotadvisor.customer.controller;

import com.zuhlke.f10.robotadvisor.model.Customer;
import com.zuhlke.f10.robotadvisor.model.CustomerInfo;
import com.zuhlke.f10.robotadvisor.model.GenericError;
import com.zuhlke.f10.robotadvisor.model.ServerError;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public interface CustomerApi {

    @ApiOperation(value = "Create Customer", nickname = "createCustomer", notes = "", response = CustomerInfo.class, authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Customers",})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "", response = CustomerInfo.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericError.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 404, message = "Resource Not Found", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/customers",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<CustomerInfo> createCustomer(@ApiParam(value = "") @Valid @RequestBody Customer body);

    @ApiOperation(value = "Delete Customer", nickname = "deleteCustomer", notes = "", authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Customers",})
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Successfully Deleted"),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericError.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 404, message = "Resource Not Found", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/customers/{customer_id}",
            produces = {"application/json"},
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteCustomer(@ApiParam(value = "", required = true) @PathVariable("customer_id") String customerId);

    @ApiOperation(value = "Get Customer", nickname = "getCustomer", notes = "", response = CustomerInfo.class, authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Customers",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "", response = CustomerInfo.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericError.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 404, message = "Resource Not Found", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/customers/{customer_id}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<CustomerInfo> getCustomer(@ApiParam(value = "", required = true) @PathVariable("customer_id") String customerId);

    @ApiOperation(value = "List Customers", nickname = "listCustomers", notes = "", response = CustomerInfo.class, responseContainer = "List", authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Customers",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Response", response = CustomerInfo.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericError.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 404, message = "Resource Not Found", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/customers",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<List<CustomerInfo>> listCustomers(@ApiParam(value = "Name of the customer to filter") @Valid @RequestParam(value = "name", required = false) String name, @ApiParam(value = "Email of the customer to filter") @Valid @RequestParam(value = "email", required = false) String email);


    @ApiOperation(value = "Update Customer", nickname = "updateCustomer", notes = "", response = CustomerInfo.class, authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Customers",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "", response = CustomerInfo.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericError.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 404, message = "Resource Not Found", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/customers/{customer_id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    ResponseEntity<CustomerInfo> updateCustomer(@ApiParam(value = "", required = true) @PathVariable("customer_id") String customerId, @ApiParam(value = "") @Valid @RequestBody Customer body);

}
