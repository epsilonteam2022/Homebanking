package com.epsilon.homebanking.user.application.delegate;

import com.epsilon.homebanking.user.domain.User;

public interface AuthenticationManager {

  void authenticate(User user);

}