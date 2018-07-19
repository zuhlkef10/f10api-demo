package com.zuhlke.f10.crowdfunding.contributor.service;

import com.zuhlke.f10.crowdfunding.model.Contributor;
import com.zuhlke.f10.crowdfunding.model.ContributorInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ContributorService {

    ContributorInfo getContributor(String campaignId, String contributorId);

    ContributorInfo registerContributor(String campaignId, Contributor body);

    ContributorInfo updateContributor(String campaignId, String contributorId, Contributor body);

    List<ContributorInfo> listContributors(String campaignId);

    void deleteContributor(String campaignId,  String contributorId);

}
