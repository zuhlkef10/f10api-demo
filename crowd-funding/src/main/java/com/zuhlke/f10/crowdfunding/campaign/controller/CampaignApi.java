package com.zuhlke.f10.crowdfunding.campaign.controller;

import com.zuhlke.f10.crowdfunding.model.*;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Api(value = "campaigns", description = "the campaigns API")
public interface CampaignApi {

    @ApiOperation(value = "Create Campaign", nickname = "createCampaign", notes = "", response = Campaign.class, authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Campaigns",})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully Created", response = CampaignInfo.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericError.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 404, message = "Resource Not Found", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/campaigns",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<CampaignInfo> createCampaign(@ApiParam(value = "") @Valid @RequestBody Campaign body);


    @ApiOperation(value = "Delete Campaign", nickname = "deleteCampaign", notes = "", authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Campaigns",})
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Successfully Deleted"),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericError.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 404, message = "Resource Not Found", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/campaigns/{campaign_id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteCampaign(@ApiParam(value = "", required = true) @PathVariable("campaign_id") String campaignId);


    @ApiOperation(value = "Get Campaign", nickname = "getCampaign", notes = "", response = Campaign.class, authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Campaigns",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Response", response = Campaign.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericError.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 404, message = "Resource Not Found", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/campaigns/{campaign_id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<CampaignInfo> getCampaign(@ApiParam(value = "", required = true) @PathVariable("campaign_id") String campaignId);


    @ApiOperation(value = "List Campaigns", nickname = "listCampaigns", notes = "", response = CampaignInfo.class, responseContainer = "List", authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Campaigns",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Response", response = CampaignInfo.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericError.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 404, message = "Resource Not Found", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/campaigns",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<List<CampaignInfo>> listCampaigns(@ApiParam(value = "Name of the Campaign") @Valid @RequestParam(value = "name", required = false) String name, @ApiParam(value = "", allowableValues = "OPEN, CLOSED") @Valid @RequestParam(value = "status", required = false) String status, @ApiParam(value = "") @Valid @RequestParam(value = "category", required = false) String category, @ApiParam(value = "Fields to sort the response in ascending or descending order. To sort in descending order, select the field with \"-\" as prefix") @Valid @RequestParam(value = "sort", required = false) List<String> sort);


    @ApiOperation(value = "Update Campaign", nickname = "updateCampaign", notes = "", response = Campaign.class, authorizations = {
            @Authorization(value = "Authorization"),
            @Authorization(value = "X-API-KEY")
    }, tags = {"Campaigns",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Response", response = Campaign.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericError.class),
            @ApiResponse(code = 401, message = "Authentication Error", response = GenericError.class),
            @ApiResponse(code = 403, message = "Authorization Failed", response = GenericError.class),
            @ApiResponse(code = 404, message = "Resource Not Found", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ServerError.class)})
    @RequestMapping(value = "/campaigns/{campaign_id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    ResponseEntity<CampaignInfo> updateCampaign(@ApiParam(value = "", required = true) @PathVariable("campaign_id") String campaignId, @ApiParam(value = "") @Valid @RequestBody Campaign body);


}

