package com.epsilon.homebanking.user.infrastructure.rest.request.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = CharactersNumbersAndSymbolsValidator.class)
public @interface CharactersNumbersAndSymbols {

  String message() default "{request.validation.CharactersNumbersAndSymbolsValidator.message}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
