package com.lswebworld.components.datatypes;

import com.lswebworld.base.AbstractElementBuilder;
import org.hl7.fhir.r4.model.DataRequirement.DataRequirementSortComponent;
import org.hl7.fhir.r4.model.DataRequirement.SortDirection;

public class DataRequirementSortFilterBuilder
    extends AbstractElementBuilder<DataRequirementSortComponent,
        DataRequirementSortFilterBuilder> {

  private final DataRequirementSortComponent component;

  /**
   * Constructor.
   */
  public DataRequirementSortFilterBuilder() {
    super();
    component = new DataRequirementSortComponent();
    super.initialize(component);
  }

  /**
   * Sets the Path on the Sort Component.
   * @param path Path
   * @return DataRequirementSortFilterBuilder
   */
  public DataRequirementSortFilterBuilder withPath(String path) {
    component.setPath(path);
    return this;
  }

  /**
   * Sets the Sort Direction on the Sort component.
   * @param direction Sort Direction
   * @return DataRequirementSortFilterBuilder
   */
  public DataRequirementSortFilterBuilder withDirection(SortDirection direction) {
    component.setDirection(direction);
    return this;
  }

  /**
   * Sets the Sort Direction to Ascending.
   * @return DataRequirementSortFilterBuilder
   */
  public DataRequirementSortFilterBuilder ascending() {
    component.setDirection(SortDirection.ASCENDING);
    return this;
  }

  /**
   * Sets the Sort Direction to Descending.
   * @return DataRequirementSortFilterBuilder
   */
  public DataRequirementSortFilterBuilder descending() {
    component.setDirection(SortDirection.DESCENDING);
    return this;
  }

  /**
   * Returns the constructed Sort Component.
   * @return Data Requirement Sort Component
   */
  public DataRequirementSortComponent build() {
    return this.component;
  }
}
