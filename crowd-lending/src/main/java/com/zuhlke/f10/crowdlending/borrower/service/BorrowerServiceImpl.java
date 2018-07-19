package com.zuhlke.f10.crowdlending.borrower.service;

import com.zuhlke.f10.crowdlending.borrower.repository.BorrowerRepository;
import com.zuhlke.f10.crowdlending.config.ClErrorConfigEnum;
import com.zuhlke.f10.crowdlending.exception.ResourceNotFoundException;
import com.zuhlke.f10.crowdlending.model.Borrower;
import com.zuhlke.f10.crowdlending.model.BorrowerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;

@Service
public class BorrowerServiceImpl implements BorrowerService {

    @Autowired
    private BorrowerRepository borrowerRepository;

    @Override
    public BorrowerInfo createBorrower(Borrower body) {
        BorrowerInfo borrowerInfo = new BorrowerInfo().borrower(body);
        return borrowerRepository.insert(borrowerInfo);
    }

    @Override
    public void deleteBorrower(String borrowerId) {
        Optional<BorrowerInfo> borrowerInfoOptional = borrowerRepository.findById(borrowerId);
        if (borrowerInfoOptional.isPresent()) {
            borrowerRepository.deleteById(borrowerId);
        } else {
            throw new ResourceNotFoundException(ClErrorConfigEnum.CL_BORROWER_NOT_FOUND);
        }
    }

    @Override
    public BorrowerInfo getBorrower(String borrowerId) {
        return borrowerRepository.findById(borrowerId).orElseThrow(() -> new ResourceNotFoundException(ClErrorConfigEnum.CL_BORROWER_NOT_FOUND));
    }

    @Override
    public List<BorrowerInfo> listBorrowers(String name, String email) {
        ExampleMatcher borrowerMatcher = ExampleMatcher.matching().withMatcher("borrower.name", contains().ignoreCase())
                .withMatcher("borrower.email", exact());

        Borrower borrower = new Borrower()
                .name(name)
                .email(email);
        BorrowerInfo borrowerInfo = new BorrowerInfo().borrower(borrower);
        Example<BorrowerInfo> borrowerInfoExample = Example.of(borrowerInfo, borrowerMatcher);
        return borrowerRepository.findAll(borrowerInfoExample);
    }

    @Override
    public BorrowerInfo updateBorrower(String borrowerId, Borrower body) {
        return borrowerRepository.findById(borrowerId).map(borrowerInfo -> {
            borrowerInfo.setBorrower(body);
            return borrowerRepository.save(borrowerInfo);
        }).orElseThrow(() -> new ResourceNotFoundException(ClErrorConfigEnum.CL_BORROWER_NOT_FOUND));
    }
}
