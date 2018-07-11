package com.zuhlke.f10.transaction.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TransactionComment {

    private String id;
    private String value;
    private String date;
    private User user;

}
