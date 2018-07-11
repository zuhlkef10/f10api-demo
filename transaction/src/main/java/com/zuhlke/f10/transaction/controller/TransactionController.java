package com.zuhlke.f10.transaction.controller;

import com.zuhlke.f10.transaction.model.Transaction;
import com.zuhlke.f10.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/banks")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @RequestMapping(value="/{bankId}/accounts/{accountId}/{viewId}/transactions/{transactionId}/transaction", method = RequestMethod.GET)
    public Transaction getTransactionById(@PathVariable("bankId") String bankId
                                          ,@PathVariable("accountId") String accountId
                                          ,@PathVariable("viewId") String viewId
                                          ,@PathVariable("transactionId") String transactionId){

        return transactionService.getTransactionById(bankId, accountId, viewId, transactionId);

    }

}
