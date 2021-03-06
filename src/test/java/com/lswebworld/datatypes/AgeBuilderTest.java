package com.lswebworld.datatypes;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import org.hl7.fhir.r4.model.Age;
import org.hl7.fhir.r4.model.Quantity.QuantityComparator;
import org.junit.jupiter.api.Test;

class AgeBuilderTest {
  @Test
  void testWithValue() {
    Age quantity = new AgeBuilder()
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
    Age quantity = new AgeBuilder()
        .withComparator(QuantityComparator.GREATER_THAN)
        .build();
    assertThat(quantity.getComparator())
        .as("Comparator should be Greater Than")
        .isEqualTo(QuantityComparator.GREATER_THAN);
  }

  @Test
  void testWithUnit() {
    Age quantity = new AgeBuilder()
        .withUnit("ml")
        .build();
    assertThat(quantity.getUnit())
        .as("Unit should be ml")
        .isEqualToIgnoringCase("ml");
  }

  @Test
  void testWithSystem() {
    Age quantity = new AgeBuilder()
        .withSystem("http://unitsofmeasure.org")
        .build();
    assertThat(quantity.getSystem())
        .as("System should be http://unitsofmeasure.org")
        .isEqualToIgnoringCase("http://unitsofmeasure.org");
  }

  @Test
  void testWithCode() {
    Age quantity = new AgeBuilder()
        .withCode("ml")
        .build();
    assertThat(quantity.getCode())
        .as("Code should be ml")
        .isEqualToIgnoringCase("ml");
  }
}
