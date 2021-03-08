package com.lswebworld.datatypes;

import static org.assertj.core.api.Assertions.assertThat;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.StringType;
import org.junit.jupiter.api.Test;


class CodeableConceptBuilderTest {

  @Test
  void testWithId() {

    CodeableConcept concept = new CodeableConceptBuilder()
        .withId("MyId")
        .build();
    assertThat(concept.getId())
        .as("Id should be MyId")
        .isEqualToIgnoringCase("MyId");

  }

  @Test
  void testAddExtension() {
    Extension extension = new Extension("http://myextension.org");
    StringType value = new StringType("MyValue");
    extension.setValue(value);

    CodeableConcept concept = new CodeableConceptBuilder()
        .addExtension(extension)
        .build();

    assertThat(concept.getExtension())
        .as("Extension should be populated")
        .isNotEmpty()
        .allSatisfy(ext -> {
          assertThat(ext.getUrl()).isEqualToIgnoringCase("http://myextension.org");
          assertThat(ext.getValue())
              .extracting(StringType.class::cast)
              .extracting(StringType::getValueAsString)
              .isEqualTo("MyValue");
              
        });
  }

  @Test
  void testAddCoding() {
    CodeableConcept concept = new CodeableConceptBuilder()
        .addCoding(new Coding("MY.CODE.OID", "CODE", "DISPLAY VALUE"))
        .build();
    assertThat(concept.getCoding())
        .as("Coding should be populated")
        .isNotEmpty()
        .allSatisfy(coding -> {
          assertThat(coding.getSystem()).isEqualToIgnoringCase("MY.CODE.OID");
          assertThat(coding.getCode()).isEqualToIgnoringCase("CODE");
          assertThat(coding.getDisplay()).isEqualToIgnoringCase("DISPLAY VALUE");
        });
  }

  @Test
  void testWithText() {
    CodeableConcept concept = new CodeableConceptBuilder()
        .withText("My Text Value")
        .build();
    assertThat(concept.getText())
        .as("Text should by My Text Value")
        .isEqualToIgnoringCase("My Text Value");
  }
  
}
