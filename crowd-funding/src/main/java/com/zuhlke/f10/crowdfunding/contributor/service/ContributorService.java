package com.zuhlke.f10.crowdfunding.contributor.service;

import com.zuhlke.f10.crowdfunding.model.Contributor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ContributorService {

    Contributor getContributor(String campaignId, String contributorId);

    Contributor registerContributor(String campaignId, Contributor body);

    Contributor updateContributor(String campaignId, String contributorId, Contributor body);

    List<Contributor> listContributors(String campaignId);

    void deleteContributor(String campaignId,  String contributorId);

}
