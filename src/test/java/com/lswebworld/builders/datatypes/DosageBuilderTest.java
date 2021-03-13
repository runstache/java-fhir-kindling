package com.lswebworld.builders.datatypes;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Date;
import org.hl7.fhir.r4.model.BooleanType;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Dosage;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.Quantity;
import org.hl7.fhir.r4.model.Ratio;
import org.hl7.fhir.r4.model.StringType;
import org.hl7.fhir.r4.model.Timing;
import org.junit.jupiter.api.Test;

class DosageBuilderTest {

  @Test
  void testAddModifierExtension() {
    Extension extension = new Extension("http://www.myextension.com");
    extension.setValue(new StringType("MyValue"));

    Dosage dosage = new DosageBuilder()
        .addModifierExtension(extension)
        .build();
    assertThat(dosage.getModifierExtension())
        .as("Extension should be set with correct values")
        .isNotEmpty()
        .allSatisfy(ext -> {
          assertThat(ext.getUrl()).isEqualToIgnoringCase("http://www.myextension.com");
          StringType value = (StringType) ext.getValue();
          assertThat(value.getValueAsString()).isEqualToIgnoringCase("MyValue");
        });
  }

  @Test
  void testWithId() {
    Dosage dosage = new DosageBuilder()
        .withId("MyId")
        .build();
    assertThat(dosage.getId())
        .as("Id should be MyId")
        .isEqualToIgnoringCase("MyId");
  }

  @Test
  void testAddExtension() {
    Extension extension = new Extension("http://www.myextension.com");
    extension.setValue(new StringType("MyValue"));

    Dosage dosage = new DosageBuilder()
        .addExtension(extension)
        .build();
    assertThat(dosage.getExtension())
        .as("Extension should be set with correct values")
        .isNotEmpty()
        .allSatisfy(ext -> {
          assertThat(ext.getUrl()).isEqualToIgnoringCase("http://www.myextension.com");
          StringType value = (StringType) ext.getValue();
          assertThat(value.getValueAsString()).isEqualToIgnoringCase("MyValue");
        });
  }

  @Test
  void testWithSequence() {
    Dosage dosage = new DosageBuilder()
        .withSequence(2)
        .build();
    assertThat(dosage.getSequence())
        .as("Sequence should be 2")
        .isEqualTo(2);
  }

  @Test
  void testWithText() {
    Dosage dosage = new DosageBuilder()
        .withText("My Instructions")
        .build();
    assertThat(dosage.getText())
        .as("Text should be My Instructions")
        .isEqualToIgnoringCase("My Instructions");
  }

  @Test
  void testAddAdditionalInstruction() {
    CodeableConcept concept = new CodeableConcept();
    concept.setText("My Code Text");
    Dosage dosage = new DosageBuilder()
        .addAdditionalInstruction(concept)
        .build();
    assertThat(dosage.getAdditionalInstruction())
        .as("Additional Instructions should be populated")
        .isNotEmpty()
        .allSatisfy(code -> assertThat(code.getText()).isEqualToIgnoringCase("My Code Text"));
  }

  @Test
  void testWithPatientInstruction() {
    Dosage dosage = new DosageBuilder()
        .withPatientInstruction("My Patient Instructions")
        .build();
    assertThat(dosage.getPatientInstruction())
        .as("Patient Instructions should be My Patient Instructions")
        .isEqualToIgnoringCase("My Patient Instructions");
  }

  @Test
  void testWithTiming() {
    Timing timing = new Timing();
    timing.addEvent(new Date());
    Dosage dosage = new DosageBuilder()
        .withTiming(timing)
        .build();
    assertThat(dosage.getTiming().isEmpty())
        .as("Timing should not be empty")
        .isFalse();
    assertThat(dosage.getTiming().getEvent())
        .as("Dosage Timing Event should not be empty")
        .isNotEmpty();
  }

  @Test
  void testWithAsNeededBoolean() {
    Dosage dosage = new DosageBuilder()
        .withAsNeeded(true)
        .build();
    assertThat(dosage.getAsNeeded())
        .as("As Needed should be true")
        .isInstanceOf(BooleanType.class)
        .extracting(BooleanType.class::cast)
        .extracting(BooleanType::booleanValue)
        .isEqualTo(true);
  }

