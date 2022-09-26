package com.epsilon.homebanking.user.infrastructure.database.mapper;

import com.epsilon.homebanking.common.mapper.EntityBaseMapper;
import com.epsilon.homebanking.security.common.JwtUtils;
import com.epsilon.homebanking.user.domain.User;
import com.epsilon.homebanking.user.infrastructure.database.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserEntityMapper extends EntityBaseMapper<UserEntity, User> {

  private final RoleEntityMapper roleEntityMapper;
  private final AddressEntityMapper addressEntityMapper;
  private final CardEntityMapper cardEntityMapper;

  private final PasswordEncoder passwordEncoder;


  @Override
  public User toDomain(UserEntity entity, Object... args) {
    if (entity == null) {
      return null;
    }
    return User.builder()
        .userId(entity.getUserId())
        .firstName(entity.getFirstName())
        .lastName(entity.getLastName())
        .imageUrl(entity.getImageUrl())
        .email(entity.getEmail())
        .password(entity.getPassword())
        .cards(cardEntityMapper.toDomainSet(entity.getCards()))
        .role(roleEntityMapper.toDomain(entity.getRole()))
        .address(addressEntityMapper.toDomain(entity.getAddress()))
        .token(JwtUtils.create(entity))
        .build();
  }

  @Override
  public UserEntity toEntity(User domain, Object... args) {
    if (domain == null) {
      return null;
    }
    return UserEntity.builder()
        .userId(domain.getUserId())
        .firstName(domain.getFirstName())
        .lastName(domain.getLastName())
        .email(domain.getEmail())
        .imageUrl(domain.getImageUrl())
        .password(passwordEncoder.encode(domain.getPassword()))
        .role(roleEntityMapper.toEntity(domain.getRole()))
        .address(addressEntityMapper.toEntity(domain.getAddress()))
        .cards(cardEntityMapper.toEntitySet(domain.getCards()))
        .build();
  }
}
