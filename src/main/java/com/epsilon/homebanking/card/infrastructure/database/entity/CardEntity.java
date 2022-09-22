package com.epsilon.homebanking.card.infrastructure.database.entity;

import com.epsilon.homebanking.user.infrastructure.database.entity.UserEntity;
import java.sql.Timestamp;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Getter
@Setter
@DynamicUpdate
@Table(name = "CARDS", indexes = {
    @Index(name = "IDX_CARD_BALANCE", columnList = "CARD_BALANCE")})
public class CardEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "CARD_ID")
  private Long cardId;

  @Column(name = "CARD_NUMBER", unique = true)
  private Long cardNumber;

  @Column(name = "CARD_PIN", unique = true, updatable = false)
  private Integer cardPin;

  @Column(name = "CARD_BALANCE")
  private Long cardBalance;

  @Column(name = "CARD_STATUS")
  private boolean cardStatus;

  @ManyToMany(mappedBy = "cards")
  private Set<UserEntity> users;

  @Column(name = "CREATE_TIMESTAMP", updatable = false)
  @CreationTimestamp
  private Timestamp createTimestamp;
}
