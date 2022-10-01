package com.epsilon.homebanking.card.infrastructure.rest.resource;

import com.epsilon.homebanking.card.application.usecase.CreateCard;
import com.epsilon.homebanking.card.domain.Card;
import com.epsilon.homebanking.card.infrastructure.rest.mapper.CardMapper;
import com.epsilon.homebanking.card.infrastructure.rest.request.CardRequest;
import com.epsilon.homebanking.card.infrastructure.rest.response.CardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cards")
public class CardResource {
    private final CreateCard createCard;
    private final CardMapper cardMapper;


    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CardResponse> create(
            @Valid @RequestBody CardRequest request) {
        Card card = createCard.create(cardMapper.toDomain(request));
        CardResponse response = cardMapper.toResponse(card);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/add/{idCard}/{idUser}")
    public ResponseEntity<CardResponse> addCard(@PathVariable Long idCard, @PathVariable Long idUser) {
        Card card = createCard.add(idCard,idUser);
        CardResponse response = cardMapper.toResponse(card);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


}