  @Test
  void testWithAsNeededCodeableConcept() {
    CodeableConcept concept = new CodeableConcept();
    concept.setText("My Concept Text");
    Dosage dosage = new DosageBuilder()
        .withAsNeeded(concept)
        .build();

    assertThat(dosage.getAsNeeded())
        .as("Codeable Concept Text should be My Concept Text")
        .isInstanceOf(CodeableConcept.class)
        .extracting(CodeableConcept.class::cast)
        .extracting(CodeableConcept::getText)
        .isEqualTo("My Concept Text");
  }

  @Test
  void testWithSite() {
    CodeableConcept concept = new CodeableConcept();
    concept.setText("My Concept Text");
    Dosage dosage = new DosageBuilder()
        .withSite(concept)
        .build();
    assertThat(dosage.getSite())
        .as("Codeable Concept Text should be My Concept Text")
        .extracting(CodeableConcept.class::cast)
        .extracting(CodeableConcept::getText)
        .isEqualTo("My Concept Text");

  }

  @Test
  void testWithRoute() {
    CodeableConcept concept = new CodeableConcept();
    concept.setText("My Concept Text");
    Dosage dosage = new DosageBuilder()
        .withRoute(concept)
        .build();
    assertThat(dosage.getRoute())
        .as("Codeable Concept Text should be My Concept Text")
        .extracting(CodeableConcept.class::cast)
        .extracting(CodeableConcept::getText)
        .isEqualTo("My Concept Text");

  }

  @Test
  void testWithMethod() {
    CodeableConcept concept = new CodeableConcept();
    concept.setText("My Concept Text");
    Dosage dosage = new DosageBuilder()
        .withMethod(concept)
        .build();
    assertThat(dosage.getMethod())
        .as("Codeable Concept Text should be My Concept Text")
        .extracting(CodeableConcept.class::cast)
        .extracting(CodeableConcept::getText)
        .isEqualTo("My Concept Text");
  }

  @Test
  void testAddDoseAndRate() {
    CodeableConcept concept = new CodeableConcept();
    concept.setText("My Concept Text");
    Dosage.DosageDoseAndRateComponent component = new Dosage.DosageDoseAndRateComponent();
    component.setType(concept);
    Dosage dosage = new DosageBuilder()
        .addDoseAndRate(component)
        .build();
    assertThat(dosage.getDoseAndRate())
        .as("Dose and Rate should be populated")
        .isNotEmpty()
        .allSatisfy(dose -> {
          assertThat(dose.isEmpty())
              .isFalse();
          assertThat(dose.getType())
              .extracting(CodeableConcept::getText)
              .isEqualTo("My Concept Text");
        });
  }

  @Test
  void testWithMaxDosePerPeriod() {
    Quantity quantity = new Quantity();
    quantity.setValue(25.6);
    Ratio ratio = new Ratio();
    ratio.setNumerator(quantity);
    ratio.setDenominator(quantity);

    Dosage dosage = new DosageBuilder()
        .withMaxDosePerPeriod(ratio)
        .build();
    assertThat(dosage.getMaxDosePerPeriod())
        .as("Max Dose Period denominator should be 25.6")
        .extracting(Ratio::getDenominator)
        .extracting(Quantity::getValue)
        .isNotNull()
        .extracting(BigDecimal::doubleValue)
        .isEqualTo(25.6);
    assertThat(dosage.getMaxDosePerPeriod())
        .as("Max Dose Period numeratorshould be 25.6")
        .extracting(Ratio::getNumerator)
        .extracting(Quantity::getValue)
        .extracting(BigDecimal::doubleValue)
        .isEqualTo(25.6);
  }

  @Test
  void testWithMaxDosePerAdministration() {
    Quantity quantity = new Quantity();
    quantity.setValue(25.4);

    Dosage dosage = new DosageBuilder()
        .withMaxDosePerAdministration(quantity)
        .build();
    assertThat(dosage.getMaxDosePerAdministration())
        .as("Max Dose Administration should be 25.4")
        .extracting(Quantity::getValue)
        .isNotNull()
        .extracting(BigDecimal::doubleValue)
        .isEqualTo(25.4);
  }

  @Test
  void testWithMaxDosePerLifetime() {
    Quantity quantity = new Quantity();
    quantity.setValue(25.4);

    Dosage dosage = new DosageBuilder()
        .withMaxDosePerLifetime(quantity)
        .build();
    assertThat(dosage.getMaxDosePerLifetime())
        .as("Max Dose Per Lifetime should be 25.4")
        .extracting(Quantity::getValue)
        .isNotNull()
        .extracting(BigDecimal::doubleValue)
        .isEqualTo(25.4);
  }
}