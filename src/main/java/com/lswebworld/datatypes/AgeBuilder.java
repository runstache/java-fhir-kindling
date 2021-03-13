package com.lswebworld.datatypes;

import com.lswebworld.base.AbstractQuantityBuilder;
import org.hl7.fhir.r4.model.Age;

public class AgeBuilder extends AbstractQuantityBuilder<Age> {

  /**
   * Constructor.
   */
  public AgeBuilder() {
    super(new Age());
  }
}
