package com.lswebworld.builders.datatypes;

import static org.assertj.core.api.Assertions.assertThat;

import org.hl7.fhir.r4.model.ContactDetail;
import org.hl7.fhir.r4.model.ContactPoint;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.StringType;
import org.junit.jupiter.api.Test;

class ContactDetailBuilderTest {

  @Test
  void testWithId() {
    ContactDetail detail = new ContactDetailBuilder()
        .withId("MyId")
        .build();
    assertThat(detail.getId())
        .as("Id should be MyId")
        .isEqualToIgnoringCase("MyId");
  }

  @Test
  void testAddExtension() {
    Extension extension = new Extension("http://www.myextension.com");
    extension.setValue(new StringType("MyValue"));

    ContactDetail detail = new ContactDetailBuilder()
        .addExtension(extension)
        .build();
    assertThat(detail.getExtension())
        .as("Extension should be set with correct values")
        .isNotEmpty()
        .allSatisfy(ext -> {
          assertThat(ext.getUrl()).isEqualToIgnoringCase("http://www.myextension.com");
          StringType value = (StringType) ext.getValue();
          assertThat(value.getValueAsString()).isEqualToIgnoringCase("MyValue");
        });
  }

  @Test
  void testWithName() {
    ContactDetail detail = new ContactDetailBuilder()
        .withName("JIM SMITH")
        .build();
    assertThat(detail.getName())
        .as("Name should be JIM SMITH")
        .isEqualToIgnoringCase("JIM SMITH");
  }

  @Test
  void testAddTelecom() {
    ContactPoint contact = new ContactPoint();
    contact.setValue("555-555-5555");
    contact.setSystem(ContactPoint.ContactPointSystem.PHONE);
    ContactDetail detail = new ContactDetailBuilder()
        .addTelecom(contact)
        .build();
    assertThat(detail.getTelecom())
        .as("Telecom should be populated")
        .isNotEmpty()
        .allSatisfy(cp -> {
          assertThat(cp.getValue()).isEqualToIgnoringCase("555-555-5555");
          assertThat(cp.getSystem()).isEqualTo(ContactPoint.ContactPointSystem.PHONE);
        });
  }
}