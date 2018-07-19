package com.zuhlke.f10.robotadvisor.portfolio.service;

import com.zuhlke.f10.robotadvisor.config.RaErrorConfigEnum;
import com.zuhlke.f10.robotadvisor.exception.ResourceNotFoundException;
import com.zuhlke.f10.robotadvisor.model.Portfolio;
import com.zuhlke.f10.robotadvisor.model.PortfolioInfo;
import com.zuhlke.f10.robotadvisor.portfolio.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;

@Service
public class PortfolioServiceImpl implements PortfolioService {

    @Autowired
    private PortfolioRepository portfolioRepository;

    @Override
    public PortfolioInfo createPortfolio(String customerId, Portfolio body) {
        PortfolioInfo portfolioInfo = new PortfolioInfo().portfolio(body).customerId(customerId);
        return portfolioRepository.insert(portfolioInfo);
    }

    @Override
    public void deletePortfolio(String customerId, String portfolioId) {
        Optional<PortfolioInfo> portfolioInfoOptional = portfolioRepository.findById(portfolioId);
        if (portfolioInfoOptional.isPresent()) {
            portfolioRepository.deleteById(portfolioId);
        } else {
            throw new ResourceNotFoundException(RaErrorConfigEnum.RA_PORTFOLIO_NOT_FOUND);
        }
    }

    @Override
    public PortfolioInfo getPortfolio(String customerId, String portfolioId) {
        return portfolioRepository.findById(portfolioId).orElseThrow(() -> new ResourceNotFoundException(RaErrorConfigEnum.RA_PORTFOLIO_NOT_FOUND));
    }

    @Override
    public List<PortfolioInfo> listPortfolios(String customerId, String status) {
        ExampleMatcher portfolioMatcher = ExampleMatcher.matching().withMatcher("customerId", exact())
                .withMatcher("portfolio.status", exact());

        Portfolio portfolio = new Portfolio()
                .status(status);
        PortfolioInfo portfolioInfo = new PortfolioInfo().portfolio(portfolio).customerId(customerId);
        Example<PortfolioInfo> investorInfoExample = Example.of(portfolioInfo, portfolioMatcher);
        return portfolioRepository.findAll(investorInfoExample);
    }

    @Override
    public PortfolioInfo updatePortfolio(String customerId, String portfolioId, Portfolio body) {
        return portfolioRepository.findById(portfolioId).map(portfolioInfo -> {
            portfolioInfo.setPortfolio(body);
            return portfolioRepository.save(portfolioInfo);
        }).orElseThrow(() -> new ResourceNotFoundException(RaErrorConfigEnum.RA_PORTFOLIO_NOT_FOUND));
    }
}
