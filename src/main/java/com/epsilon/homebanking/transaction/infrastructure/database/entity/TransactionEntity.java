package com.epsilon.homebanking.transaction.infrastructure.database.entity;

import java.sql.Timestamp;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Getter
@Setter
@DynamicUpdate
@Table(name = "TRANSACTIONS", indexes = {
    @Index(name = "IDX_TRANSACTION_AMOUNT", columnList = "TRANSACTION_AMOUNT")})
public class TransactionEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "TRANSACTION_ID")
  private Long transactionId;

  @Column(name = "TRANSACTION_DESCRIPTION")
  private String description;

  @Column(name = "TRANSACTION_AMOUNT")
  private Long amount;

  @Column(name = "TRANSACTIONAL_DATE")
  private LocalDate transactionalDate;

  @Column(name = "TRANSACTIONAL_STATUS")
  private boolean status;

  @Column(name = "CREATE_TIMESTAMP", updatable = false)
  @CreationTimestamp
  private Timestamp createTimestamp;
}
