package dev.williancorrea.algashop.ordering.domain.exception;

public class ErrorMessages {
  public static final String VALIDATION_ERROR_BIRTHDATE_MUST_IN_PAST = "BirthDate must be a past date";

  public static final String VALIDATION_ERROR_FULLNAME_IS_NULL = "FullName cannot be null";
  public static final String VALIDATION_ERROR_FULLNAME_IS_BLANK = "FullName cannot be blank";

  public static final String VALIDATION_ERROR_EMAIL_IS_INVALID = "Email is invalid";
  
  public static final String ERROR_CUSTOMER_ARCHIVED = "Customer is archived";
  public static final String ERROR_CUSTOMER_LOYALTY_IS_INVALID = "Loyalty points must be greater than zero";
}
