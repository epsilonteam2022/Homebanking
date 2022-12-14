package com.epsilon.homebanking.user.infrastructure.rest.request.validation;

import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;

public class CharactersWithWhitespacesValidator implements
    ConstraintValidator<CharactersWithWhiteSpaces, String> {

  private static final String REGEXP = "^\\p{L}+[\\p{L}\\s]*$";

  @Override
  public void initialize(CharactersWithWhiteSpaces constraintAnnotation) {
    ConstraintValidator.super.initialize(constraintAnnotation);
  }

  @Override
  public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
    Pattern pattern = Pattern.compile(REGEXP);
    return StringUtils.hasText(name) && pattern.matcher(name).matches();
  }
}
