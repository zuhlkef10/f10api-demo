package com.zuhlke.f10.transaction.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TransactionRequest {

    private Account to;
    private Transaction.Money value;
    private String description;


    @Data
    @NoArgsConstructor
    public static class Account{

         @JsonProperty("bank_id")
         private String bankId;

        @JsonProperty("account_id")
         private String accountId;
    }


}
