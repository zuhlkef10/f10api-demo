package com.zuhlke.f10.crowdfunding.campaign.repository;

import com.zuhlke.f10.crowdfunding.model.Campaign;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CampaignRepository extends MongoRepository<Campaign, String> {

}
