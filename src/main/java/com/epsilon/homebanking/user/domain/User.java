package com.epsilon.homebanking.user.domain;

import com.epsilon.homebanking.address.domain.Address;
import com.epsilon.homebanking.card.domain.Card;
import com.epsilon.homebanking.role.domain.Role;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class User {

  private Long userId;
  private String firstName;
  private String lastName;
  private String email;
  private String password;
  private String imageUrl;
  private Role role;
  private Address address;
  private Set<Card> cards;
  private String token;

}
