package com.lswebworld.datatypes;

import org.hl7.fhir.r4.model.Age;

public class AgeBuilder extends AbstractQuantityBuilder<Age> {

  /**
   * Constructor.
   */
  public AgeBuilder() {
    super(new Age());
  }
}
