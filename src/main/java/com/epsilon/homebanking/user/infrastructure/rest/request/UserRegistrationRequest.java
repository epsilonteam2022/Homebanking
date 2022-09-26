package com.epsilon.homebanking.user.infrastructure.rest.request;

import com.epsilon.homebanking.user.infrastructure.rest.request.validation.CharactersNumbersAndSymbols;
import com.epsilon.homebanking.user.infrastructure.rest.request.validation.CharactersWithWhiteSpaces;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class UserRegistrationRequest {

  @CharactersWithWhiteSpaces(message = "First name must contain only spaces and letters.")
  private String firstName;

  @CharactersWithWhiteSpaces(message = "Last name must contain only spaces and letters.")
  private String lastName;

  @Email(message = "Email should be valid.")
  private String email;

  @Size(min = 8, max = 16, message = "Password must be between 8 and 16 characters long.")
  @CharactersNumbersAndSymbols(message = "Password must have at leas 1 upper case character, "
      + "1 lower case character, 1 number and 1 special character (example: 1Password$)")
  private String password;

  private String imageUrl;
}
