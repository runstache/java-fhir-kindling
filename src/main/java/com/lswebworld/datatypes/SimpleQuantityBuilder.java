package com.lswebworld.datatypes;

import org.hl7.fhir.r4.model.SimpleQuantity;

public class SimpleQuantityBuilder extends AbstractQuantityBuilder<SimpleQuantity> {

  /**
   * Constructor.
   */
  public SimpleQuantityBuilder() {
    super(new SimpleQuantity());
  }
  
}
