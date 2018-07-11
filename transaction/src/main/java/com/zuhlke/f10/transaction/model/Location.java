package com.zuhlke.f10.transaction.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Location {

    private double latitude;
    private double longitude;

    private String date;
    private User user;


}
