package com.zuhlke.f10.crowdfunding.campaign.repository;

import com.zuhlke.f10.crowdfunding.model.Campaign;
import com.zuhlke.f10.crowdfunding.model.CampaignInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CampaignRepository extends MongoRepository<CampaignInfo, String> {

}
