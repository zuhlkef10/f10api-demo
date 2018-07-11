package com.zuhlke.f10.transaction.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Transaction {

    private String id;

    @JsonProperty("this_account")
    private Account account;

    @JsonProperty("other_account")
    private OtherAccount otherAccount;


    private TransactionDetails details;

    private TransactionMetadata metadata;

}
