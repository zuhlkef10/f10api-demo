package com.zuhlke.f10.crowdlending.loan.service;

import com.zuhlke.f10.crowdlending.model.Loan;
import com.zuhlke.f10.crowdlending.model.LoanInfo;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;

public interface LoanService {

    LoanInfo createLoan(@RequestBody Loan body);

    void deleteLoan(String loanId);

    LoanInfo getLoan(String loanId);

    List<LoanInfo> listLoans(String loanType, LocalDate fromDate, LocalDate toDate);

    LoanInfo updateLoan(String loanId, Loan body);

}
