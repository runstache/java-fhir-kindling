package com.lswebworld.datatypes;

import org.hl7.fhir.r4.model.Coding;

public class CodingBuilder extends AbstractElementBuilder<Coding, CodingBuilder> {

  private Coding coding;

  /**
   * Constructor.
   */
  public CodingBuilder() {
    super();
    coding = new Coding();
    super.initialize(coding);
  }

  /**
   * Sets the System value for the Coding.
   * @param system System
   * @return CodingBuilder
   */
  public CodingBuilder withSystem(String system) {
    coding.setSystem(system);
    return this;
  }

  /**
   * Sets the Version on the Coding.
   * @param version Version
   * @return CodingBuilder
   */
  public CodingBuilder withVersion(String version) {
    coding.setVersion(version);
    return this;
  }

  /**
   * Sets the Code value of the Coding.
   * @param code Code Value.
   * @return CodingBuilder
   */
  public CodingBuilder withCode(String code) {
    coding.setCode(code);
    return this;
  }

  /**
   * Sets the Display value on the Coding.
   * @param display Display Value
   * @return CodingBuilder
   */
  public CodingBuilder withDisplay(String display) {
    coding.setDisplay(display);
    return this;
  }

  /**
   * Identifies if the coding was chosed directly by the user.
   * @param userSelected User Selected
   * @return CodingBuilder
   */
  public CodingBuilder withUserSelected(boolean userSelected) {
    coding.setUserSelected(userSelected);
    return this;
  }

  /**
   * Returns the constructed Coding value.
   * @return Coding
   */
  public Coding build() {
    return coding;
  }
  
}
