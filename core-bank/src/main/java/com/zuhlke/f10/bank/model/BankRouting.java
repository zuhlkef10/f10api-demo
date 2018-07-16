package com.zuhlke.f10.bank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
public class BankRouting {

    @JsonProperty("scheme")
    private String scheme;

    @JsonProperty("address")
    private String address;

}
