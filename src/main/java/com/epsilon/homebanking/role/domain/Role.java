package com.epsilon.homebanking.role.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Role {
  private Long roleId;
  private String roleName;
  private String roleDescription;
}
