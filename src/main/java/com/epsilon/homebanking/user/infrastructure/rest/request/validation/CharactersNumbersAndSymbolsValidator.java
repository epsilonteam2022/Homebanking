package com.epsilon.homebanking.user.infrastructure.rest.request.validation;

import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;

public class CharactersNumbersAndSymbolsValidator implements
    ConstraintValidator<CharactersNumbersAndSymbols, String> {

  private static final String REGEXP =
      "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

  @Override
  public void initialize(CharactersNumbersAndSymbols constraintAnnotation) {
    ConstraintValidator.super.initialize(constraintAnnotation);
  }

  @Override
  public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
    Pattern pattern = Pattern.compile(REGEXP);
    return StringUtils.hasText(name) && pattern.matcher(name).matches();
  }
}
