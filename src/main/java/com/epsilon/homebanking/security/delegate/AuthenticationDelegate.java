package com.epsilon.homebanking.security.delegate;

import com.epsilon.homebanking.exception.ErrorMessage;
import com.epsilon.homebanking.exception.InvalidCredentialsException;
import com.epsilon.homebanking.user.domain.IAuthenticationManager;
import com.epsilon.homebanking.user.domain.User;
import com.epsilon.homebanking.user.infrastructure.rest.response.UserErrorResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AuthenticationDelegate implements IAuthenticationManager {

  private final AuthenticationManager authenticationManager;

  @Override
  public void authenticate(User user) {
    try {
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
          user.getEmail(),
          user.getPassword()));
    } catch (Exception e) {
      throw new InvalidCredentialsException(ErrorMessage.INVALID_CREDENTIALS.getMessage());
    }
  }

}
