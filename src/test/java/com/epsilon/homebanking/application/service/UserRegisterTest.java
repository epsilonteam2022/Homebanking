package com.epsilon.homebanking.application.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import com.epsilon.homebanking.common.exception.UserAlreadyExistsException;
import com.epsilon.homebanking.role.domain.Role;
import com.epsilon.homebanking.role.domain.repository.RoleRepository;
import com.epsilon.homebanking.user.application.UserRegisterImpl;
import com.epsilon.homebanking.user.application.usecase.UserRegister;
import com.epsilon.homebanking.user.domain.User;
import com.epsilon.homebanking.user.domain.repository.UserRepository;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserRegisterTest {

  private static final String EMAIL = "ricky@fort.com";
  private static final String ROLE = "ROLE_USER";

  private UserRegister userRegister;

  @Mock
  private UserRepository userRepository;

  @Mock
  private RoleRepository roleRepository;

  @BeforeEach
  void setup() {
    userRegister = new UserRegisterImpl(userRepository, roleRepository);
  }

  @Test
  void shouldThrowExceptionWhenUserAlreadyExist() {
    User user = new User();
    user.setEmail(EMAIL);

    given(userRepository.findByEmail(EMAIL)).willReturn(Optional.of(user));

    assertThrows(UserAlreadyExistsException.class, () -> userRegister.register(user));
  }

  @Test
  void shouldSaveUserWhenUserDoesNotExist() {
    Role role = new Role();
    role.setRoleName(ROLE);

    given(userRepository.findByEmail(EMAIL)).willReturn(Optional.empty());
    given(roleRepository.findRole()).willReturn(role);

    User user = new User();
    user.setEmail(EMAIL);

    userRegister.register(user);

    verify(userRepository).findByEmail(EMAIL);
    verify(roleRepository).findRole();
    verify(userRepository).register(user);
  }
}
