package com.lswebworld.datatypes;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import org.hl7.fhir.r4.model.Distance;
import org.hl7.fhir.r4.model.Quantity.QuantityComparator;
import org.junit.jupiter.api.Test;

class DistanceBuilderTest {
  @Test
  void testWithValue() {
    Distance quantity = new DistanceBuilder()
        .withValue(25.5)
        .build();
    assertThat(quantity.getValue())
        .as("Value should not be null")
        .isNotNull();
    assertThat(quantity.getValue())
        .as("Value should be 25.5")
        .extracting(BigDecimal.class::cast)
        .extracting(BigDecimal::doubleValue)
        .isEqualTo(25.5);
  }

  @Test
  void testWithComparator() {
    Distance quantity = new DistanceBuilder()
        .withComparator(QuantityComparator.GREATER_THAN)
        .build();
    assertThat(quantity.getComparator())
        .as("Comparator should be Greater Than")
        .isEqualTo(QuantityComparator.GREATER_THAN);
  }

  @Test
  void testWithUnit() {
    Distance quantity = new DistanceBuilder()
        .withUnit("ml")
        .build();
    assertThat(quantity.getUnit())
        .as("Unit should be ml")
        .isEqualToIgnoringCase("ml");
  }

  @Test
  void testWithSystem() {
    Distance quantity = new DistanceBuilder()
        .withSystem("http://unitsofmeasure.org")
        .build();
    assertThat(quantity.getSystem())
        .as("System should be http://unitsofmeasure.org")
        .isEqualToIgnoringCase("http://unitsofmeasure.org");
  }

  @Test
  void testWithCode() {
    Distance quantity = new DistanceBuilder()
        .withCode("ml")
        .build();
    assertThat(quantity.getCode())
        .as("Code should be ml")
        .isEqualToIgnoringCase("ml");
  }
}