package com.zuhlke.f10.crowdfunding.campaign.service;

import com.zuhlke.f10.crowdfunding.campaign.repository.CampaignRepository;
import com.zuhlke.f10.crowdfunding.model.Campaign;
import com.zuhlke.f10.crowdfunding.model.ListCampaignResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignServiceImpl implements CampaignService {

    @Autowired
    private CampaignRepository campaignRepository;

    @Override
    public Campaign createCampaign(Campaign body) {
        return campaignRepository.save(body);
    }

    @Override
    public void deleteCampaign(String campaignId) {
        campaignRepository.deleteById(campaignId);
    }

    @Override
    public Campaign getCampaign(String campaignId) {
        return campaignRepository.findById(campaignId).orElse(null);
    }

    @Override
    public ListCampaignResponse listCampaigns(String name, String organizer, Integer offset, Integer limit, List<String> sort, String status, String category) {
        List<Campaign> campaignList = campaignRepository.findAll();
        ListCampaignResponse listCampaignResponse = new ListCampaignResponse()
                .data(campaignList);
        return listCampaignResponse;
    }

    @Override
    public Campaign updateCampaign(String campaignId, Campaign body) {
        return campaignRepository.save(body);
    }
}
