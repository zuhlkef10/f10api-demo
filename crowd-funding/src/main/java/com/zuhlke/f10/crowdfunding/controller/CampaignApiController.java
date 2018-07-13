package com.zuhlke.f10.crowdfunding.controller;

import com.zuhlke.f10.crowdfunding.model.Campaign;
import com.zuhlke.f10.crowdfunding.model.ListCampaignResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CampaignApiController implements CampaignApi {
    @RequestMapping(value = "/campaigns",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    @Override
    public ResponseEntity<Campaign> createCampaign(@Valid @RequestBody Campaign body) {
        return null;
    }

    @RequestMapping(value = "/campaigns/{campaign_id}",
            produces = {"application/json"},
            method = RequestMethod.DELETE)
    @Override
    public ResponseEntity<Void> deleteCampaign(@PathVariable("campaign_id") String campaignId) {
        return null;
    }

    @RequestMapping(value = "/campaigns/{campaign_id}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    @Override
    public ResponseEntity<Campaign> getCampaign(@PathVariable("campaign_id") String campaignId) {
        return null;
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
        return null;
    }

    @RequestMapping(value = "/campaigns/{campaign_id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    @Override
    public ResponseEntity<Campaign> updateCampaign(@PathVariable("campaign_id") String campaignId, @Valid @RequestBody Campaign body) {
        return null;
    }
}
