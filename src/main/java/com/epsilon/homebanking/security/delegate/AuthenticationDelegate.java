package com.epsilon.homebanking.security.delegate;

import com.epsilon.homebanking.common.exception.ErrorMessage;
import com.epsilon.homebanking.common.exception.InvalidCredentialsException;
import com.epsilon.homebanking.user.application.delegate.AuthenticationManager;
import com.epsilon.homebanking.user.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AuthenticationDelegate implements AuthenticationManager {

  private final org.springframework.security.authentication.AuthenticationManager
      authenticationManager;

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
