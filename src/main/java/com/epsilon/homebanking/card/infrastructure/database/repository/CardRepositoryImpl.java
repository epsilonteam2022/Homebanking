package com.epsilon.homebanking.card.infrastructure.database.repository;

import com.epsilon.homebanking.card.domain.Card;
import com.epsilon.homebanking.card.domain.repository.CardRepository;
import com.epsilon.homebanking.card.infrastructure.database.entity.CardEntity;
import com.epsilon.homebanking.card.infrastructure.database.mapper.CardEntityMapper;
import com.epsilon.homebanking.card.infrastructure.database.repository.abstraction.CardSpringRepository;
import com.epsilon.homebanking.user.infrastructure.database.entity.UserEntity;
import com.epsilon.homebanking.user.infrastructure.database.repository.abstraction.UserSpringRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CardRepositoryImpl implements CardRepository {

    private final CardSpringRepository cardSpringRepository;
    private final UserSpringRepository userSpringRepository;
    private final CardEntityMapper cardEntityMapper;

    @Override
    public Card create(Card card,Long id) {
        CardEntity cardEntity = cardEntityMapper.toEntity(card);
        Optional<UserEntity> user =userSpringRepository.findById(id);
        UserEntity userEntity= new UserEntity();
        userEntity.setCards((Set<CardEntity>) card);
        userSpringRepository.save(userEntity);
        //example
        return cardEntityMapper.toDomain(cardSpringRepository.save(cardEntity));

    }
}
