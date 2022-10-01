package com.epsilon.homebanking.card.infrastructure.rest.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy =CardValidator.class)
public @interface CardNumber {
    String message() default "Card number is not valid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload()default {};
}
