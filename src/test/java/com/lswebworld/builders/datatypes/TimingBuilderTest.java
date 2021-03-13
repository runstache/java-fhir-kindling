package com.lswebworld.builders.datatypes;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.StringType;
import org.hl7.fhir.r4.model.Timing;
import org.junit.jupiter.api.Test;

class TimingBuilderTest {

  @Test
  void testAddModifierExtension() {
    Extension extension = new Extension("http://myextension.org");
    extension.setValue(new StringType("MyStringValue"));

    Timing timing = new TimingBuilder()
        .addModifierExtension(extension)
        .build();

    assertThat(timing.getModifierExtension())
        .as("Modifier Extension should be set")
        .isNotEmpty()
        .allSatisfy(ext -> {
          assertThat(ext.getUrl()).isEqualToIgnoringCase("http://myextension.org");
          assertThat(ext.getValue())
              .extracting(StringType.class::cast)
              .extracting(StringType::getValueAsString)
              .isEqualTo("MyStringValue");
        });
  }

  @Test
  void testWithId() {
    Timing timing = new TimingBuilder()
        .withId("MyId")
        .build();
    assertThat(timing.getId())
        .as("Id should be My Id")
        .isEqualToIgnoringCase("MyId");
  }

  @Test
  void testAddExtension() {
    Extension extension = new Extension("http://myextension.org");
    extension.setValue(new StringType("MyStringValue"));

    Timing timing = new TimingBuilder()
        .addExtension(extension)
        .build();

    assertThat(timing.getExtension())
        .as("Modifier Extension should be set")
        .isNotEmpty()
        .allSatisfy(ext -> {
          assertThat(ext.getUrl()).isEqualToIgnoringCase("http://myextension.org");
          assertThat(ext.getValue())
              .extracting(StringType.class::cast)
              .extracting(StringType::getValueAsString)
              .isEqualTo("MyStringValue");
        });
  }

  @Test
  void testAddEventDate() {
    Timing timing = new TimingBuilder()
        .addEvent(new Date())
        .build();
    assertThat(timing.getEvent())
        .as("Event should not be empty")
        .isNotEmpty()
        .hasSize(1);
  }

  @Test
  void testAddEventLocalDateTime() {
    Timing timing = new TimingBuilder()
        .addEvent(LocalDateTime.now(), ZoneOffset.UTC)
        .build();
    assertThat(timing.getEvent())
        .as("Event should not be empty")
        .isNotEmpty()
        .hasSize(1);
  }

  @Test
  void testWithRepeat() {
    Timing.TimingRepeatComponent component = new Timing.TimingRepeatComponent();
    component.setCount(25);

    Timing timing = new TimingBuilder()
        .withRepeat(component)
        .build();
    assertThat(timing.getRepeat())
        .as("Repeat should have a count of 25")
        .extracting(Timing.TimingRepeatComponent::getCount)
        .isEqualTo(25);
  }

  @Test
  void testWithCode() {
    CodeableConcept concept = new CodeableConcept();
    concept.addCoding(new Coding("TEST.CODE.OID", "MYCODE", "My Code Display"));

    Timing timing = new TimingBuilder()
        .withCode(concept)
        .build();
    assertThat(timing.getCode())
        .as("Code should not be empty")
        .extracting(CodeableConcept::isEmpty)
        .isNotEqualTo(true);
    assertThat(timing.getCode().getCoding())
        .as("Coding should not be empty")
        .isNotEmpty()
        .allSatisfy(code -> {
          assertThat(code.getSystem()).isEqualToIgnoringCase("TEST.CODE.OID");
          assertThat(code.getCode()).isEqualToIgnoringCase("MYCODE");
          assertThat(code.getDisplay()).isEqualToIgnoringCase("My Code Display");
        });

  }
}