package com.zuhlke.f10.crowdlending.loan.controller;

import com.zuhlke.f10.crowdlending.loan.service.InvestmentService;
import com.zuhlke.f10.crowdlending.loan.service.LoanService;
import com.zuhlke.f10.crowdlending.loan.service.RepaymentService;
import com.zuhlke.f10.crowdlending.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class LoanApiController implements LoanApi {

    @Autowired
    private LoanService loanService;

    @Autowired
    private InvestmentService investmentService;

    @Autowired
    private RepaymentService repaymentService;

    @RequestMapping(value = "/loans/{loan_id}/investments",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    @Override
    public ResponseEntity<InvestmentInfo> createInvestment(@PathVariable("loan_id") String loanId, @RequestBody Investment body) {
        InvestmentInfo investmentInfo = investmentService.createInvestment(loanId, body);
        return ResponseEntity.status(HttpStatus.CREATED).body(investmentInfo);
    }

    @RequestMapping(value = "/loans",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    @Override
    public ResponseEntity<LoanInfo> createLoan(@RequestBody Loan body) {
        return ResponseEntity.status(HttpStatus.CREATED).body(loanService.createLoan(body));
    }

    @RequestMapping(value = "/loans/{loan_id}/repayments",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    @Override
    public ResponseEntity<RepaymentInfo> createRepayment(@PathVariable("loan_id") String loanId, @RequestBody Repayment body) {
        RepaymentInfo repaymentInfo = repaymentService.createRepayment(loanId, body);
        return ResponseEntity.status(HttpStatus.CREATED).body(repaymentInfo);
    }

    @RequestMapping(value = "/loans/{loan_id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.DELETE)
    @Override
    public ResponseEntity<Void> deleteLoan(@PathVariable("loan_id") String loanId) {
        loanService.deleteLoan(loanId);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/loans/{loan_id}/investments",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.GET)
    @Override
    public ResponseEntity<List<InvestmentInfo>> getInvestments(@PathVariable("loan_id") String loanId, @RequestParam(value = "investor_id", required = false) String investorId, @RequestParam(value = "from_date", required = false) LocalDate fromDate, @RequestParam(value = "to_date", required = false) LocalDate toDate) {
        return ResponseEntity.ok().body(investmentService.getInvestments(loanId, investorId, fromDate, toDate));
    }

    @RequestMapping(value = "/loans/{loan_id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.GET)
    @Override
    public ResponseEntity<LoanInfo> getLoan(@PathVariable("loan_id") String loanId) {
        return ResponseEntity.ok().body(loanService.getLoan(loanId));
    }

    @RequestMapping(value = "/loans/{loan_id}/repayments",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.GET)
    @Override
    public ResponseEntity<List<RepaymentInfo>> getRepayments(@PathVariable("loan_id") String loanId, @RequestParam(value = "from_date", required = false) LocalDate fromDate, @RequestParam(value = "to_date", required = false) LocalDate toDate) {
        return ResponseEntity.ok().body(repaymentService.getRepayments(loanId, fromDate, toDate));
    }

    @RequestMapping(value = "/loans",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.GET)
    @Override
    public ResponseEntity<List<LoanInfo>> listLoans(@RequestParam(value = "loan_type", required = false) String loanType, @RequestParam(value = "from_date", required = false) LocalDate fromDate, @RequestParam(value = "to_date", required = false) LocalDate toDate) {
        return ResponseEntity.ok().body(loanService.listLoans(loanType, fromDate, toDate));
    }

    @RequestMapping(value = "/loans/{loan_id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    @Override
    public ResponseEntity<LoanInfo> updateLoan(@PathVariable("loan_id") String loanId, @RequestBody Loan body) {
        return ResponseEntity.ok().body(loanService.updateLoan(loanId, body));
    }
}
