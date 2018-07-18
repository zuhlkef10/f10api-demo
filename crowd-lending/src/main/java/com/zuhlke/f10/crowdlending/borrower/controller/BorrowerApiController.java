package com.zuhlke.f10.crowdlending.borrower.controller;

import com.zuhlke.f10.crowdlending.borrower.service.BorrowerService;
import com.zuhlke.f10.crowdlending.model.Borrower;
import com.zuhlke.f10.crowdlending.model.BorrowerInfo;
import com.zuhlke.f10.crowdlending.model.CreateBorrowerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BorrowerApiController implements BorrowerApi {

    @Autowired
    private BorrowerService borrowerService;

    @RequestMapping(value = "/borrowers",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    @Override
    public ResponseEntity<CreateBorrowerResponse> createBorrower(@RequestBody Borrower body) {
        String borrowerId = borrowerService.createBorrower(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CreateBorrowerResponse().borrowerId(borrowerId));
    }


    @RequestMapping(value = "/borrowers/{borrower_id}",
            produces = {"application/json"},
            method = RequestMethod.DELETE)
    @Override
    public ResponseEntity<Void> deleteBorrower(@PathVariable("borrower_id") String borrowerId) {
        borrowerService.deleteBorrower(borrowerId);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/borrowers/{borrower_id}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    @Override
    public ResponseEntity<BorrowerInfo> getBorrower(@PathVariable("borrower_id") String borrowerId) {
        return ResponseEntity.ok().body(borrowerService.getBorrower(borrowerId));
    }

    @RequestMapping(value = "/borrowers",
            produces = {"application/json"},
            method = RequestMethod.GET)
    @Override
    public ResponseEntity<List<BorrowerInfo>> listBorrowers(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "email", required = false) String email) {
        return ResponseEntity.ok().body(borrowerService.listBorrowers(name, email));
    }

    @RequestMapping(value = "/borrowers/{borrower_id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    @Override
    public ResponseEntity<BorrowerInfo> updateBorrower(@PathVariable("borrower_id") String borrowerId, @RequestBody Borrower body) {
        return ResponseEntity.ok().body(borrowerService.updateBorrower(borrowerId, body));
    }
}
