/**
 * NOTE: This class is auto generated by the swagger code generator program (2.3.1).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.zuhlke.f10.insurance.quotes.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zuhlke.f10.insurance.model.GenericError;
import com.zuhlke.f10.insurance.model.Quotes;
import com.zuhlke.f10.insurance.model.SearchCriteria;
import com.zuhlke.f10.insurance.model.ServerError;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Optional;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-07-16T17:46:09.699+08:00")

@Api(value = "quotes", description = "the quotes API")
public interface QuotesApi {

    Logger log = LoggerFactory.getLogger(QuotesApi.class);

    default Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    @ApiOperation(value = "Get Quotes", nickname = "pOSTQuotes", notes = "", response = Quotes.class, authorizations = {
        @Authorization(value = "Authorization"),
        @Authorization(value = "X-API-Key")
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful Response", response = Quotes.class),
        @ApiResponse(code = 400, message = "Bad Request", response = GenericError.class),
        @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
        @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class) })
    @RequestMapping(value = "/quotes",
        method = RequestMethod.POST)
   ResponseEntity<Quotes> getQuotes(@ApiParam(value = "The maximum number of results") @Valid @RequestParam(value = "limit", required = false) BigDecimal limit, @ApiParam(value = "Sort  results by specific fields") @Valid @RequestParam(value = "sort", required = false) String sort, @ApiParam(value = "") @Valid @RequestBody SearchCriteria body);


}
