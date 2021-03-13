package com.lswebworld.builders.datatypes;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import org.hl7.fhir.r4.model.DataRequirement;
import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.Expression;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.StringType;
import org.hl7.fhir.r4.model.Timing;
import org.hl7.fhir.r4.model.TriggerDefinition;
import org.hl7.fhir.r4.model.TriggerDefinition.TriggerType;
import org.junit.jupiter.api.Test;

class TriggerDefinitionBuilderTest {

  @Test
  void testWithId() {
    TriggerDefinition trigger = new TriggerDefinitionBuilder()
        .withId("MyId")
        .build();
    assertThat(trigger.getId())
        .as("Id should be MyId")
        .isEqualToIgnoringCase("MyId");
  }

  @Test
  void testAddExtension() {
    Extension extension = new Extension("http://www.myextension.com");
    extension.setValue(new StringType("MyValue"));

    TriggerDefinition trigger = new TriggerDefinitionBuilder()
        .addExtension(extension)
        .build();
    assertThat(trigger.getExtension())
        .as("Extension should be set with correct values")
        .isNotEmpty()
        .allSatisfy(ext -> {
          assertThat(ext.getUrl()).isEqualToIgnoringCase("http://www.myextension.com");
          StringType value = (StringType) ext.getValue();
          assertThat(value.getValueAsString()).isEqualToIgnoringCase("MyValue");
        });
  }

  @Test
  void testWithType() {
    TriggerDefinition trigger = new TriggerDefinitionBuilder()
        .withType(TriggerType.PERIODIC)
        .build();
    assertThat(trigger.getType())
        .as("Type should be Periodic")
        .isEqualTo(TriggerType.PERIODIC);

  }

  @Test
  void testWithName() {
    TriggerDefinition trigger = new TriggerDefinitionBuilder()
        .withName("My Trigger")
        .build();
    assertThat(trigger.getName())
        .as("Name should be My Trigger")
        .isEqualToIgnoringCase("My Trigger");
  }

  @Test
  void testWithTiming() {
    Timing timing = new Timing();
    timing.addEvent(new Date());

    TriggerDefinition trigger = new TriggerDefinitionBuilder()
        .withTiming(timing)
        .build();
    assertThat(trigger.getTiming())
        .as("Trigger Timing should be a Timing type")
        .isInstanceOf(Timing.class)
        .extracting(Timing.class::cast)
        .extracting(Timing::isEmpty)
        .isEqualTo(false);
  }

  @Test
  void testWithTimingReference() {
    Reference reference = new Reference("Schedule/1234");
    TriggerDefinition trigger = new TriggerDefinitionBuilder()
        .withTiming(reference)
        .build();
    assertThat(trigger.getTiming())
        .as("Timing should be a Reference")
        .isInstanceOf(Reference.class)
        .extracting(Reference.class::cast)
        .extracting(Reference::getReference)
        .isEqualTo("Schedule/1234");
  }

  @Test
  void testWithTimingDate() {
    TriggerDefinition trigger = new TriggerDefinitionBuilder()
        .withTiming(new Date())
        .build();
    assertThat(trigger.getTiming())
        .as("Timing should be a DateTimeType")
        .isInstanceOf(DateTimeType.class)
        .extracting(DateTimeType.class::cast)
        .extracting(DateTimeType::getValue)
        .isNotNull();
  }

  @Test
  void testWithTimingLocalDateTime() {
    TriggerDefinition trigger = new TriggerDefinitionBuilder()
        .withTiming(LocalDateTime.now(), ZoneOffset.UTC)
        .build();
    assertThat(trigger.getTiming())
        .as("Timing should be a Date Time Type")
        .isInstanceOf(DateTimeType.class)
        .extracting(DateTimeType.class::cast)
        .extracting(DateTimeType::getValue)
        .isNotNull();
  }

  @Test
  void testAddData() {
    DataRequirement requirement = new DataRequirement();
    requirement.setLimit(2);
    TriggerDefinition trigger = new TriggerDefinitionBuilder()
        .addData(requirement)
        .build();
    assertThat(trigger.getData())
        .as("Data should contain the Requirement")
        .isNotEmpty()
        .allSatisfy(data -> assertThat(data.getLimit()).isEqualTo(2));
  }

  @Test
  void testWithCondition() {
    Expression expression = new Expression();
    expression.setLanguage("cql");

    TriggerDefinition trigger = new TriggerDefinitionBuilder()
        .withCondition(expression)
        .build();
    assertThat(trigger.getCondition())
        .as("Condition should be populated")
        .extracting(Expression::getLanguage)
        .isEqualTo("cql");
  }
}