package com.epsilon.homebanking.user.infrastructure.rest.mapper;

import com.epsilon.homebanking.common.mapper.RestBaseMapper;
import com.epsilon.homebanking.user.domain.User;
import com.epsilon.homebanking.user.infrastructure.rest.request.UserAuthenticationRequest;
import com.epsilon.homebanking.user.infrastructure.rest.response.UserAuthenticationResponse;
import org.springframework.stereotype.Component;

@Component
public class UserAuthenticationMapper extends
    RestBaseMapper<UserAuthenticationRequest, User, UserAuthenticationResponse> {

  @Override
  public User toDomain(UserAuthenticationRequest request, Object... args) {
    if (request == null) {
      return null;
    }
    return User.builder()
        .email(request.getEmail())
        .password(request.getPassword())
        .build();
  }

  @Override
  public UserAuthenticationResponse toResponse(User domain, Object... args) {
    if (domain == null) {
      return null;
    }
    return UserAuthenticationResponse.builder()
        .firstName(domain.getFirstName())
        .lastName(domain.getLastName())
        .email(domain.getEmail())
        .imageUrl(domain.getImageUrl())
        .token(domain.getToken())
        .build();
  }
}
