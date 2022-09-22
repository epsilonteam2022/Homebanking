package com.epsilon.homebanking.user.infrastructure.database.repository.abstraction;

import com.epsilon.homebanking.user.infrastructure.database.entity.UserEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSpringRepository extends JpaRepository<UserEntity, Long> {

  Optional<UserEntity> findByEmail(String email);
}
