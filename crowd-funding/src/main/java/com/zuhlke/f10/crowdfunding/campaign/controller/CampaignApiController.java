package com.zuhlke.f10.crowdfunding.campaign.controller;

import com.zuhlke.f10.crowdfunding.campaign.service.CampaignService;
import com.zuhlke.f10.crowdfunding.model.Campaign;
import com.zuhlke.f10.crowdfunding.model.ListCampaignResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CampaignApiController implements CampaignApi {

    @Autowired
    private CampaignService campaignService;

    @RequestMapping(value = "/campaigns",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    @Override
    public ResponseEntity<Campaign> createCampaign(@Valid @RequestBody Campaign body) {
        return ResponseEntity.status(HttpStatus.CREATED).body(campaignService.createCampaign(body));
    }

    @RequestMapping(value = "/campaigns/{campaign_id}",
            produces = {"application/json"},
            method = RequestMethod.DELETE)
    @Override
    public ResponseEntity<Void> deleteCampaign(@PathVariable("campaign_id") String campaignId) {
        campaignService.deleteCampaign(campaignId);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/campaigns/{campaign_id}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    @Override
    public ResponseEntity<Campaign> getCampaign(@PathVariable("campaign_id") String campaignId) {
        return ResponseEntity.ok().body(campaignService.getCampaign(campaignId));
    }

    @RequestMapping(value = "/campaigns",
            produces = {"application/json"},
            method = RequestMethod.GET)
    @Override
    public ResponseEntity<ListCampaignResponse> listCampaigns(@Valid @RequestParam(value = "name", required = false) String name,
                                                              @Valid @RequestParam(value = "organizer", required = false) String organizer,
                                                              @Valid @RequestParam(value = "offset", required = false) Integer offset,
                                                              @Valid @RequestParam(value = "limit", required = false) Integer limit,
                                                              @Valid @RequestParam(value = "sort", required = false) List<String> sort,
                                                              @Valid @RequestParam(value = "status", required = false) String status,
                                                              @Valid @RequestParam(value = "category", required = false) String category) {
        return ResponseEntity.ok().body(campaignService.listCampaigns(name, organizer, offset, limit, sort, status, category));
    }

    @RequestMapping(value = "/campaigns/{campaign_id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    @Override
    public ResponseEntity<Campaign> updateCampaign(@PathVariable("campaign_id") String campaignId, @Valid @RequestBody Campaign body) {
        return ResponseEntity.ok().body(campaignService.updateCampaign(campaignId, body));
    }
}
