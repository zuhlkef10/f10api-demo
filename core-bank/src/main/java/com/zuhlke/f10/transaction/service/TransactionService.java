package com.zuhlke.f10.transaction.service;

import com.zuhlke.f10.transaction.model.Transaction;
import com.zuhlke.f10.transaction.model.TransactionRequest;
import com.zuhlke.f10.transaction.model.TransactionResponse;

public interface TransactionService {

    Transaction getTransactionById(String bankId, String accountId,  String transactionId);

    TransactionResponse createTransactionRequest(String bankId, String accountId, TransactionRequest transactionRequest);
}
