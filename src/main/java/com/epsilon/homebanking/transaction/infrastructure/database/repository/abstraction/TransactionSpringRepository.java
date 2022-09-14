package com.epsilon.homebanking.transaction.infrastructure.database.repository.abstraction;

import com.epsilon.homebanking.transaction.infrastructure.database.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionSpringRepository extends JpaRepository<TransactionEntity, Long> {

}
