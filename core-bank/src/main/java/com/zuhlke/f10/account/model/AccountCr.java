package com.zuhlke.f10.account.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountCr {

    private String id;

    @JsonProperty("bank_id")
    private String bankId;

    private String label;

    private String number;

    private Account.Owner owner;

    private String type;

    private  Account.Money balance;

    @JsonProperty("account_routing")
    private  Account.AccountRouting accountRouting;

    @JsonProperty("account_rule")
    private  Account.AccountRule accountRule;
 }
