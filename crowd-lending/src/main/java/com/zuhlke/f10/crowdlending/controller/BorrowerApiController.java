package com.zuhlke.f10.crowdlending.controller;

import com.zuhlke.f10.crowdlending.model.Borrower;
import com.zuhlke.f10.crowdlending.model.ListBorrowerResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class BorrowerApiController implements BorrowerApi {
    @RequestMapping(value = "/borrowers",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    @Override
    public ResponseEntity<Borrower> createBorrower(@Valid @RequestBody Borrower body) {
        return null;
    }

    @RequestMapping(value = "/borrowers/{borrower_id}",
            produces = {"application/json"},
            method = RequestMethod.DELETE)
    @Override
    public ResponseEntity<Void> deleteBorrower(@PathVariable("borrower_id") String borrowerId) {
        return null;
    }

    @RequestMapping(value = "/borrowers/{borrower_id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.GET)
    @Override
    public ResponseEntity<Borrower> getBorrower(@PathVariable("borrower_id") String borrowerId) {
        return null;
    }

    @RequestMapping(value = "/borrowers",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.GET)
    @Override
    public ResponseEntity<ListBorrowerResponse> listBorrowers() {
        return null;
    }

    @RequestMapping(value = "/borrowers/{borrower_id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    @Override
    public ResponseEntity<Borrower> updateBorrower(@PathVariable("borrower_id") String borrowerId, @Valid @RequestBody Borrower body) {
        return null;
    }
}
