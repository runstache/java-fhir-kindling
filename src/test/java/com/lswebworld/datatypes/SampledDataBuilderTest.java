package com.lswebworld.datatypes;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.Quantity;
import org.hl7.fhir.r4.model.SampledData;
import org.hl7.fhir.r4.model.SimpleQuantity;
import org.hl7.fhir.r4.model.StringType;
import org.junit.jupiter.api.Test;

class SampledDataBuilderTest {

  @Test
  void testWithId() {
    SampledData data = new SampledDataBuilder()
        .withId("MyId")
        .build();
    assertThat(data.getId()).as("Id should be My Id").isEqualToIgnoringCase("MyId");
  }

  @Test
  void testAddExtension() {
    Extension extension = new Extension("http://www.myextension.com");
    extension.setValue(new StringType("MyValue"));

    SampledData data = new SampledDataBuilder()
            .addExtension(extension)
            .build();
    assertThat(data.getExtension())
            .as("Extension should be set with correct values")
            .isNotEmpty()
            .allSatisfy(ext -> {
              assertThat(ext.getUrl()).isEqualToIgnoringCase("http://www.myextension.com");
              StringType value = (StringType) ext.getValue();
              assertThat(value.getValueAsString()).isEqualToIgnoringCase("MyValue");
            });
  }

  @Test
  void testWithOrigin() {
    SimpleQuantity quantity = new SimpleQuantity();
    quantity.setCode("ml");
    quantity.setValue(25.6);

    SampledData data = new SampledDataBuilder()
        .withOrigin(quantity)
        .build();
    assertThat(data.getOrigin())
        .as("Origin should have a value of 25.6")
        .extracting(Quantity.class::cast)
        .extracting(Quantity::getValue)
        .isNotNull()
        .extracting(BigDecimal::doubleValue)
        .isEqualTo(25.6);

    assertThat(data.getOrigin())
        .as("Origin should have a value of 25.6")
        .isNotNull()
        .extracting(SimpleQuantity.class::cast)
        .extracting(SimpleQuantity::getCode)
        .isEqualTo("ml");
  }

  @Test
  void testWithPeriod() {
    SampledData data = new SampledDataBuilder()
        .withPeriod(22.6)
        .build();
    assertThat(data.getPeriod())
        .as("Period should be 22.6")
        .isNotNull()
        .extracting(BigDecimal::doubleValue)
        .isEqualTo(22.6);
  }

  @Test
  void testWithFactor() {
    SampledData data = new SampledDataBuilder()
        .withFactor(22.6)
        .build();
    assertThat(data.getFactor())
        .as("Factor should be 22.6")
        .isNotNull()
        .extracting(BigDecimal::doubleValue)
        .isEqualTo(22.6);
  }

  @Test
  void testWithLowerLimit() {
    SampledData data = new SampledDataBuilder()
        .withLowerLimit(22.6)
        .build();
    assertThat(data.getLowerLimit())
        .as("Lower Limit should be 22.6")
        .isNotNull()
        .extracting(BigDecimal::doubleValue)
        .isEqualTo(22.6);
  }

  @Test
  void testWithUpperLimit() {
    SampledData data = new SampledDataBuilder()
        .withUpperLimit(22.6)
        .build();
    assertThat(data.getUpperLimit())
        .as("Upper Limit should be 22.6")
        .isNotNull()
        .extracting(BigDecimal::doubleValue)
        .isEqualTo(22.6);
  }

  @Test
  void testWithDimensions() {
    SampledData data = new SampledDataBuilder()
        .withDimensions(15)
        .build();
    assertThat(data.getDimensions())
        .as("Dimensions should be 15")
        .isEqualTo(15);
  }

  @Test
  void testWithData() {
    SampledData data = new SampledDataBuilder()
        .withData("My Data")
        .build();
    assertThat(data.getData())
        .as("Data should be My Data")
        .isEqualToIgnoringCase("My Data");
  }
}
