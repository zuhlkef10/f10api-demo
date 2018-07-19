package com.zuhlke.f10.crowdlending.investor.service;

import com.zuhlke.f10.crowdlending.config.ClErrorConfigEnum;
import com.zuhlke.f10.crowdlending.exception.ResourceNotFoundException;
import com.zuhlke.f10.crowdlending.investor.repository.InvestorRepository;
import com.zuhlke.f10.crowdlending.model.Investor;
import com.zuhlke.f10.crowdlending.model.InvestorInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;

@Service
public class InvestorServiceImpl implements InvestorService {

    @Autowired
    private InvestorRepository investorRepository;

    @Override
    public InvestorInfo createInvestor(Investor body) {
        InvestorInfo investorInfo = new InvestorInfo().investor(body);
        return investorRepository.insert(investorInfo);
    }

    @Override
    public void deleteInvestor(String investorId) {
        Optional<InvestorInfo> investorInfoOptional = investorRepository.findById(investorId);
        if (investorInfoOptional.isPresent()) {
            investorRepository.deleteById(investorId);
        } else {
            throw new ResourceNotFoundException(ClErrorConfigEnum.CL_INVESTOR_NOT_FOUND);
        }
    }

    @Override
    public InvestorInfo getInvestor(String investorId) {
        return investorRepository.findById(investorId).orElseThrow(() -> new ResourceNotFoundException(ClErrorConfigEnum.CL_INVESTOR_NOT_FOUND));
    }

    @Override
    public List<InvestorInfo> listInvestors(String name, String email) {
        ExampleMatcher investorMatcher = ExampleMatcher.matching().withMatcher("investor.name", contains().ignoreCase())
                .withMatcher("investor.email", exact());

        Investor investor = new Investor()
                .name(name)
                .email(email);
        InvestorInfo investorInfo = new InvestorInfo().investor(investor);
        Example<InvestorInfo> investorInfoExample = Example.of(investorInfo, investorMatcher);
        return investorRepository.findAll(investorInfoExample);
    }

    @Override
    public InvestorInfo updateInvestor(String investorId, Investor body) {
        return investorRepository.findById(investorId).map(investorInfo -> {
            investorInfo.setInvestor(body);
            return investorRepository.save(investorInfo);
        }).orElseThrow(() -> new ResourceNotFoundException(ClErrorConfigEnum.CL_INVESTOR_NOT_FOUND));
    }
}
