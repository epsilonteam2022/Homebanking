package com.epsilon.homebanking.security.delegate;

import com.epsilon.homebanking.exception.ErrorMessage;
import com.epsilon.homebanking.exception.InvalidCredentialsException;
import com.epsilon.homebanking.user.infrastructure.database.entity.UserEntity;
import com.epsilon.homebanking.user.infrastructure.database.repository.abstraction.UserSpringRepository;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserDetailsDelegate implements UserDetailsService {

  private final UserSpringRepository userSpringRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<UserEntity> userEntity = userSpringRepository.findByEmail(username);
    if (userEntity.isEmpty()) {
      throw new InvalidCredentialsException(ErrorMessage.RECORD_NOT_FOUND.getMessage("User"));
    }
    return userEntity.get();
  }

}
