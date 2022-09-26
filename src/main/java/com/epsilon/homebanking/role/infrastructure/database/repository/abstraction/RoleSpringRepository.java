package com.epsilon.homebanking.role.infrastructure.database.repository.abstraction;

import com.epsilon.homebanking.role.infrastructure.database.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleSpringRepository extends JpaRepository<RoleEntity, Long> {

  RoleEntity findByRoleName(String name);
}
