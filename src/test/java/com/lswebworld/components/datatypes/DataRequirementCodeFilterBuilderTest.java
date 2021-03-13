package com.lswebworld.components.datatypes;

import static org.assertj.core.api.Assertions.assertThat;

import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.DataRequirement.DataRequirementCodeFilterComponent;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.StringType;
import org.junit.jupiter.api.Test;

class DataRequirementCodeFilterBuilderTest {

  @Test
  void testWithId() {
    DataRequirementCodeFilterComponent component = new DataRequirementCodeFilterBuilder()
        .withId("MyId")
        .build();
    assertThat(component.getId())
        .as("Id should be MyId")
        .isEqualToIgnoringCase("MyId");
  }

  @Test
  void testAddExtension() {
    Extension extension = new Extension("http://www.myextension.com");
    extension.setValue(new StringType("MyValue"));

    DataRequirementCodeFilterComponent component = new DataRequirementCodeFilterBuilder()
        .addExtension(extension)
        .build();
    assertThat(component.getExtension())
        .as("Extension should be set with correct values")
        .isNotEmpty()
        .allSatisfy(ext -> {
          assertThat(ext.getUrl()).isEqualToIgnoringCase("http://www.myextension.com");
          StringType value = (StringType) ext.getValue();
          assertThat(value.getValueAsString()).isEqualToIgnoringCase("MyValue");
        });
  }

  @Test
  void testWithPath() {
    DataRequirementCodeFilterComponent component = new DataRequirementCodeFilterBuilder()
        .withPath("Patient.Name")
        .build();
    assertThat(component.getPath())
        .as("Path should be Patient.Name")
        .isEqualToIgnoringCase("Patient.Name");
  }

  @Test
  void testWithSearchParam() {
    DataRequirementCodeFilterComponent component = new DataRequirementCodeFilterBuilder()
        .withSearchParam("System|Code")
        .build();
    assertThat(component.getSearchParam())
        .as("Search Param should be System|Code")
        .isEqualToIgnoringCase("System|Code");
  }

  @Test
  void testWithValueSet() {
    DataRequirementCodeFilterComponent component = new DataRequirementCodeFilterBuilder()
        .withValueSet("ValueSet/2348767")
        .build();
    assertThat(component.getValueSet())
        .as("ValueSet should be ValueSet/2348767")
        .isEqualToIgnoringCase("ValueSet/2348767");
  }

  @Test
  void testAddCode() {
    DataRequirementCodeFilterComponent component = new DataRequirementCodeFilterBuilder()
        .addCode(new Coding("MY.CODE.OID", "MY_CODE", "CODE DISPLAY"))
        .build();
    assertThat(component.getCode())
        .as("Code should be populated")
        .isNotEmpty()
        .allSatisfy(code ->
            assertThat(code)
                .extracting("system", "code", "display")
                .containsOnly("MY.CODE.OID", "MY_CODE", "CODE DISPLAY"));
  }
}