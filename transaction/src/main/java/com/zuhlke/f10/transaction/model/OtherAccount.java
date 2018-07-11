package com.zuhlke.f10.transaction.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class OtherAccount {

    private String id;
    private AccountHolder holder;

    private String number;
    private String kind;

    @JsonProperty("IBAN")
    private String iban;

    @JsonProperty("swift_bic")
    private String swiftBic;

    private Bank bank;

    private AccountMetadata metadata;

}
