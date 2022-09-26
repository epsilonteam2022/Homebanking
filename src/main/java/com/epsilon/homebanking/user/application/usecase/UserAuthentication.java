package com.epsilon.homebanking.user.application.usecase;

import com.epsilon.homebanking.user.domain.User;

public interface UserAuthentication {

  User auth(User user);
}
