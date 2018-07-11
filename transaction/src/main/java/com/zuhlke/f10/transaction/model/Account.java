package com.zuhlke.f10.transaction.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public class Account {

  private String id;
  private ArrayList<AccountHolder> holders;

  private String number;
  private String kind;

  @JsonProperty("IBAN")
  private String iban;

  @JsonProperty("swift_bic")
  private String swiftBic;

  private Bank bank;



}
