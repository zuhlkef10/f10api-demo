package com.zuhlke.f10.transaction.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public class TransactionMetadata {

  private String narrative;
  private ArrayList<TransactionComment> comments;
  private ArrayList<TransactionComment> tags;

  private ArrayList<TransactionImage> images;
  private Location where;

}
