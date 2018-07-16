package com.zuhlke.f10.account.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;


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

    private Money balance;

    @JsonProperty("account_routings")
    private ArrayList<AccountRouting> accountRoutings;

    @JsonProperty("account_rules")
    private ArrayList<AccountRule> accountRules;


    @Data
    @NoArgsConstructor
    static public class AccountRouting {

        private String scheme;
        private String address;

    }

    @Data
    @NoArgsConstructor
    static public class Owner {

        private String id;
        private String provider;

        @JsonProperty("display_name")
        private String displayName;
    }

    @Data
    @NoArgsConstructor
    static public class AccountRule {

        private String scheme;
        private double value;
    }

    @Data
    @NoArgsConstructor
    static public class Money {

        private String currency;
        private double amount;
    }

}




