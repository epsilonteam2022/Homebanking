package com.epsilon.homebanking.user.infrastructure.database.repository;

import com.epsilon.homebanking.user.domain.User;
import com.epsilon.homebanking.user.domain.repository.UserRepository;
import com.epsilon.homebanking.user.infrastructure.database.entity.UserEntity;
import com.epsilon.homebanking.user.infrastructure.database.mapper.UserEntityMapper;
import com.epsilon.homebanking.user.infrastructure.database.repository.abstraction.UserSpringRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

  private final UserSpringRepository userSpringRepository;
  private final UserEntityMapper userEntityMapper;

  @Override
  public Optional<User> findByEmail(String email) {
    Optional<UserEntity> userEntity = userSpringRepository.findByEmail(email);
    if (userEntity.isEmpty()) {
      return Optional.empty();
    }
    return Optional.of(userEntityMapper.toDomain(userEntity.get()));
  }

  @Override
  public User register(User user) {
    UserEntity userEntity = userEntityMapper.toEntity(user);
    userEntity.setSoftDeleted(false);
    return userEntityMapper.toDomain(userSpringRepository.save(userEntity));
  }
}
