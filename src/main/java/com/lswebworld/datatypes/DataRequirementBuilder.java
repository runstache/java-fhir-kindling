package com.lswebworld.datatypes;

import com.lswebworld.base.AbstractElementBuilder;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.DataRequirement;
import org.hl7.fhir.r4.model.DataRequirement.DataRequirementCodeFilterComponent;
import org.hl7.fhir.r4.model.DataRequirement.DataRequirementDateFilterComponent;
import org.hl7.fhir.r4.model.DataRequirement.DataRequirementSortComponent;
import org.hl7.fhir.r4.model.Reference;

public class DataRequirementBuilder
    extends AbstractElementBuilder<DataRequirement, DataRequirementBuilder> {

  private final DataRequirement requirement;

  /**
   * Constructor.
   */
  public DataRequirementBuilder() {
    super();
    requirement = new DataRequirement();
    super.initialize(requirement);
  }

  /**
   * Sets the Type on the Data Requirement.
   * @param type FHIR All Type
   * @return DataRequirementBuilder
   */
  public DataRequirementBuilder withType(String type) {
    requirement.setType(type);
    return this;
  }

  /**
   * Adds a Canonical Url for a Structure Definition to the Data Requirement.
   * @param profile Url
   * @return DataRequirementBuilder
   */
  public DataRequirementBuilder addProfile(String profile) {
    requirement.addProfile(profile);
    return this;
  }

  /**
   * Sets the Subject to the provided Codeable Concept.
   * @param subject Codeable Concept.
   * @return DataRequirementBuilder
   */
  public DataRequirementBuilder withSubject(CodeableConcept subject) {
    requirement.setSubject(subject);
    return this;
  }

  /**
   * Sets the Subject to the Provided Reference.
   * @param subject Reference
   * @return DataRequirementBuilder
   */
  public DataRequirementBuilder withSubject(Reference subject) {
    requirement.setSubject(subject);
    return this;
  }

  /**
   * Adds a Must Support indicator to the Data Requirement.
   * @param mustSupport Must Support String
   * @return DataRequirementBuilder
   */
  public DataRequirementBuilder addMustSupport(String mustSupport) {
    requirement.addMustSupport(mustSupport);
    return this;
  }

  /**
   * Adds a Data Requirement CodeFilter Component to the Data Requirement.
   * @param codeFilter Code Filter Component
   * @return DataRequirementBuilder
   */
  public DataRequirementBuilder addCodeFilter(DataRequirementCodeFilterComponent codeFilter) {
    requirement.addCodeFilter(codeFilter);
    return this;
  }

  /**
   * Adds a Data Requirement DateFilter to the Data Requirement.
   * @param dataFilter Data Filter Component
   * @return DataRequirementBuilder
   */
  public DataRequirementBuilder addDateFilter(DataRequirementDateFilterComponent dataFilter) {
    requirement.addDateFilter(dataFilter);
    return this;
  }

  /**
   * Sets the Number of Results for the Data Requirement.
   * @param limit Number of Results
   * @return DataRequirementBuilder
   */
  public DataRequirementBuilder withLimit(int limit) {
    requirement.setLimit(limit);
    return this;
  }

  /**
   * Adds a Data Requirement Sort Component to the Data Requirement.
   * @param sort Data Requirement Sort Component
   * @return DataRequirementBuilder
   */
  public DataRequirementBuilder addSort(DataRequirementSortComponent sort) {
    requirement.addSort(sort);
    return this;
  }

  /**
   * Returns the Constructed Data Requirement.
   * @return Data Requirement
   */
  public DataRequirement build() {
    return this.requirement;
  }
}
