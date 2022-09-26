package com.epsilon.homebanking.user.application;

import com.epsilon.homebanking.common.exception.ErrorMessage;
import com.epsilon.homebanking.common.exception.RecordNotFoundException;
import com.epsilon.homebanking.user.application.delegate.AuthenticationManager;
import com.epsilon.homebanking.user.application.usecase.UserAuthentication;
import com.epsilon.homebanking.user.domain.User;
import com.epsilon.homebanking.user.domain.repository.UserRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAuthenticationImpl implements UserAuthentication {

  private final UserRepository userRepository;
  private final AuthenticationManager authenticationManager;

  @Override
  public User auth(User user) {
    authenticationManager.authenticate(user);
    return findByEmail(user.getEmail());
  }

  private User findByEmail(String email) {
    Optional<User> user = userRepository.findByEmail(email);
    if (user.isEmpty()) {
      throw new RecordNotFoundException(ErrorMessage.RECORD_NOT_FOUND.getMessage("User"));
    }
    return user.get();
  }
}