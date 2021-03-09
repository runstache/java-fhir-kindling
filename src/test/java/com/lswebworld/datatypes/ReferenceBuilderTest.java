package com.lswebworld.datatypes;

import static org.assertj.core.api.Assertions.assertThat;

import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.StringType;
import org.junit.jupiter.api.Test;

class ReferenceBuilderTest {

  @Test
  void testWithId() {
    Reference reference = new ReferenceBuilder()
        .withId("MyId")
        .build();
    assertThat(reference.getId())
        .as("Id should be MyId")
        .isEqualToIgnoringCase("MyId");

  }

  @Test
  void testAddExtension() {
    Extension extension = new Extension("http://www.myextension.com");
    extension.setValue(new StringType("MyValue"));

    Reference reference = new ReferenceBuilder()
        .addExtension(extension)
        .build();
    assertThat(reference.getExtension())
        .as("Extension should be set with correct values")
        .isNotEmpty()
        .allSatisfy(ext -> {
          assertThat(ext.getUrl()).isEqualToIgnoringCase("http://www.myextension.com");
          StringType value = (StringType) ext.getValue();
          assertThat(value.getValueAsString()).isEqualToIgnoringCase("MyValue");
        });
  }

  @Test
  void testWithReference() {
    Reference reference = new ReferenceBuilder()
        .withReference("/patient/1234")
        .build();
    assertThat(reference.getReference())
        .as("Reference should be /patient/1234")
        .isEqualToIgnoringCase("/patient/1234");
  }

  @Test
  void testWithType() {
    Reference reference = new ReferenceBuilder()
        .withType("Patient")
        .build();
    assertThat(reference.getType())
        .as("Type should be Patient")
        .isEqualToIgnoringCase("Patient");
  }

  @Test
  void testWithIdentifier() {
    Identifier id = new Identifier();
    id.setSystem("MY.PATIENT.OID");
    id.setValue("1234");

    Reference reference = new ReferenceBuilder()
        .withIdentifier(id)
        .build();
    assertThat(reference.getIdentifier())
        .as("Identifer should have the correct System and Value")
        .extracting("system", "value")
        .containsOnly("MY.PATIENT.OID", "1234");
  }

  @Test
  void testWithDisplay() {
    Reference reference = new ReferenceBuilder()
        .withDisplay("MY Patient")
        .build();
    assertThat(reference.getDisplay())
        .as("Display should be MY Patient")
        .isEqualToIgnoringCase("MY Patient");
  }

}
