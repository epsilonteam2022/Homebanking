package com.epsilon.homebanking.card.infrastructure.database.repository;

import com.epsilon.homebanking.card.domain.Card;
import com.epsilon.homebanking.card.domain.repository.CardRepository;
import com.epsilon.homebanking.card.infrastructure.database.entity.CardEntity;
import com.epsilon.homebanking.card.infrastructure.database.mapper.CardEntityMapper;
import com.epsilon.homebanking.card.infrastructure.database.repository.abstraction.CardSpringRepository;
import com.epsilon.homebanking.common.exception.CardNotExistsException;
import com.epsilon.homebanking.common.exception.UserNotExistsException;
import com.epsilon.homebanking.user.infrastructure.database.entity.UserEntity;
import com.epsilon.homebanking.user.infrastructure.database.repository.abstraction.UserSpringRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Component
@RequiredArgsConstructor
public class CardRepositoryImpl implements CardRepository {

    private final CardSpringRepository cardSpringRepository;
    private final UserSpringRepository userSpringRepository;
    private final CardEntityMapper cardEntityMapper;

    @Override
    public Card create(Card card) {
        CardEntity cardEntity = cardEntityMapper.toEntity(card);
        return cardEntityMapper.toDomain(cardSpringRepository.save(cardEntity));
    }

    @Override
    public Card add(Long idCard, Long idUser) {
        Optional<CardEntity> card=cardSpringRepository.findById(idCard);
        Optional<UserEntity> user=userSpringRepository.findById(idUser);
        if (card.isEmpty()){
            throw new CardNotExistsException("Card not exist");
        }
        if (user.isEmpty()){
            throw new UserNotExistsException("User not exist");
        }
        user.get().setCards(cardEntityMapper.toEntitySet(card));
        return null;
    }

}
