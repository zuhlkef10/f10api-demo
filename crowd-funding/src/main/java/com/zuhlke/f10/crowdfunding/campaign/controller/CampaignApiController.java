package com.zuhlke.f10.crowdfunding.campaign.controller;

import com.zuhlke.f10.crowdfunding.campaign.service.CampaignService;
import com.zuhlke.f10.crowdfunding.model.Campaign;
import com.zuhlke.f10.crowdfunding.model.CampaignInfo;
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
    public ResponseEntity<CampaignInfo> createCampaign(@Valid @RequestBody Campaign body) {
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
    public ResponseEntity<CampaignInfo> getCampaign(@PathVariable("campaign_id") String campaignId) {
        return ResponseEntity.ok().body(campaignService.getCampaign(campaignId));
    }

    @RequestMapping(value = "/campaigns",
            produces = {"application/json"},
            method = RequestMethod.GET)
    @Override
    public ResponseEntity<List<CampaignInfo>> listCampaigns(@Valid @RequestParam(value = "name", required = false) String name,
                                                            @Valid @RequestParam(value = "status", required = false) String status,
                                                            @Valid @RequestParam(value = "category", required = false) String category,
                                                            @Valid @RequestParam(value = "sort", required = false) List<String> sort) {
        return ResponseEntity.ok().body(campaignService.listCampaigns(name, status, category, sort));
    }

    @RequestMapping(value = "/campaigns/{campaign_id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    @Override
    public ResponseEntity<CampaignInfo> updateCampaign(@PathVariable("campaign_id") String campaignId, @Valid @RequestBody Campaign body) {
        return ResponseEntity.ok().body(campaignService.updateCampaign(campaignId, body));
    }
}
