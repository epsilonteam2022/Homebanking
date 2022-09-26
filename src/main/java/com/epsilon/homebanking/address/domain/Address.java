package com.epsilon.homebanking.address.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Address {

  private Long addressId;
  private Integer zipCode;
  private String street;
  private String city;
}
