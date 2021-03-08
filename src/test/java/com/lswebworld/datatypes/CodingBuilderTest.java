package com.lswebworld.datatypes;

import static org.assertj.core.api.Assertions.assertThat;

import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.StringType;
import org.junit.jupiter.api.Test;

class CodingBuilderTest {

  @Test
  void testWithId() {

    Coding coding = new CodingBuilder()
        .withId("MyId")
        .build();
    assertThat(coding.getId())
        .as("Id should be MyId")
        .isEqualToIgnoringCase("MyId");

  }

  @Test
  void testAddExtension() {
    Extension extension = new Extension("http://myextension.org");
    StringType value = new StringType("MyValue");
    extension.setValue(value);

    Coding coding = new CodingBuilder()
        .addExtension(extension)
        .build();

    assertThat(coding.getExtension())
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
  void testWithSystem() {
    Coding coding = new CodingBuilder()
        .withSystem("MY.CODE.OID")
        .build();
    assertThat(coding.getSystem())
        .as("Coding System should be MY.CODE.OID")
        .isEqualToIgnoringCase("MY.CODE.OID");
  }

  @Test
  void testWithVersion() {
    Coding coding = new CodingBuilder()
        .withVersion("v2.0")
        .build();
    assertThat(coding.getVersion())
        .as("Coding Version should be v2.0")
        .isEqualToIgnoringCase("v2.0");
  }

  @Test
  void testWithCode() {
    Coding coding = new CodingBuilder()
        .withCode("MYCODE")
        .build();
    assertThat(coding.getCode())
        .as("Code value should by MYCODE")
        .isEqualToIgnoringCase("MYCODE");
  }

  @Test
  void testWithDisplay() {
    Coding coding = new CodingBuilder()
        .withDisplay("MY CODE DISPLAY")
        .build();
    assertThat(coding.getDisplay())
        .as("Display Value should be MY CODE DISPLAY")
        .isEqualToIgnoringCase("MY CODE DISPLAY");
  }

  @Test
  void testWithUserSelected() {
    Coding coding = new CodingBuilder()
        .withUserSelected(true)
        .build();
    assertThat(coding.getUserSelected())
        .as("User Selected should be True")
        .isTrue();
  }
  
}
