package com.zuhlke.f10.robotadvisor.portfolio.repository;

import com.zuhlke.f10.robotadvisor.model.PortfolioInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PortfolioRepository extends MongoRepository<PortfolioInfo, String> {
}
