package dev.williancorrea.algashop.ordering.domain.entity;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import dev.williancorrea.algashop.ordering.domain.utility.IdGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CustomerTest {

  @Test
  void given_invalidEmail_whenTryCreateCustomer_shouldGenerateException() {
    Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> new Customer(
            IdGenerator.generateTimeBaseUUID(),
            "John Due",
            LocalDate.of(1991, 7, 5),
            "invalidEmail",
            "478-256-2504",
            "255-08-0578",
            true,
            OffsetDateTime.now()
        ));
  }

  @Test
  void given_invalidEmail_whenUpdatedCustomerEmail_shouldGenerateException() {
    var customer = new Customer(
        IdGenerator.generateTimeBaseUUID(),
        "John Due",
        LocalDate.of(1991, 7, 5),
        "john.due@email.com",
        "478-256-2504",
        "255-08-0578",
        true,
        OffsetDateTime.now());

    Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> customer.changeEmail("invalidEmail"));
  }
}
