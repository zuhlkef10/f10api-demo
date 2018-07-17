package com.zuhlke.f10.crowdfunding.campaign.service;

import com.zuhlke.f10.crowdfunding.campaign.repository.CampaignRepository;
import com.zuhlke.f10.crowdfunding.config.CfErrorConfigEnum;
import com.zuhlke.f10.crowdfunding.exception.ResourceNotFoundException;
import com.zuhlke.f10.crowdfunding.model.Campaign;
import com.zuhlke.f10.crowdfunding.model.CampaignInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;

@Service
public class CampaignServiceImpl implements CampaignService {

    @Autowired
    private CampaignRepository campaignRepository;

    @Override
    public String createCampaign(Campaign body) {
        CampaignInfo campaignInfo = new CampaignInfo().campaign(body);
        campaignInfo = campaignRepository.insert(campaignInfo);
        return campaignInfo.getId();
    }

    @Override
    public void deleteCampaign(String campaignId) {
        Optional<CampaignInfo> campaignInfoOptional = campaignRepository.findById(campaignId);
        if (campaignInfoOptional.isPresent()) {
            campaignRepository.deleteById(campaignId);
        } else {
            throw new ResourceNotFoundException(CfErrorConfigEnum.CF_CAMPAIGN_NOT_FOUND);
        }
    }

    @Override
    public CampaignInfo getCampaign(String campaignId) {
        return campaignRepository.findById(campaignId).orElseThrow(() -> new ResourceNotFoundException(CfErrorConfigEnum.CF_CAMPAIGN_NOT_FOUND));
    }

    @Override
    public List<CampaignInfo> listCampaigns(String name, String status, String category, List<String> sort) {
        ExampleMatcher campaignMatcher = ExampleMatcher.matching().withMatcher("campaign.name", contains().ignoreCase())
                .withMatcher("campaign.status", exact())
                .withMatcher("campaign.category", exact());

        Campaign campaign = new Campaign()
                .name(name)
                .status(status == null ? null : Campaign.StatusEnum.valueOf(status))
                .category(category);
        CampaignInfo campaignInfo = new CampaignInfo().campaign(campaign);
        Example<CampaignInfo> campaignInfoExample = Example.of(campaignInfo, campaignMatcher);
        Sort sortCriteria = buildSortCriteria(sort);
        return campaignRepository.findAll(campaignInfoExample, sortCriteria);
    }


    @Override
    public CampaignInfo updateCampaign(String campaignId, Campaign body) {
        return campaignRepository.findById(campaignId).map(campaignInfo -> {
            campaignInfo.setCampaign(body);
            return campaignRepository.save(campaignInfo);
        }).orElseThrow(() -> new ResourceNotFoundException(CfErrorConfigEnum.CF_CAMPAIGN_NOT_FOUND));
    }

    private Sort buildSortCriteria(List<String> sort) {
        if(!CollectionUtils.isEmpty(sort)){
            if(sort.size() == 1){
                return getSortCriteria(sort.get(0));
            }else if(sort.size() == 2){
                return getSortCriteria(sort.get(0)).and(getSortCriteria(sort.get(1)));
            }else if(sort.size() == 3){
                return getSortCriteria(sort.get(0)).and(getSortCriteria(sort.get(1))).and(getSortCriteria(sort.get(2)));
            }
        }
        return getSortCriteria("default");
    }


    private Sort getSortCriteria(String sortInput) {
        switch (sortInput) {
            case "NAME":
                return new Sort(Sort.Direction.ASC, "campaign.name");
            case "-NAME":
                return new Sort(Sort.Direction.DESC, "campaign.name");
            case "TARGET_AMOUNT":
                return new Sort(Sort.Direction.ASC, "campaign.targetAmount");
            case "-TARGET_AMOUNT":
                return new Sort(Sort.Direction.DESC, "campaign.targetAmount");
            case "CREATED_DATE":
                return new Sort(Sort.Direction.ASC, "campaign.createdDate");
            case "-CREATED_DATE":
                return new Sort(Sort.Direction.DESC, "campaign.createdDate");
            default:
                return new Sort(Sort.Direction.ASC, "campaign.name");
        }
    }
}
