package com.epsilon.homebanking.card.infrastructure.rest.request;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
public class CardRequest {
    @Pattern(regexp = "/^(?:4[0-9]{12}(?:[0-9]{3})?|5[1-5][0-9]{14}|3[47][0-9]{13}|6(?:011|5[0-9][0-9])[0-9]{12})$/",message = "format invalid.")
    @NotBlank(message = "Card number field can not be null or empty.")
    private Long cardNumber;

    @Size(min = 4,max = 4)
    @NotBlank(message = "Card pin field can not be null or empty.")
    private Integer cardPin;

    @NotBlank(message = "Card date field can not be null or empty.")
    @Pattern(regexp = "^(?:3[01]|[12][0-9]|0?[1-9])([\\-/.])(0?[1-9]|1[1-2])\\1\\d{4}$",message = "format invalid.")
    private LocalDate dateOfExpiration;
}
