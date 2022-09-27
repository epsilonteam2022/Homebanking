package com.epsilon.homebanking.user.infrastructure.rest.resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserResource {

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public String getFakeUser() {
    return "Hola, soy un user";
  }
}
