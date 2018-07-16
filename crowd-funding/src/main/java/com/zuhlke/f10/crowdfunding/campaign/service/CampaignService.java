package com.zuhlke.f10.crowdfunding.campaign.service;

import com.zuhlke.f10.crowdfunding.model.Campaign;
import com.zuhlke.f10.crowdfunding.model.ListCampaignResponse;

import java.util.List;

public interface CampaignService {

    Campaign createCampaign(Campaign body);

    void deleteCampaign(String campaignId);

    Campaign getCampaign(String campaignId);

    ListCampaignResponse listCampaigns(String name,
                                       String organizer,
                                       Integer offset,
                                       Integer limit,
                                       List<String> sort,
                                       String status,
                                       String category);

    Campaign updateCampaign(String campaignId, Campaign body);

}
