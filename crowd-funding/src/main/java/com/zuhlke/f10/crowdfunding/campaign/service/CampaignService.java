package com.zuhlke.f10.crowdfunding.campaign.service;

import com.zuhlke.f10.crowdfunding.model.Campaign;
import com.zuhlke.f10.crowdfunding.model.CampaignInfo;

import java.util.List;

public interface CampaignService {

    CampaignInfo createCampaign(Campaign body);

    void deleteCampaign(String campaignId);

    CampaignInfo getCampaign(String campaignId);

    List<CampaignInfo> listCampaigns(String name,
                                     String status,
                                     String category,
                                     List<String> sort);

    CampaignInfo updateCampaign(String campaignId, Campaign body);

}
