package com.zuhlke.f10.crowdfunding.contributor.service;

import com.zuhlke.f10.crowdfunding.campaign.repository.CampaignRepository;
import com.zuhlke.f10.crowdfunding.config.CfErrorConfigEnum;
import com.zuhlke.f10.crowdfunding.contributor.repository.ContributorRepository;
import com.zuhlke.f10.crowdfunding.exception.ResourceNotFoundException;
import com.zuhlke.f10.crowdfunding.model.Contributor;
import com.zuhlke.f10.crowdfunding.model.ContributorInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;

@Service
public class ContributorServiceImpl implements ContributorService {

    @Autowired
    private ContributorRepository contributorRepository;

    @Autowired
    private CampaignRepository campaignRepository;

    @Override
    public ContributorInfo getContributor(String campaignId, String contributorId) {
        return contributorRepository.findById(contributorId).orElseThrow(() -> new ResourceNotFoundException(CfErrorConfigEnum.CF_CONTRIBUTOR_NOT_FOUND));
    }

    @Override
    public ContributorInfo registerContributor(String campaignId, Contributor body) {
        return campaignRepository.findById(campaignId).map(campaignInfo -> {
            ContributorInfo contributorInfo = new ContributorInfo()
                    .contributor(body)
                    .campaignId(campaignId);
            return contributorRepository.insert(contributorInfo);
        }).orElseThrow(() -> new ResourceNotFoundException(CfErrorConfigEnum.CF_CAMPAIGN_NOT_FOUND));
    }

    @Override
    public ContributorInfo updateContributor(String campaignId, String contributorId, Contributor body) {
        return campaignRepository.findById(campaignId).map(campaignInfo -> contributorRepository
                .findById(contributorId).map(contributorInfo -> {
                    contributorInfo.setContributor(body);
                    return contributorRepository.save(contributorInfo);
                }).orElseThrow(() -> new ResourceNotFoundException(CfErrorConfigEnum.CF_CONTRIBUTOR_NOT_FOUND))).orElseThrow(() -> new ResourceNotFoundException(CfErrorConfigEnum.CF_CAMPAIGN_NOT_FOUND));
    }

    @Override
    public List<ContributorInfo> listContributors(String campaignId) {
        ExampleMatcher contributorMatcher = ExampleMatcher.matching().withMatcher("campaignId", exact());

        ContributorInfo contributorInfo = new ContributorInfo()
                .campaignId(campaignId);
        Example<ContributorInfo> contributorInfoExample = Example.of(contributorInfo, contributorMatcher);
        Sort sortCriteria = new Sort(Sort.Direction.ASC, "contributor.name");
        return contributorRepository.findAll(contributorInfoExample, sortCriteria);
    }

    @Override
    public void deleteContributor(String campaignId, String contributorId) {
        Optional<ContributorInfo> contributorInfoOptional = contributorRepository.findById(contributorId);
        if (contributorInfoOptional.isPresent()) {
            contributorRepository.deleteById(contributorId);
        } else {
            throw new ResourceNotFoundException(CfErrorConfigEnum.CF_CONTRIBUTOR_NOT_FOUND);
        }
    }

}
