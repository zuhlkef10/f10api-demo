package com.zuhlke.f10.crowdfunding.contributor.service;

import com.zuhlke.f10.crowdfunding.model.Contribution;
import com.zuhlke.f10.crowdfunding.model.ContributionInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface ContributionService {

    ContributionInfo addContributionDetails(String campaignId, String contributorId, Contribution body);

}
