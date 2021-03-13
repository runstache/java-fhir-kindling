package com.lswebworld.builders.datatypes;

import static org.assertj.core.api.Assertions.assertThat;

import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.ParameterDefinition;
import org.hl7.fhir.r4.model.ParameterDefinition.ParameterUse;
import org.hl7.fhir.r4.model.StringType;
import org.junit.jupiter.api.Test;

class ParameterDefinitionBuilderTest {

  @Test
  void testWithId() {
    ParameterDefinition definition = new ParameterDefinitionBuilder()
        .withId("MyId")
        .build();
    assertThat(definition.getId())
        .as("Id should be set to MyId")
        .isEqualToIgnoringCase("MyId");
  }

  @Test
  void testAddExtension() {
    Extension extension = new Extension("http://www.myextension.com");
    extension.setValue(new StringType("MyValue"));

    ParameterDefinition definition = new ParameterDefinitionBuilder()
        .addExtension(extension)
        .build();
    assertThat(definition.getExtension())
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
    ParameterDefinition definition = new ParameterDefinitionBuilder()
        .withName("MySearchItem")
        .build();
    assertThat(definition.getName())
        .as("Name should be MySearchItem")
        .isEqualToIgnoringCase("MySearchItem");
  }

  @Test
  void testWithUse() {
    ParameterDefinition definition = new ParameterDefinitionBuilder()
        .withUse(ParameterUse.IN)
        .build();
    assertThat(definition.getUse())
        .as("Use should be IN")
        .isEqualTo(ParameterUse.IN);
  }

  @Test
  void testWithMin() {
    ParameterDefinition definition = new ParameterDefinitionBuilder()
        .withMin(1)
        .build();
    assertThat(definition.getMin())
        .as("Min should be 1")
        .isEqualTo(1);
  }

  @Test
  void testWithMax() {
    ParameterDefinition definition = new ParameterDefinitionBuilder()
        .withMax("*")
        .build();
    assertThat(definition.getMax())
        .as("Max should be *")
        .isEqualToIgnoringCase("*");
  }

  @Test
  void testWithDocumentation() {
    ParameterDefinition definition = new ParameterDefinitionBuilder()
        .withDocumentation("This is a search one")
        .build();
    assertThat(definition.getDocumentation())
        .as("Documentation should be This is a search one")
        .isEqualToIgnoringCase("This is a search one");
  }

  @Test
  void testWithType() {
    ParameterDefinition definition = new ParameterDefinitionBuilder()
        .withType("Age")
        .build();
    assertThat(definition.getType())
        .as("Type should be Age")
        .isEqualToIgnoringCase("Age");
  }

  @Test
  void testWithProfile() {
    ParameterDefinition definition = new ParameterDefinitionBuilder()
        .withProfile("StructureDefinition/12345")
        .build();
    assertThat(definition.getProfile())
        .as("Profile should be StructureDefinition/12345")
        .isEqualToIgnoringCase("StructureDefinition/12345");
  }
}