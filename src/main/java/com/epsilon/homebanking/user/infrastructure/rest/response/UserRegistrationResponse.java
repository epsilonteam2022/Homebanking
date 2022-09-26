package com.epsilon.homebanking.user.infrastructure.rest.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserRegistrationResponse {

  private String firstName;
  private String lastName;
  private String email;
}
