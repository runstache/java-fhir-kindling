package com.lswebworld.datatypes;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import org.hl7.fhir.r4.model.ContactPoint;
import org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem;
import org.hl7.fhir.r4.model.ContactPoint.ContactPointUse;
import org.hl7.fhir.r4.model.Period;
import org.junit.jupiter.api.Test;

class ContactPointBuilderTest {

  @Test
  void testWithSystem() {
    ContactPoint point = new ContactPointBuilder()
        .withSystem(ContactPointSystem.PHONE)
        .build();
    assertThat(point.getSystem())
        .as("System should be Phone")
        .isEqualTo(ContactPointSystem.PHONE);
  }

  @Test
  void testWithValue() {
    ContactPoint point = new ContactPointBuilder()
        .withValue("555-555-5555")
        .build();
    assertThat(point.getValue())
        .as("Value should be 555-555-5555")
        .isEqualToIgnoringCase("555-555-5555");
  }

  @Test
  void testWithUse() {
    ContactPoint point = new ContactPointBuilder()
        .withUse(ContactPointUse.HOME)
        .build();
    assertThat(point.getUse())
        .as("Contact Point Use should be Home")
        .isEqualTo(ContactPointUse.HOME);
  }

  @Test
  void testWithRank() {
    ContactPoint point = new ContactPointBuilder()
        .withRank(2)
        .build();
    assertThat(point.getRank())
        .as("Rank should be 2")
        .isEqualTo(2);
  }

  @Test
  void testWithPeriod() {
    Period period = new Period();
    period.setStart(new Date());

    ContactPoint point = new ContactPointBuilder()
        .withPeriod(period)
        .build();
    assertThat(point.getPeriod())
        .as("Period should not be null")
        .isNotNull();
    assertThat(point.getPeriod().isEmpty())
        .as("Period should not be empty")
        .isFalse();
  }
  
}
