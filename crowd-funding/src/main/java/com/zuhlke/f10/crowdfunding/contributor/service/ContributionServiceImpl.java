package com.zuhlke.f10.crowdfunding.contributor.service;

import com.zuhlke.f10.crowdfunding.campaign.repository.CampaignRepository;
import com.zuhlke.f10.crowdfunding.config.CfErrorConfigEnum;
import com.zuhlke.f10.crowdfunding.contributor.repository.ContributionRepository;
import com.zuhlke.f10.crowdfunding.contributor.repository.ContributorRepository;
import com.zuhlke.f10.crowdfunding.exception.ResourceNotFoundException;
import com.zuhlke.f10.crowdfunding.model.Contribution;
import com.zuhlke.f10.crowdfunding.model.ContributionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ContributionServiceImpl implements ContributionService {

    @Autowired
    private ContributionRepository contributionRepository;

    @Autowired
    private ContributorRepository contributorRepository;

    @Autowired
    private CampaignRepository campaignRepository;

    @Override
    public ContributionInfo addContributionDetails(String campaignId, String contributorId, Contribution body) {
        return campaignRepository.findById(campaignId).map(campaignInfo -> {
            return contributorRepository.findById(contributorId).map(contributorInfo -> {
                ContributionInfo contributionInfo = new ContributionInfo().contribution(body);
                contributionInfo =  contributionRepository.insert(contributionInfo);
                BigDecimal totalAmount = contributorInfo.getContributor().getAmount();
                totalAmount = totalAmount == null ? BigDecimal.ZERO : totalAmount;
                totalAmount = totalAmount.add(contributionInfo.getContribution().getAmount());
                contributorInfo.getContributor().setAmount(totalAmount);
                contributorRepository.save(contributorInfo);
                BigDecimal campaignAmount = campaignInfo.getCampaign().getRaisedAmount();
                campaignAmount = campaignAmount == null ? BigDecimal.ZERO : campaignAmount;
                campaignAmount = campaignAmount.add(contributionInfo.getContribution().getAmount());
                campaignInfo.getCampaign().setRaisedAmount(campaignAmount);
                campaignRepository.save(campaignInfo);
                return contributionInfo;
            }).orElseThrow(() -> new ResourceNotFoundException(CfErrorConfigEnum.CF_CONTRIBUTOR_NOT_FOUND));
        }).orElseThrow(() -> new ResourceNotFoundException(CfErrorConfigEnum.CF_CAMPAIGN_NOT_FOUND));

    }
}
