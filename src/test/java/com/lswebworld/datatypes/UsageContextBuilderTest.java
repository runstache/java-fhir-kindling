package com.lswebworld.datatypes;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.Quantity;
import org.hl7.fhir.r4.model.Range;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.StringType;
import org.hl7.fhir.r4.model.UsageContext;
import org.junit.jupiter.api.Test;

class UsageContextBuilderTest {

  @Test
  void testWithId() {
    UsageContext context = new UsageContextBuilder()
        .withId("MyId")
        .build();
    assertThat(context.getId())
        .as("Id should be MyId")
        .isEqualToIgnoringCase("MyId");
  }

  @Test
  void testAddExtension() {
    Extension extension = new Extension("http://www.myextension.com");
    extension.setValue(new StringType("MyValue"));

    UsageContext context = new UsageContextBuilder()
        .addExtension(extension)
        .build();
    assertThat(context.getExtension())
        .as("Extension should be set with correct values")
        .isNotEmpty()
        .allSatisfy(ext -> {
          assertThat(ext.getUrl()).isEqualToIgnoringCase("http://www.myextension.com");
          StringType value = (StringType) ext.getValue();
          assertThat(value.getValueAsString()).isEqualToIgnoringCase("MyValue");
        });
  }

  @Test
  void testWithCode() {
    UsageContext context = new UsageContextBuilder()
        .withCode(new Coding("MY.CODE.OID", "MY_CODE", "CODE DISPLAY"))
        .build();
    assertThat(context.getCode())
        .as("Code should be Populated")
        .extracting("system", "code", "display")
        .containsOnly("MY.CODE.OID", "MY_CODE", "CODE DISPLAY");
  }

  @Test
  void testWithValueCodeableConcept() {
    CodeableConcept concept = new CodeableConcept();
    concept.setText("My Value");

    UsageContext context = new UsageContextBuilder()
        .withValue(concept)
        .build();

    assertThat(context.getValue())
        .as("Value should be a Codeable Concept")
        .isInstanceOf(CodeableConcept.class)
        .extracting(CodeableConcept.class::cast)
        .extracting(CodeableConcept::getText)
        .isEqualTo("My Value");
  }

  @Test
  void testWithValueQuantity() {
    Quantity quantity = new Quantity();
    quantity.setValue(56.4);

    UsageContext context = new UsageContextBuilder()
        .withValue(quantity)
        .build();
    assertThat(context.getValue())
        .as("Value should be a Quantity")
        .isInstanceOf(Quantity.class)
        .extracting(Quantity.class::cast)
        .extracting(Quantity::getValue)
        .extracting(BigDecimal::doubleValue)
        .isEqualTo(56.4);
  }

  @Test
  void testWithValueRange() {
    Quantity quantity = new Quantity();
    quantity.setValue(56.4);

    Range range = new Range();
    range.setHigh(quantity);

    UsageContext context = new UsageContextBuilder()
        .withValue(range)
        .build();
    assertThat(context.getValue())
        .as("Value should be a Range")
        .isInstanceOf(Range.class)
        .extracting(Range.class::cast)
        .extracting(Range::getHigh)
        .extracting(Quantity.class::cast)
        .extracting(Quantity::getValue)
        .extracting(BigDecimal::doubleValue)
        .isEqualTo(56.4);
  }

  @Test
  void testWithValueReference() {
    Reference reference = new Reference();
    reference.setReference("Patient/12345");

    UsageContext context = new UsageContextBuilder()
        .withValue(reference)
        .build();

    assertThat(context.getValue())
        .as("Value should be a Reference")
        .isInstanceOf(Reference.class)
        .extracting(Reference.class::cast)
        .extracting(Reference::getReference)
        .isEqualTo("Patient/12345");
  }
}