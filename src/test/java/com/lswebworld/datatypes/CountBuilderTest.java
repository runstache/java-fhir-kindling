package com.lswebworld.datatypes;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import org.hl7.fhir.r4.model.Count;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.Quantity.QuantityComparator;
import org.hl7.fhir.r4.model.StringType;
import org.junit.jupiter.api.Test;

class CountBuilderTest {

  @Test
  void testWithValue() {
    Count quantity = new CountBuilder()
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
    Count quantity = new CountBuilder()
        .withComparator(QuantityComparator.GREATER_THAN)
        .build();
    assertThat(quantity.getComparator())
        .as("Comparator should be Greater Than")
        .isEqualTo(QuantityComparator.GREATER_THAN);
  }

  @Test
  void testWithUnit() {
    Count quantity = new CountBuilder()
        .withUnit("ml")
        .build();
    assertThat(quantity.getUnit())
        .as("Unit should be ml")
        .isEqualToIgnoringCase("ml");
  }

  @Test
  void testWithSystem() {
    Count quantity = new CountBuilder()
        .withSystem("http://unitsofmeasure.org")
        .build();
    assertThat(quantity.getSystem())
        .as("System should be http://unitsofmeasure.org")
        .isEqualToIgnoringCase("http://unitsofmeasure.org");
  }

  @Test
  void testWithCode() {
    Count quantity = new CountBuilder()
        .withCode("ml")
        .build();
    assertThat(quantity.getCode())
        .as("Code should be ml")
        .isEqualToIgnoringCase("ml");
  }

  @Test
  void testWithId() {
    Count quantity = new CountBuilder()
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

    Count quantity = new CountBuilder()
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
