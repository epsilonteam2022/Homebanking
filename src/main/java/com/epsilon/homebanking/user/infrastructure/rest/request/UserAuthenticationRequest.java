package com.epsilon.homebanking.user.infrastructure.rest.request;

import com.epsilon.homebanking.user.infrastructure.rest.request.validation.CharactersNumbersAndSymbols;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserAuthenticationRequest {

  @Email(message = "Email has invalid format.")
  private String email;

  @Size(message = "Password must be between 8 and 16 characters long.", min = 8, max = 16)
  @CharactersNumbersAndSymbols(message = "Password must have at leas 1 upper case character, "
      + "1 lower case character, 1 number and 1 special character (example: 1Password$)")
  private String password;
}
