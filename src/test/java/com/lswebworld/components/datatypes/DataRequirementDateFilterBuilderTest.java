package com.lswebworld.components.datatypes;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import org.hl7.fhir.r4.model.DataRequirement.DataRequirementDateFilterComponent;
import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.Duration;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.Period;
import org.hl7.fhir.r4.model.StringType;
import org.junit.jupiter.api.Test;

class DataRequirementDateFilterBuilderTest {

  @Test
  void withId() {
    DataRequirementDateFilterComponent component = new DataRequirementDateFilterBuilder()
        .withId("MyId")
        .build();
    assertThat(component.getId())
        .as("Id should be MyId")
        .isEqualToIgnoringCase("MyId");
  }

  @Test
  void addExtension() {
    Extension extension = new Extension("http://www.myextension.com");
    extension.setValue(new StringType("MyValue"));

    DataRequirementDateFilterComponent component = new DataRequirementDateFilterBuilder()
        .addExtension(extension)
        .build();
    assertThat(component.getExtension())
        .as("Extension should be set with correct values")
        .isNotEmpty()
        .allSatisfy(ext -> {
          assertThat(ext.getUrl()).isEqualToIgnoringCase("http://www.myextension.com");
          StringType value = (StringType) ext.getValue();
          assertThat(value.getValueAsString()).isEqualToIgnoringCase("MyValue");
        });
  }

  @Test
  void withPath() {
    DataRequirementDateFilterComponent component = new DataRequirementDateFilterBuilder()
        .withPath("Patient.Dob")
        .build();
    assertThat(component.getPath())
        .as("Path should be Patient.Dob")
        .isEqualToIgnoringCase("Patient.Dob");
  }

  @Test
  void withSearchParam() {
    DataRequirementDateFilterComponent component = new DataRequirementDateFilterBuilder()
        .withSearchParam("Dob")
        .build();
    assertThat(component.getSearchParam())
        .as("Search Param should be Dob")
        .isEqualToIgnoringCase("Dob");
  }

  @Test
  void testWithValueDate() {
    DataRequirementDateFilterComponent component = new DataRequirementDateFilterBuilder()
        .withValue(new Date())
        .build();
    assertThat(component.getValue())
        .as("Value should be a DateTimeType")
        .isInstanceOf(DateTimeType.class)
        .extracting(DateTimeType.class::cast)
        .extracting(DateTimeType::getValue)
        .isNotNull();
  }

  @Test
  void testWithValueLocalDateTime() {
    DataRequirementDateFilterComponent component = new DataRequirementDateFilterBuilder()
        .withValue(LocalDateTime.now(), ZoneOffset.UTC)
        .build();
    assertThat(component.getValue())
        .as("Value should be a DateTimeType")
        .isInstanceOf(DateTimeType.class)
        .extracting(DateTimeType.class::cast)
        .extracting(DateTimeType::getValue)
        .isNotNull();

  }

  @Test
  void testWithValuePeriod() {
    Period period = new Period();
    period.setStart(new Date());
    period.setEnd(new Date());

    DataRequirementDateFilterComponent component = new DataRequirementDateFilterBuilder()
        .withValue(period)
        .build();
    assertThat(component.getValue())
        .as("Value should be a Period")
        .isInstanceOf(Period.class)
        .extracting(Period.class::cast)
        .extracting(Period::isEmpty)
        .isEqualTo(false);
  }

  @Test
  void testWithValueDuration() {
    Duration duration = new Duration();
    duration.setValue(25.6);
    DataRequirementDateFilterComponent component = new DataRequirementDateFilterBuilder()
        .withValue(duration)
        .build();
    assertThat(component.getValue())
        .as("Value should be a Duration")
        .isInstanceOf(Duration.class)
        .extracting(Duration.class::cast)
        .extracting(Duration::getValue)
        .extracting(BigDecimal::doubleValue)
        .isEqualTo(25.6);
  }
}