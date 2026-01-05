package dev.williancorrea.algashop.ordering.domain.validator;


import java.util.Objects;
import org.apache.commons.validator.routines.EmailValidator;

public class FieldValidations {

  private FieldValidations() {
  }

  public static void requiresValidEmail(String email) {
    requiresValidEmail(email, null);
  }

  public static void requiresValidEmail(String email, String errorMessage) {
    Objects.requireNonNull(email);
    if (email.isBlank()) {
      throw new IllegalArgumentException(errorMessage);
    }

    if (!EmailValidator.getInstance().isValid(email)) {
      throw new IllegalArgumentException(errorMessage);
    }
  }
}
