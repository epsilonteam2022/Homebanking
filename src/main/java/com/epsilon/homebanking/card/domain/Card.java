package com.epsilon.homebanking.card.domain;

import com.epsilon.homebanking.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Card {
  private Long cardId;
  private Long cardNumber;
  private Integer cardPin;
  private LocalDate dateOfExpiration;
  private Long cardBalance;
  private User user;
  private boolean cardStatus;
}
