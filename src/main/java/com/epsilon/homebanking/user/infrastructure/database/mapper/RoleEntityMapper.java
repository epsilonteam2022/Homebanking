package com.epsilon.homebanking.user.infrastructure.database.mapper;

import com.epsilon.homebanking.common.mapper.EntityBaseMapper;
import com.epsilon.homebanking.role.domain.Role;
import com.epsilon.homebanking.role.infrastructure.database.entity.RoleEntity;
import org.springframework.stereotype.Component;

@Component
public class RoleEntityMapper extends EntityBaseMapper<RoleEntity, Role> {


  @Override
  public Role toDomain(RoleEntity entity, Object... args) {
    if (entity == null) {
      return null;
    }
    return com.epsilon.homebanking.role.domain.Role.builder()
        .roleId(entity.getRoleId())
        .roleName(entity.getRoleName())
        .roleDescription(entity.getRoleDescription())
        .build();
  }

  @Override
  public RoleEntity toEntity(Role domain, Object... args) {
    return RoleEntity.builder()
        .roleId(domain.getRoleId())
        .roleName(domain.getRoleName())
        .roleDescription(domain.getRoleDescription())
        .build();
  }
}
