package com.zuhlke.f10.crowdlending.loan.service;

import com.zuhlke.f10.crowdlending.model.Investment;
import com.zuhlke.f10.crowdlending.model.InvestmentInfo;

import java.time.LocalDate;
import java.util.List;

public interface InvestmentService {

    InvestmentInfo createInvestment(String loanId, Investment body);

    List<InvestmentInfo> getInvestments(String loanId, String investorId, LocalDate fromDate, LocalDate toDate);


}
