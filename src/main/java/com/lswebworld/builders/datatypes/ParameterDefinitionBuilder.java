package com.lswebworld.builders.datatypes;

import com.lswebworld.builders.base.AbstractElementBuilder;
import org.hl7.fhir.r4.model.ParameterDefinition;
import org.hl7.fhir.r4.model.ParameterDefinition.ParameterUse;

public class ParameterDefinitionBuilder
    extends AbstractElementBuilder<ParameterDefinition, ParameterDefinitionBuilder> {

  private final ParameterDefinition parameter;

  /**
   * Constructor.
   */
  public ParameterDefinitionBuilder() {
    super();
    parameter = new ParameterDefinition();
    super.initialize(parameter);
  }

  /**
   * Sets the Name of the Parameter Definition.
   * @param name Name
   * @return ParameterDefinitionBuilder
   */
  public ParameterDefinitionBuilder withName(String name) {
    parameter.setName(name);
    return this;
  }

  /**
   * Sets the Parameter Definition Use.
   * @param use Use
   * @return ParameterDefinitionBuilder
   */
  public ParameterDefinitionBuilder withUse(ParameterUse use) {
    parameter.setUse(use);
    return this;
  }

  /**
   * Sets the Min on the Parameter Definition.
   * @param min Min
   * @return ParameterDefinitionBuilder
   */
  public ParameterDefinitionBuilder withMin(int min) {
    parameter.setMin(min);
    return this;
  }

  /**
   * Sets the Max for the Parameter Definition.
   * @param max Max
   * @return ParameterDefinitionBuilder
   */
  public ParameterDefinitionBuilder withMax(String max) {
    parameter.setMax(max);
    return this;
  }

  /**
   * Sets the Documentation for the Parameter Definition.
   * @param documentation Parameter Definition
   * @return ParameterDefinitionBuilder
   */
  public ParameterDefinitionBuilder withDocumentation(String documentation) {
    parameter.setDocumentation(documentation);
    return this;
  }

  /**
   * Sets the Type on the Parameter Definition.
   * @param type Type
   * @return ParameterDefinitionBuilder
   */
  public ParameterDefinitionBuilder withType(String type) {
    parameter.setType(type);
    return this;
  }

  /**
   * Sets the Canonical Profile Url for the Parameter Definition.
   * @param profile Canonical Url
   * @return ParameterDefinitionBuilder
   */
  public ParameterDefinitionBuilder withProfile(String profile) {
    parameter.setProfile(profile);
    return this;
  }

  /**
   * Returns the constructed Parameter Definition.
   * @return Parameter Definition
   */
  public ParameterDefinition build() {
    return this.parameter;
  }
}
