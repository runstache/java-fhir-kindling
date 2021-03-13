package com.lswebworld.builders.components.datatypes;

import static org.assertj.core.api.Assertions.assertThat;

import org.hl7.fhir.r4.model.DataRequirement;
import org.hl7.fhir.r4.model.DataRequirement.DataRequirementSortComponent;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.StringType;
import org.junit.jupiter.api.Test;

class DataRequirementSortFilterBuilderTest {

  @Test
  void withId() {
    DataRequirementSortComponent component = new DataRequirementSortFilterBuilder()
        .withId("MyId")
        .build();
    assertThat(component.getId())
        .as("Id should be MyId")
        .isEqualToIgnoringCase("MyId");
  }

  @Test
  void addExtension() {
    Extension extension = new Extension("http://www.myextension.com");
    extension.setValue(new StringType("MyValue"));

    DataRequirementSortComponent component = new DataRequirementSortFilterBuilder()
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
  void withPath() {
    DataRequirementSortComponent component = new DataRequirementSortFilterBuilder()
        .withPath("Patient.Dob")
        .build();
    assertThat(component.getPath())
        .as("Path should be Patient.Dob")
        .isEqualToIgnoringCase("Patient.Dob");
  }

  @Test
  void withDirection() {
    DataRequirementSortComponent component = new DataRequirementSortFilterBuilder()
        .withDirection(DataRequirement.SortDirection.ASCENDING)
        .build();
    assertThat(component.getDirection())
        .as("Sort Direction should be Ascending")
        .isEqualTo(DataRequirement.SortDirection.ASCENDING);
  }

  @Test
  void ascending() {
    DataRequirementSortComponent component = new DataRequirementSortFilterBuilder()
        .ascending()
        .build();

    assertThat(component.getDirection())
        .as("Sort Direction should be Ascending")
        .isEqualTo(DataRequirement.SortDirection.ASCENDING);
  }

  @Test
  void descending() {
    DataRequirementSortComponent component = new DataRequirementSortFilterBuilder()
        .descending()
        .build();

    assertThat(component.getDirection())
        .as("Sort Direction should be Descending")
        .isEqualTo(DataRequirement.SortDirection.DESCENDING);
  }
}