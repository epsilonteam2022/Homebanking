package com.epsilon.homebanking.user.infrastructure.rest.resource;

import com.epsilon.homebanking.user.application.usecase.UserAuthentication;
import com.epsilon.homebanking.user.application.usecase.UserRegister;
import com.epsilon.homebanking.user.domain.User;
import com.epsilon.homebanking.user.infrastructure.rest.mapper.UserAuthenticationMapper;
import com.epsilon.homebanking.user.infrastructure.rest.mapper.UserRegisterMapper;
import com.epsilon.homebanking.user.infrastructure.rest.request.UserAuthenticationRequest;
import com.epsilon.homebanking.user.infrastructure.rest.request.UserRegistrationRequest;
import com.epsilon.homebanking.user.infrastructure.rest.response.UserAuthenticationResponse;
import com.epsilon.homebanking.user.infrastructure.rest.response.UserRegistrationResponse;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserAuthResource {

  private final UserRegister userRegister;
  private final UserAuthentication userAuthentication;
  private final UserRegisterMapper userAuthMapper;
  private final UserAuthenticationMapper userAuthenticationMapper;

  @PostMapping(
      value = "/register",
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<UserRegistrationResponse> register(
      @Valid @RequestBody UserRegistrationRequest authRequest) {
    User user = userRegister.register(userAuthMapper.toDomain(authRequest));
    UserRegistrationResponse response = userAuthMapper.toResponse(user);
    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }

  @PostMapping(
      value = "/login",
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<UserAuthenticationResponse> login(
      @Valid @RequestBody UserAuthenticationRequest authenticationRequest) {
    User user = userAuthentication.auth(userAuthenticationMapper.toDomain(authenticationRequest));
    return ResponseEntity.ok().body(userAuthenticationMapper.toResponse(user));
  }

}
