package com.epsilon.homebanking.card.application;

import com.epsilon.homebanking.card.application.usecase.CreateCard;
import com.epsilon.homebanking.card.domain.Card;
import com.epsilon.homebanking.card.domain.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardCreateImpl implements CreateCard {

    private CardRepository cardRepository;

    @Autowired
    public CardCreateImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public Card create(Card card,Long id) {
        return cardRepository.create(card,id);
    }
}
