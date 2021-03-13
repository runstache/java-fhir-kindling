package com.lswebworld.components.datatypes;

import com.lswebworld.base.AbstractElementBuilder;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.DataRequirement.DataRequirementCodeFilterComponent;

public class DataRequirementCodeFilterBuilder
    extends AbstractElementBuilder<DataRequirementCodeFilterComponent,
        DataRequirementCodeFilterBuilder> {

  private final DataRequirementCodeFilterComponent component;

  /**
   * Constructor.
   */
  public DataRequirementCodeFilterBuilder() {
    super();
    component = new DataRequirementCodeFilterComponent();
    super.initialize(component);
  }

  /**
   * Sets the Path of the Code Filter.
   * @param path Path
   * @return DataRequirementCodeFilterBuilder
   */
  public DataRequirementCodeFilterBuilder withPath(String path) {
    component.setPath(path);
    return this;
  }

  /**
   * Sets the Search Parameter.
   * @param searchParam Search Parameter
   * @return DataRequirementCodeFilterBuilder
   */
  public DataRequirementCodeFilterBuilder withSearchParam(String searchParam) {
    component.setSearchParam(searchParam);
    return this;
  }

  /**
   * Sets the Canonical Url for the ValueSet.
   * @param valueSet ValueSet Url
   * @return DataRequirementCodeFilterBuilder
   */
  public DataRequirementCodeFilterBuilder withValueSet(String valueSet) {
    component.setValueSet(valueSet);
    return this;
  }

  /**
   * Adds a Coding Element to the Code Filter.
   * @param coding Coding
   * @return DataRequirementCodeFilterBuilder
   */
  public DataRequirementCodeFilterBuilder addCode(Coding coding) {
    component.addCode(coding);
    return this;
  }

  /**
   * Returns the Constructed Code Filter Component.
   * @return Data Requirement Code Filter Component.
   */
  public DataRequirementCodeFilterComponent build() {
    return this.component;
  }
}
