package com.epsilon.homebanking.card.infrastructure.database.mapper;

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
                .cardNumber(entity.getCardNumber())
                .cardPin(entity.getCardPin())
                .dateOfExpiration(entity.getDateOfExpiration())
                .build();
    }

    @Override
    public CardEntity toEntity(Card domain, Object... args) {
        if (domain == null) {
            return null;
        }
        return CardEntity.builder()
                .cardNumber(domain.getCardNumber())
                .cardPin(domain.getCardPin())
                .dateOfExpiration(domain.getDateOfExpiration())
                .build();
    }
}
