package com.zuhlke.f10.crowdlending.loan.service;

import com.zuhlke.f10.crowdlending.model.Repayment;
import com.zuhlke.f10.crowdlending.model.RepaymentInfo;

import java.time.LocalDate;
import java.util.List;

public interface RepaymentService {
    RepaymentInfo createRepayment(String loanId, Repayment body);

    List<RepaymentInfo> getRepayments(String loanId, LocalDate fromDate, LocalDate toDate);


}
