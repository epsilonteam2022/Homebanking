package com.epsilon.homebanking.security.common;

public enum Role {

  ADMIN, USER;

  private static final String ROLE_PREFIX = "ROLE_";

  public String getFullRoleName() {
    return ROLE_PREFIX + this.name();
  }

}
