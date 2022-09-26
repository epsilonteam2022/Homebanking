package com.epsilon.homebanking.user.application;

import com.epsilon.homebanking.common.exception.ErrorMessage;
import com.epsilon.homebanking.common.exception.UserAlreadyExistsException;
import com.epsilon.homebanking.role.domain.repository.RoleRepository;
import com.epsilon.homebanking.user.application.usecase.UserRegister;
import com.epsilon.homebanking.user.domain.User;
import com.epsilon.homebanking.user.domain.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserRegisterImpl implements UserRegister {

  private final UserRepository userRepository;
  private final RoleRepository roleRepository;


  @Override
  public User register(User user) {
    if (userRepository.findByEmail(user.getEmail()).isPresent()) {
      throw new UserAlreadyExistsException(ErrorMessage.USER_ALREADY_EXISTS.getMessage());
    }
    user.setRole(roleRepository.findRole());
    return userRepository.register(user);
  }
}
