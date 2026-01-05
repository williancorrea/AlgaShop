package dev.williancorrea.algashop.ordering.domain.entity;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import dev.williancorrea.algashop.ordering.domain.utility.IdGenerator;
import org.junit.jupiter.api.Test;

class CustomerTest {

  @Test
  void testingCustomer() {
    Customer customer = new Customer(
        IdGenerator.generateTimeBaseUUID(),
        "John Due",
        LocalDate.of(1991, 7, 5),
        "john.due@email.com",
        "478-256-2504",
        "255-08-0578",
        true,
        OffsetDateTime.now()
    );

    customer.addLoyaltyPoints(10);
  }
}
