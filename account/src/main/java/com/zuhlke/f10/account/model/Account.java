package com.zuhlke.f10.account.model;

public class Account {

    private String accountNumber;

    private String accountType;

    private String bankId;

    public Account(String accountNumber, String accountType, String bankId) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.bankId = bankId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }
}
