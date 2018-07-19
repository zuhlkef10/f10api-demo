package com.zuhlke.f10.crowdlending.borrower.service;

import com.zuhlke.f10.crowdlending.model.Borrower;
import com.zuhlke.f10.crowdlending.model.BorrowerInfo;

import java.util.List;

public interface BorrowerService {

    BorrowerInfo createBorrower(Borrower body);

    void deleteBorrower(String borrowerId);

    BorrowerInfo getBorrower(String borrowerId);

    List<BorrowerInfo> listBorrowers(String name, String email);

    BorrowerInfo updateBorrower(String borrowerId, Borrower body);

}
