package com.zuhlke.f10.crowdfunding.controller;

import com.zuhlke.f10.crowdfunding.model.Contributor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ContributorApiController implements ContributorApi{
    @RequestMapping(value = "/campaigns/{campaign_id}/contributors/{contributor_id}",
            produces = {"application/json"},
            method = RequestMethod.DELETE)
    @Override
    public ResponseEntity<Void> deleteContributor(@PathVariable("campaign_id")String campaignId, @PathVariable("contributor_id") String contributorId) {
        return null;
    }

    @RequestMapping(value = "/campaigns/{campaign_id}/contributors",
            produces = {"application/json"},
            method = RequestMethod.GET)
    @Override
    public ResponseEntity<List<Contributor>> listContributors(@PathVariable("campaign_id") String campaignId) {
        return null;
    }

    @RequestMapping(value = "/campaigns/{campaign_id}/contributors",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    @Override
    public ResponseEntity<Contributor> registerContributor(@PathVariable("campaign_id") String campaignId, @Valid  @RequestBody Contributor body) {
        return null;
    }

    @RequestMapping(value = "/campaigns/{campaign_id}/contributors/{contributor_id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    @Override
    public ResponseEntity<Contributor> updateContributor(@PathVariable("campaign_id") String campaignId, @PathVariable("contributor_id") String contributorId, @Valid @RequestBody Contributor body) {
        return null;
    }
}
