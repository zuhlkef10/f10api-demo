package com.zuhlke.f10.bank.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
public class Bank {

    @JsonProperty("id")
    private String id;

    @JsonProperty("full_name")
    private String fullName;

    @JsonProperty("short_name")
    private String shortName;

    @JsonProperty("logo_url")
    private String logoUrl;

    @JsonProperty("website_url")
    private String websiteUrl;

    @JsonProperty("swift_bic")
    private String swiftBic;

    @JsonProperty("national_identifier")
    private String nationalIdentifier;

    @JsonProperty("bank_routing")
    private BankRouting bankRouting;

}
