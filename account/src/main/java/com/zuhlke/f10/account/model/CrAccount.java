package com.zuhlke.f10.account.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CrAccount {

    @JsonProperty("user_id")
    private String userId;

    private String label;

    private String type;
    private Balance balance;

    @JsonProperty("branch_id")
    private String branchId;

    @JsonProperty("account_routing")
    private AccountRouting accountRouting;
}
