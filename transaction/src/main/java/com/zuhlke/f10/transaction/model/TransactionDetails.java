package com.zuhlke.f10.transaction.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TransactionDetails {

   private String type;
   private String description;
   private String posted;
   private String completed;

   @JsonProperty("new_balance")
   private Balance newBalance;

   private Balance value;



}
