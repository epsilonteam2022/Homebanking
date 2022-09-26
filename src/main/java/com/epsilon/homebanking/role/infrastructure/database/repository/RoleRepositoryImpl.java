package com.epsilon.homebanking.role.infrastructure.database.repository;

import com.epsilon.homebanking.role.domain.Role;
import com.epsilon.homebanking.role.domain.repository.RoleRepository;
import com.epsilon.homebanking.role.infrastructure.database.repository.abstraction.RoleSpringRepository;
import com.epsilon.homebanking.user.infrastructure.database.mapper.RoleEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoleRepositoryImpl implements RoleRepository {

  private final RoleSpringRepository roleSpringRepository;
  private final RoleEntityMapper roleEntityMapper;

  @Override
  public Role findRole() {
    return roleEntityMapper.toDomain(roleSpringRepository.findByRoleName(
        com.epsilon.homebanking.security.common.Role.USER.getFullRoleName()));
  }
}
