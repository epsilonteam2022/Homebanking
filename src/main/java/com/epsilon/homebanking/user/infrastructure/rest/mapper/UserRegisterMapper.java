package com.epsilon.homebanking.user.infrastructure.rest.mapper;

import com.epsilon.homebanking.common.mapper.RestBaseMapper;
import com.epsilon.homebanking.user.domain.User;
import com.epsilon.homebanking.user.infrastructure.rest.request.UserRegistrationRequest;
import com.epsilon.homebanking.user.infrastructure.rest.response.UserRegistrationResponse;
import org.springframework.stereotype.Component;

@Component
public class UserRegisterMapper extends
    RestBaseMapper<UserRegistrationRequest, User, UserRegistrationResponse> {

  @Override
  public User toDomain(UserRegistrationRequest request, Object... args) {
    if (request == null) {
      return null;
    }
    return User.builder()
        .firstName(request.getFirstName())
        .lastName(request.getLastName())
        .email(request.getEmail())
        .password(request.getPassword())
        .build();
  }

  @Override
  public UserRegistrationResponse toResponse(User domain, Object... args) {
    if (domain == null) {
      return null;
    }
    return UserRegistrationResponse.builder()
        .firstName(domain.getFirstName())
        .lastName(domain.getLastName())
        .email(domain.getEmail())
        .build();
  }
}
