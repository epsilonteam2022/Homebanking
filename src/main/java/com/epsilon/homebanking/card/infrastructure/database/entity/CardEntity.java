package com.epsilon.homebanking.card.infrastructure.database.entity;

import com.epsilon.homebanking.user.infrastructure.database.entity.UserEntity;
import java.sql.Timestamp;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;

import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Getter
@Setter
@Builder
@DynamicUpdate
@Table(name = "CARDS", indexes = {
    @Index(name = "IDX_CARD_BALANCE", columnList = "CARD_BALANCE")})
public class CardEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "CARD_ID")
  private Long cardId;

  @Column(name = "CARD_NUMBER", unique = true)
  private String cardNumber;

  @Column(name = "CARD_PIN", unique = true, updatable = false)
  private Integer cardPin;

  @Column(name = "CARD_BALANCE")
  private Long cardBalance;

  @Column(name = "CARD_STATUS")
  private boolean cardStatus;

  @Column(name = "DATE_EXPIRATION", updatable = false)
  private LocalDate dateOfExpiration;

  @ManyToOne
  @JoinColumn(name = "USER_ID")
  private UserEntity user;

  @Column(name = "CREATE_TIMESTAMP", updatable = false)
  @CreationTimestamp
  private Timestamp createTimestamp;

  public CardEntity(Long cardId, String cardNumber, Integer cardPin, Long cardBalance, boolean cardStatus, LocalDate dateOfExpiration, UserEntity user, Timestamp createTimestamp) {
    this.cardId = cardId;
    this.cardNumber = cardNumber;
    this.cardPin = cardPin;
    this.cardBalance = cardBalance;
    this.cardStatus = cardStatus;
    this.dateOfExpiration = dateOfExpiration;
    this.user = user;
    this.createTimestamp = createTimestamp;
  }

  public CardEntity() {
  }
}
