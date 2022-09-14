package com.epsilon.homebanking.card.infrastructure.database.repository.abstraction;

import com.epsilon.homebanking.card.infrastructure.database.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardSpringRepository extends JpaRepository<CardEntity, Long> {

}
