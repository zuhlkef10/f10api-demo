package com.zuhlke.f10.account.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Owner {

   private String id;
   private String provider;

   @JsonProperty("display_name")
   private String displayName;
}
