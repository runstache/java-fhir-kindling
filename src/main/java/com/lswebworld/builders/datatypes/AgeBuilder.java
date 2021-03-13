package com.lswebworld.builders.datatypes;

import com.lswebworld.builders.base.AbstractQuantityBuilder;
import org.hl7.fhir.r4.model.Age;

public class AgeBuilder extends AbstractQuantityBuilder<Age> {

  /**
   * Constructor.
   */
  public AgeBuilder() {
    super(new Age());
  }
}
