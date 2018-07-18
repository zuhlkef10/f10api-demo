package com.zuhlke.f10.crowdlending.loan.service;

import com.zuhlke.f10.crowdlending.config.ClErrorConfigEnum;
import com.zuhlke.f10.crowdlending.exception.BadRequestException;
import com.zuhlke.f10.crowdlending.exception.ResourceNotFoundException;
import com.zuhlke.f10.crowdlending.investor.repository.InvestorRepository;
import com.zuhlke.f10.crowdlending.loan.repository.InvestmentRepository;
import com.zuhlke.f10.crowdlending.loan.repository.LoanRepository;
import com.zuhlke.f10.crowdlending.model.Investment;
import com.zuhlke.f10.crowdlending.model.InvestmentInfo;
import com.zuhlke.f10.crowdlending.model.InvestmentLoan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;

@Service
public class InvestmentServiceImpl implements InvestmentService {

    @Autowired
    private InvestmentRepository investmentRepository;

    @Autowired
    private InvestorRepository investorRepository;

    @Autowired
    private LoanRepository loanRepository;

    @Override
    public InvestmentInfo createInvestment(String loanId, Investment body) {
        InvestmentInfo investmentInfo = new InvestmentInfo().investment(body).loanId(loanId);
        investmentInfo = investmentRepository.insert(investmentInfo);

        final InvestmentLoan investmentLoan = new InvestmentLoan()
                .investmentId(investmentInfo.getId())
                .loanId(loanId)
                .amount(body.getAmount())
                .currency(body.getCurrency())
                .paymentDate(body.getPaymentDate())
                .paymentTransactionId(body.getPaymentTransactionId());

        String investorId = body.getInvestorId();
        investorRepository.findById(investorId).map(investorInfo -> {
            investorInfo.addInvestmentsItem(investmentLoan);
            return investorRepository.save(investorInfo);
        }).orElseThrow(() -> new BadRequestException(ClErrorConfigEnum.CL_INVESTOR_NOT_FOUND));

        loanRepository.findById(loanId).map(loanInfo -> {
            BigDecimal amount = loanInfo.getLoan().getAmount();
            amount = amount == null ? BigDecimal.ZERO : amount;
            amount = amount.add(body.getAmount());
            loanInfo.getLoan().setAmount(amount);
            loanInfo.addInvestorsItem(body.getInvestorId());
            return loanRepository.save(loanInfo);
        }).orElseThrow(() -> new ResourceNotFoundException(ClErrorConfigEnum.CL_LOAN_NOT_FOUND));

        return investmentInfo;
    }

    @Override
    public List<InvestmentInfo> getInvestments(String loanId, String investorId, LocalDate fromDate, LocalDate toDate) {
        ExampleMatcher investmentMatcher = ExampleMatcher.matching().withMatcher("investment.investorId", exact())
                .withMatcher("investment.loanId", exact());

        Investment investment = new Investment()
                .investorId(investorId);

        InvestmentInfo investmentInfo = new InvestmentInfo().investment(investment).loanId(loanId);
        Example<InvestmentInfo> investmentInfoExample = Example.of(investmentInfo, investmentMatcher);
        return investmentRepository.findAll(investmentInfoExample);
    }
}
