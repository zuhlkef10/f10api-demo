package com.zuhlke.f10.customer.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreditLimit {

   private String currency;
   private double amount;

}
