package com.zuhlke.f10.account.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public class AccountCr {

    private String id;

    @JsonProperty("bank_id")
    private String bankId;

    private String label;

    private String number;

    private Owner owner;

    private String type;

    private Balance balance;

    @JsonProperty("account_routing")
    private AccountRouting accountRouting;

    @JsonProperty("account_rule")
    private AccountRule accountRule;
 }
