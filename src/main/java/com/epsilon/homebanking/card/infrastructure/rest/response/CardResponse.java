package com.epsilon.homebanking.card.infrastructure.rest.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@Builder
public class CardResponse {

    private String cardNumber;

    private Integer cardPin;

    private LocalDate dateOfExpiration;
}
