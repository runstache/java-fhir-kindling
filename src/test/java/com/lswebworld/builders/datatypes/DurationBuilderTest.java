package com.lswebworld.builders.datatypes;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import org.hl7.fhir.r4.model.Duration;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.Quantity.QuantityComparator;
import org.hl7.fhir.r4.model.StringType;
import org.junit.jupiter.api.Test;

class DurationBuilderTest {
  @Test
  void testWithValue() {
    Duration quantity = new DurationBuilder()
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
    Duration quantity = new DurationBuilder()
        .withComparator(QuantityComparator.GREATER_THAN)
        .build();
    assertThat(quantity.getComparator())
        .as("Comparator should be Greater Than")
        .isEqualTo(QuantityComparator.GREATER_THAN);
  }

  @Test
  void testWithUnit() {
    Duration quantity = new DurationBuilder()
        .withUnit("ml")
        .build();
    assertThat(quantity.getUnit())
        .as("Unit should be ml")
        .isEqualToIgnoringCase("ml");
  }

  @Test
  void testWithSystem() {
    Duration quantity = new DurationBuilder()
        .withSystem("http://unitsofmeasure.org")
        .build();
    assertThat(quantity.getSystem())
        .as("System should be http://unitsofmeasure.org")
        .isEqualToIgnoringCase("http://unitsofmeasure.org");
  }

  @Test
  void testWithCode() {
    Duration quantity = new DurationBuilder()
        .withCode("ml")
        .build();
    assertThat(quantity.getCode())
        .as("Code should be ml")
        .isEqualToIgnoringCase("ml");
  }

  @Test
  void testWithId() {
    Duration quantity = new DurationBuilder()
        .withId("MyID")
        .build();
  
    assertThat(quantity.getId())
        .as("Id should be MyID")
        .isEqualToIgnoringCase("MyID");
        
  }

  @Test
  void testAddExtension() {
    Extension extension = new Extension("http://www.myextension.com");
    extension.setValue(new StringType("MyValue"));

    Duration quantity = new DurationBuilder()
        .addExtension(extension)
        .build();
    assertThat(quantity.getExtension())
        .as("Extension should be set with correct values")
        .isNotEmpty()
        .allSatisfy(ext -> {
          assertThat(ext.getUrl()).isEqualToIgnoringCase("http://www.myextension.com");
          StringType value = (StringType) ext.getValue();          
          assertThat(value.getValueAsString()).isEqualToIgnoringCase("MyValue");
        });

  }
}
