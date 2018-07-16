package com.zuhlke.f10.crowdlending.controller;

import com.zuhlke.f10.crowdlending.model.ListLoanResponse;
import com.zuhlke.f10.crowdlending.model.Loan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class LoanApiController implements LoanApi {
    @RequestMapping(value = "/loans",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    @Override
    public ResponseEntity<Loan> createLoan(@Valid @RequestBody Loan body) {
        return null;
    }

    @RequestMapping(value = "/loans/{loan_id}",
            produces = {"application/json"},
            method = RequestMethod.DELETE)
    @Override
    public ResponseEntity<Void> deleteLoan(@PathVariable("loan_id") String loanId) {
        return null;
    }

    @RequestMapping(value = "/loans/{loan_id}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    @Override
    public ResponseEntity<Loan> getLoan(@PathVariable("loan_id") String loanId) {
        return null;
    }

    @RequestMapping(value = "/loans",
            produces = {"application/json"},
            method = RequestMethod.GET)
    @Override
    public ResponseEntity<ListLoanResponse> listLoans() {
        return null;
    }

    @RequestMapping(value = "/loans/{loan_id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    @Override
    public ResponseEntity<Loan> updateLoan(@PathVariable("loan_id") String loanId, @Valid @RequestBody Loan body) {
        return null;
    }
}
