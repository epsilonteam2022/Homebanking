package com.epsilon.homebanking.user.domain.repository;

import com.epsilon.homebanking.user.domain.User;
import java.util.Optional;

public interface UserRepository {

  Optional<User> findByEmail(String email);

  User register(User user);
}
