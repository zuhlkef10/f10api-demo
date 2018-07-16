package com.zuhlke.f10.crowdfunding.contributor.service;

import com.zuhlke.f10.crowdfunding.contributor.repository.ContributorRepository;
import com.zuhlke.f10.crowdfunding.model.Contributor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContributorServiceImpl implements ContributorService {

    @Autowired
    private ContributorRepository contributorRepository;

    @Override
    public Contributor getContributor(String campaignId, String contributorId) {
        return contributorRepository.findById(contributorId).orElse(null);
    }

    @Override
    public Contributor registerContributor(String campaignId, Contributor body) {
        return contributorRepository.save(body);
    }

    @Override
    public Contributor updateContributor(String campaignId, String contributorId, Contributor body) {
        return contributorRepository.save(body);
    }

    @Override
    public List<Contributor> listContributors(String campaignId) {
        return contributorRepository.findAll();
    }

    @Override
    public void deleteContributor(String campaignId, String contributorId) {
        contributorRepository.deleteById(contributorId);
    }
}
