package com.epsilon.homebanking.user.infrastructure.database.mapper;

import com.epsilon.homebanking.card.domain.Card;
import com.epsilon.homebanking.card.infrastructure.database.entity.CardEntity;
import com.epsilon.homebanking.common.mapper.EntityBaseMapper;
import org.springframework.stereotype.Component;

@Component
public class CardEntityMapper extends EntityBaseMapper<CardEntity, Card> {

  @Override
  public Card toDomain(CardEntity entity, Object... args) {
    if (entity == null) {
      return null;
    }
    return Card.builder()
        .cardId(entity.getCardId())
        .cardPin(entity.getCardPin())
        .cardNumber(entity.getCardNumber())
        .cardBalance(entity.getCardBalance())
        .cardStatus(entity.isCardStatus())
        .build();
  }

  @Override
  public CardEntity toEntity(Card domain, Object... args) {
    if (domain == null) {
      return null;
    }
    return CardEntity.builder()
        .cardId(domain.getCardId())
        .cardPin(domain.getCardPin())
        .cardNumber(domain.getCardNumber())
        .cardBalance(domain.getCardBalance())
        .cardStatus(domain.isCardStatus())
        .build();
  }


}
