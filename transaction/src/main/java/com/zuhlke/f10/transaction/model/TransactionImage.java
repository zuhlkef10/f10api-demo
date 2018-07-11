package com.zuhlke.f10.transaction.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TransactionImage {

  private String id;
  private String label;

  @JsonProperty("URL")
  private String url;

  private String date;
  private User user;

}
