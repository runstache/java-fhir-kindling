package com.lswebworld.datatypes;

import static org.assertj.core.api.Assertions.assertThat;

import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.StringType;
import org.junit.jupiter.api.Test;

class ExtensionBuilderTest {

  @Test
  void testWithId() {
    Extension extension = new ExtensionBuilder()
        .withId("MyId")
        .build();
    assertThat(extension.getId())
        .as("Id should be MyId")
        .isEqualToIgnoringCase("MyId");
  }

  @Test
  void testAddExtension() {
    Extension extension = new Extension("http://www.myextension.com");
    extension.setValue(new StringType("MyValue"));

    Extension data = new ExtensionBuilder()
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
  void testWithUrl() {
    Extension extension = new ExtensionBuilder()
        .withUrl("http://myextension.org")
        .build();
    assertThat(extension.getUrl())
        .as("Url should be http://myextension.org")
        .isEqualToIgnoringCase("http://myextension.org");
  }

  @Test
  void testWithValue() {
    Extension extension = new ExtensionBuilder()
        .withValue(new StringType("MyTextValue"))
        .build();
    assertThat(extension.getValue())
        .as("Value should be My Text Value")
        .isInstanceOf(StringType.class)
        .extracting(StringType.class::cast)
        .extracting(StringType::getValueAsString)
        .isEqualTo("MyTextValue");
  }
}