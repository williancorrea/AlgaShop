package dev.williancorrea.algashop.ordering.domain.entity;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import dev.williancorrea.algashop.ordering.domain.exception.CustomerArchivedException;
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

  @Test
  void given_unarchivedCustomer_whenArchive_shouldAnonymize() {
    var customer = new Customer(
        IdGenerator.generateTimeBaseUUID(),
        "John Due",
        LocalDate.of(1991, 7, 5),
        "john.due@email.com",
        "478-256-2504",
        "255-08-0578",
        true,
        OffsetDateTime.now());

    customer.archive();

    Assertions.assertWith(customer,
        c -> Assertions.assertThat(c.fullName()).isEqualTo("Anonymous"),
        c -> Assertions.assertThat(c.email()).isNotEqualTo("john.due@email.com"),
        c -> Assertions.assertThat(c.phone()).isEqualTo("000-000-0000"),
        c -> Assertions.assertThat(c.document()).isEqualTo("000-000-0000"),
        c -> Assertions.assertThat(c.birthDate()).isNull(),
        c -> Assertions.assertThat(c.iPromotionNotificationsAllowed()).isFalse()
    );
  }

  @Test
  void given_archivedCustomer_whenTryToUpdate_shouldGenerateException() {
    var customer = new Customer(
        IdGenerator.generateTimeBaseUUID(),
        "John Due",
        LocalDate.of(1991, 7, 5),
        "john.due@email.com",
        "478-256-2504",
        "255-08-0578",
        false,
        true,
        OffsetDateTime.now(),
        OffsetDateTime.now(),
        10);

    Assertions.assertThatExceptionOfType(CustomerArchivedException.class)
        .isThrownBy(customer::archive);

    Assertions.assertThatExceptionOfType(CustomerArchivedException.class)
        .isThrownBy(() -> customer.changeEmail("email@gmail.com"));

    Assertions.assertThatExceptionOfType(CustomerArchivedException.class)
        .isThrownBy(() -> customer.changePhone("123-123-1111"));

    Assertions.assertThatExceptionOfType(CustomerArchivedException.class)
        .isThrownBy(customer::enablePromotionNotifications);

    Assertions.assertThatExceptionOfType(CustomerArchivedException.class)
        .isThrownBy(customer::disablePromotionNotifications);
  }

  @Test
  void given_brandNewCustomer_whenAddLoyaltyPoints_shouldSumPoints() {
    var customer = new Customer(
        IdGenerator.generateTimeBaseUUID(),
        "John Due",
        LocalDate.of(1991, 7, 5),
        "john.due@email.com",
        "478-256-2504",
        "255-08-0578",
        false,
        OffsetDateTime.now());

    customer.addLoyaltyPoints(10);
    customer.addLoyaltyPoints(20);

    Assertions.assertThat(customer.loyaltyPoints()).isEqualTo(30);
  }

  @Test
  void given_brandNewCustomer_whenAddInvalidLoyaltyPoints_shouldGenerateException() {
    var customer = new Customer(
        IdGenerator.generateTimeBaseUUID(),
        "John Due",
        LocalDate.of(1991, 7, 5),
        "john.due@email.com",
        "478-256-2504",
        "255-08-0578",
        false,
        OffsetDateTime.now());

    Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> customer.addLoyaltyPoints(0));
    
    Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> customer.addLoyaltyPoints(-10));
  }
}
