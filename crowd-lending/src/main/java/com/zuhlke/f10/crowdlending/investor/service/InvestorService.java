package com.zuhlke.f10.crowdlending.investor.service;

import com.zuhlke.f10.crowdlending.model.Investor;
import com.zuhlke.f10.crowdlending.model.InvestorInfo;

import java.util.List;

public interface InvestorService {

    InvestorInfo createInvestor(Investor body);

    void deleteInvestor(String investorId);

    InvestorInfo getInvestor(String investorId);

    List<InvestorInfo> listInvestors(String name, String email);

    InvestorInfo updateInvestor(String investorId, Investor body);


}
