package com.zuhlke.f10.account.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@Data
public class Account {

    private String id;

    @JsonProperty("bank_id")
    private String bankId;

    private String label;

    private String number;

    private ArrayList<Owner> owners;

    private String type;

    private Balance balance;

    @JsonProperty("account_routings")
    private ArrayList<AccountRouting> accountRoutings;

    @JsonProperty("account_rules")
    private ArrayList<AccountRule> accountRules;
 }
