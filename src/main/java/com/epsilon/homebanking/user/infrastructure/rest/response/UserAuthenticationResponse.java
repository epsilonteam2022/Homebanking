package com.epsilon.homebanking.user.infrastructure.rest.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserAuthenticationResponse {

  private String firstName;
  private String lastName;
  private String email;
  private String imageUrl;
  private String token;
}
