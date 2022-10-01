package com.epsilon.homebanking.card.infrastructure.rest.mapper;

import com.epsilon.homebanking.card.domain.Card;
import com.epsilon.homebanking.card.infrastructure.rest.request.CardRequest;
import com.epsilon.homebanking.card.infrastructure.rest.response.CardResponse;
import com.epsilon.homebanking.common.mapper.RestBaseMapper;
import org.springframework.stereotype.Component;

@Component
public class CardMapper extends RestBaseMapper<CardRequest, Card, CardResponse> {
    @Override
    public Card toDomain(CardRequest request, Object... args) {
        if (request == null) {
            return null;
        }
        return Card.builder()
                .cardNumber(request.getCardNumber())
                .cardPin(request.getCardPin())
                .dateOfExpiration(request.getDateOfExpiration())
                .build();
    }

    @Override
    public CardResponse toResponse(Card domain, Object... args) {
        if (domain == null) {
            return null;
        }
        return CardResponse.builder()
                .cardNumber(domain.getCardNumber())
                .cardPin(domain.getCardPin())
                .dateOfExpiration(domain.getDateOfExpiration())
                .build();
    }
}
