package com.zuhlke.f10.crowdfunding.contributor.controller;

import com.zuhlke.f10.crowdfunding.model.Campaign;
import com.zuhlke.f10.crowdfunding.model.Contributor;
import com.zuhlke.f10.crowdfunding.model.GenericError;
import com.zuhlke.f10.crowdfunding.model.ServerError;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Api(value = "contributors", description = "the contributors API")
public interface ContributorApi {

    @ApiOperation(value = "Delete Contributor", nickname = "deleteContributor", notes = "", authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Contributors",})
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Succesfully Deleted"),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericError.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 404, message = "Resource Not Found", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/campaigns/{campaign_id}/contributors/{contributor_id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteContributor(@ApiParam(value = "", required = true) @PathVariable("campaign_id") String campaignId, @ApiParam(value = "", required = true) @PathVariable("contributor_id") String contributorId);


    @ApiOperation(value = "List Campaign Contributors", nickname = "listContributors", notes = "", response = Contributor.class, responseContainer = "List", authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Contributors",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Response", response = Contributor.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericError.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 404, message = "Resource Not Found", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/campaigns/{campaign_id}/contributors",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<List<Contributor>> listContributors(@ApiParam(value = "", required = true) @PathVariable("campaign_id") String campaignId);


    @ApiOperation(value = "Register As Contributor", nickname = "registerContributor", notes = "", response = Contributor.class, authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Contributors",})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful Response", response = Contributor.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericError.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 404, message = "Resource Not Found", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/campaigns/{campaign_id}/contributors",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<Contributor> registerContributor(@ApiParam(value = "", required = true) @PathVariable("campaign_id") String campaignId, @ApiParam(value = "") @Valid @RequestBody Contributor body);

    @ApiOperation(value = "Update Contributor Details", nickname = "updateContributor", notes = "", response = Contributor.class, authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Contributors",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Response", response = Contributor.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericError.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 404, message = "Resource Not Found", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/campaigns/{campaign_id}/contributors/{contributor_id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    ResponseEntity<Contributor> updateContributor(@ApiParam(value = "", required = true) @PathVariable("campaign_id") String campaignId, @ApiParam(value = "", required = true) @PathVariable("contributor_id") String contributorId, @ApiParam(value = "") @Valid @RequestBody Contributor body);


}
