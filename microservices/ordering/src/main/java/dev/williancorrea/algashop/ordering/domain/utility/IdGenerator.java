package dev.williancorrea.algashop.ordering.domain.utility;

import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.impl.TimeBasedEpochRandomGenerator;
import java.util.UUID;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class IdGenerator {

  private static final TimeBasedEpochRandomGenerator timeBasedEpochGenerator = Generators.timeBasedEpochRandomGenerator();

  public static UUID generateTimeBaseUUID() {
    return UUID.randomUUID();
  }


}
