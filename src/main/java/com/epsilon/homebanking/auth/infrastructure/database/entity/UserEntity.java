package com.epsilon.homebanking.auth.infrastructure.database.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserEntity {

  @Id
  @GeneratedValue
  private Long userId;
}
