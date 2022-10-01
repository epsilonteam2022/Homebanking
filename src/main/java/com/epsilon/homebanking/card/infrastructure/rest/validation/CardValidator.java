package com.epsilon.homebanking.card.infrastructure.rest.validation;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;


public class CardValidator implements ConstraintValidator<CardNumber,String> {

    private static final String REGEX="(\\d{4}\\s)(\\d{4}\\s)(\\d{4}\\s)(\\d{4})";


    public void initialize(CardNumber constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }


    public boolean isValid(String cardNumber, ConstraintValidatorContext constraintValidatorContext) {
        Pattern pattern = Pattern.compile(REGEX);
        return StringUtils.hasText(cardNumber)&&pattern.matcher(cardNumber).matches();
    }
}
