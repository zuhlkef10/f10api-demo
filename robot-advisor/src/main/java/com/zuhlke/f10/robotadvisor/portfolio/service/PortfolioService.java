package com.zuhlke.f10.robotadvisor.portfolio.service;

import com.zuhlke.f10.robotadvisor.model.Portfolio;
import com.zuhlke.f10.robotadvisor.model.PortfolioInfo;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PortfolioService {

    PortfolioInfo createPortfolio(String customerId, @RequestBody Portfolio body);

    void deletePortfolio(String customerId, String portfolioId);

    PortfolioInfo getPortfolio(String customerId, String portfolioId);

    List<PortfolioInfo> listPortfolios(String customerId, String status);

    PortfolioInfo updatePortfolio(String customerId, String portfolioId, Portfolio body);


}
