package com.zuhlke.f10.crowdlending.loan.service;

import com.zuhlke.f10.crowdlending.config.ClErrorConfigEnum;
import com.zuhlke.f10.crowdlending.exception.ResourceNotFoundException;
import com.zuhlke.f10.crowdlending.loan.repository.LoanRepository;
import com.zuhlke.f10.crowdlending.loan.repository.RepaymentRepository;
import com.zuhlke.f10.crowdlending.model.Repayment;
import com.zuhlke.f10.crowdlending.model.RepaymentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;

@Service
public class RepaymentServiceImpl implements RepaymentService {

    @Autowired
    private RepaymentRepository repaymentRepository;

    @Autowired
    private LoanRepository loanRepository;


    @Override
    public RepaymentInfo createRepayment(String loanId, Repayment body) {
        RepaymentInfo repaymentInfo = new RepaymentInfo().repayment(body).loanId(loanId);
        repaymentInfo = repaymentRepository.insert(repaymentInfo);

        loanRepository.findById(loanId).map(loanInfo -> {
            BigDecimal repaidAmount = loanInfo.getLoan().getRepaidAmount();
            repaidAmount = repaidAmount == null ? BigDecimal.ZERO : repaidAmount;
            repaidAmount = repaidAmount.add(body.getAmount());
            loanInfo.getLoan().setRepaidAmount(repaidAmount);
            return loanRepository.save(loanInfo);
        }).orElseThrow(() -> new ResourceNotFoundException(ClErrorConfigEnum.CL_LOAN_NOT_FOUND));

        return repaymentInfo;
    }

    @Override
    public List<RepaymentInfo> getRepayments(String loanId, LocalDate fromDate, LocalDate toDate) {
        ExampleMatcher investmentMatcher = ExampleMatcher.matching().withMatcher("loanId", exact());

        Repayment repayment = new Repayment();
        RepaymentInfo repaymentInfo = new RepaymentInfo().repayment(repayment).loanId(loanId);
        Example<RepaymentInfo> repaymentInfoExample = Example.of(repaymentInfo, investmentMatcher);
        return repaymentRepository.findAll(repaymentInfoExample);
    }
}
