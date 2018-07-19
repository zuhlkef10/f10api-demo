package com.zuhlke.f10.crowdlending.loan.service;

import com.zuhlke.f10.crowdlending.config.ClErrorConfigEnum;
import com.zuhlke.f10.crowdlending.exception.ResourceNotFoundException;
import com.zuhlke.f10.crowdlending.loan.repository.LoanRepository;
import com.zuhlke.f10.crowdlending.model.Loan;
import com.zuhlke.f10.crowdlending.model.LoanInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Override
    public LoanInfo createLoan(Loan body) {
        LoanInfo loanInfo = new LoanInfo().loan(body);
        return loanRepository.insert(loanInfo);
    }

    @Override
    public void deleteLoan(String loanId) {
        Optional<LoanInfo> loanInfoOptional = loanRepository.findById(loanId);
        if (loanInfoOptional.isPresent()) {
            loanRepository.deleteById(loanId);
        } else {
            throw new ResourceNotFoundException(ClErrorConfigEnum.CL_LOAN_NOT_FOUND);
        }

    }

    @Override
    public LoanInfo getLoan(String loanId) {
        return loanRepository.findById(loanId).orElseThrow(() -> new ResourceNotFoundException(ClErrorConfigEnum.CL_LOAN_NOT_FOUND));
    }

    @Override
    public List<LoanInfo> listLoans(String loanType, LocalDate fromDate, LocalDate toDate) {
        ExampleMatcher loanMatcher = ExampleMatcher.matching().withMatcher("loan.loanType", contains().ignoreCase());

        Loan loan = new Loan()
                .loanType(loanType == null ? null : Loan.LoanTypeEnum.valueOf(loanType));

        LoanInfo loanInfo = new LoanInfo().loan(loan);
        Example<LoanInfo> loanInfoExample = Example.of(loanInfo, loanMatcher);
        return loanRepository.findAll(loanInfoExample);
    }

    @Override
    public LoanInfo updateLoan(String loanId, Loan body) {
        return loanRepository.findById(loanId).map(loanInfo -> {
            loanInfo.setLoan(body);
            return loanRepository.save(loanInfo);
        }).orElseThrow(() -> new ResourceNotFoundException(ClErrorConfigEnum.CL_LOAN_NOT_FOUND));
    }
}
