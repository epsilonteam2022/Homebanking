package com.epsilon.homebanking.card.infrastructure.rest.request;

import com.epsilon.homebanking.card.infrastructure.rest.validation.CardNumber;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class CardRequest {

    @CardNumber
    private String cardNumber;


    private Integer cardPin;

    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate dateOfExpiration;
}
