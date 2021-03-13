package com.lswebworld.builders.datatypes;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.hl7.fhir.r4.model.ContactDetail;
import org.hl7.fhir.r4.model.Contributor;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.StringType;
import org.junit.jupiter.api.Test;

class ContributorBuilderTest {

  @Test
  void testWithId() {
    Contributor contributor = new ContributorBuilder()
        .withId("MyId")
        .build();
    assertThat(contributor.getId())
        .as("Id should be My Id")
        .isEqualToIgnoringCase("MyId");
  }

  @Test
  void testAddExtension() {
    Extension extension = new Extension("http://www.myextension.com");
    extension.setValue(new StringType("MyValue"));

    Contributor contributor = new ContributorBuilder()
        .addExtension(extension)
        .build();
    Assertions.assertThat(contributor.getExtension())
        .as("Extension should be set with correct values")
        .isNotEmpty()
        .allSatisfy(ext -> {
          Assertions.assertThat(ext.getUrl()).isEqualToIgnoringCase("http://www.myextension.com");
          StringType value = (StringType) ext.getValue();
          Assertions.assertThat(value.getValueAsString()).isEqualToIgnoringCase("MyValue");
        });
  }

  @Test
  void testWithType() {
    Contributor contributor = new ContributorBuilder()
        .withType(Contributor.ContributorType.AUTHOR)
        .build();
    assertThat(contributor.getType())
        .as("Contributor type should be Author")
        .isEqualTo(Contributor.ContributorType.AUTHOR);
  }

  @Test
  void testWithName() {
    Contributor contributor = new ContributorBuilder()
        .withName("JIM SMITH")
        .build();
    assertThat(contributor.getName())
        .as("Name should be Jim Smith")
        .isEqualToIgnoringCase("JIM SMITH");
  }

  @Test
  void testAddContact() {
    ContactDetail detail = new ContactDetail();
    detail.setName("JIM SMITH");
    Contributor contributor = new ContributorBuilder()
        .addContact(detail)
        .build();
    assertThat(contributor.getContact())
        .as("Contact Detail should be populated")
        .isNotEmpty()
        .allSatisfy(d -> assertThat(d.getName()).isEqualToIgnoringCase("JIM SMITH"));
  }
}