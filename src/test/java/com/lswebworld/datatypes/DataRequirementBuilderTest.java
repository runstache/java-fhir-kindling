package com.lswebworld.datatypes;

import static org.assertj.core.api.Assertions.assertThat;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.DataRequirement;
import org.hl7.fhir.r4.model.DataRequirement.DataRequirementCodeFilterComponent;
import org.hl7.fhir.r4.model.DataRequirement.DataRequirementDateFilterComponent;
import org.hl7.fhir.r4.model.DataRequirement.DataRequirementSortComponent;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.StringType;
import org.junit.jupiter.api.Test;

class DataRequirementBuilderTest {

  @Test
  void testWithId() {
    DataRequirement requirement = new DataRequirementBuilder()
        .withId("MyId")
        .build();
    assertThat(requirement.getId())
        .as("Id should be MyId")
        .isEqualToIgnoringCase("MyId");
  }

  @Test
  void testAddExtension() {
    Extension extension = new Extension("http://www.myextension.com");
    extension.setValue(new StringType("MyValue"));

    DataRequirement data = new DataRequirementBuilder()
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
  void testWithType() {
    DataRequirement requirement = new DataRequirementBuilder()
        .withType("ACCOUNT")
        .build();
    assertThat(requirement.getType())
        .as("Type should be ACCOUNT")
        .isEqualToIgnoringCase("ACCOUNT");
  }

  @Test
  void testAddProfile() {
    DataRequirement requirement = new DataRequirementBuilder()
        .addProfile("http://fhir/StructureDefinition/1234")
        .build();
    assertThat(requirement.getProfile())
        .as("Profile should contain http://fhir/StructureDefinition/1234")
        .isNotEmpty()
        .allSatisfy(c -> assertThat(c.getValue())
            .isEqualToIgnoringCase("http://fhir/StructureDefinition/1234"));
  }

  @Test
  void testWithSubjectCodeableConcept() {
    CodeableConcept concept = new CodeableConcept();
    concept.setText("My Subject Text");
    DataRequirement requirement = new DataRequirementBuilder()
        .withSubject(concept)
        .build();
    assertThat(requirement.getSubject())
        .as("Subject should be a Codeable Concept.")
        .isInstanceOf(CodeableConcept.class)
        .extracting(CodeableConcept.class::cast)
        .extracting(CodeableConcept::getText)
        .isEqualTo("My Subject Text");
  }

  @Test
  void testWithSubjectReference() {
    Reference reference = new Reference();
    reference.setReference("/Group/1234");

    DataRequirement requirement = new DataRequirementBuilder()
        .withSubject(reference)
        .build();
    assertThat(requirement.getSubject())
        .as("Requirement should be a Reference")
        .isInstanceOf(Reference.class)
        .extracting(Reference.class::cast)
        .extracting(Reference::getReference)
        .isEqualTo("/Group/1234");
  }

  @Test
  void testAddMustSupport() {
    DataRequirement requirement = new DataRequirementBuilder()
        .addMustSupport("name")
        .build();
    assertThat(requirement.getMustSupport())
        .as("Must Support should contain Name")
        .isNotEmpty()
        .allSatisfy(st -> assertThat(st.getValueAsString()).isEqualToIgnoringCase("name"));
  }

  @Test
  void testAddCodeFilter() {
    DataRequirementCodeFilterComponent component = new DataRequirementCodeFilterComponent();
    component.setPath("Patient/Name");
    DataRequirement requirement = new DataRequirementBuilder()
        .addCodeFilter(component)
        .build();
    assertThat(requirement.getCodeFilter())
        .as("Code Filter should be populated")
        .isNotEmpty()
        .allSatisfy(cmp -> assertThat(cmp.getPath()).isEqualToIgnoringCase("Patient/Name"));
  }

  @Test
  void testAddDataFilter() {
    DataRequirementDateFilterComponent component = new DataRequirementDateFilterComponent();
    component.setPath("Patient/Name");
    DataRequirement requirement = new DataRequirementBuilder()
        .addDateFilter(component)
        .build();
    assertThat(requirement.getDateFilter())
        .as("Data Filter should be populated")
        .isNotEmpty()
        .allSatisfy(cmp -> assertThat(cmp.getPath()).isEqualToIgnoringCase("Patient/Name"));
  }

  @Test
  void testWithLimit() {
    DataRequirement requirement = new DataRequirementBuilder()
        .withLimit(25)
        .build();
    assertThat(requirement.getLimit())
        .as("Limit should be 25")
        .isEqualTo(25);
  }

  @Test
  void testAddSort() {
    DataRequirementSortComponent component = new DataRequirementSortComponent();
    component.setPath("Patient/Name");
    DataRequirement requirement = new DataRequirementBuilder()
        .addSort(component)
        .build();
    assertThat(requirement.getSort())
        .as("Sort should be populated")
        .isNotEmpty()
        .allSatisfy(cmp -> assertThat(cmp.getPath()).isEqualToIgnoringCase("Patient/Name"));
  }
}