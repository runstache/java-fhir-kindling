package com.lswebworld.datatypes;

import com.lswebworld.base.AbstractQuantityBuilder;
import org.hl7.fhir.r4.model.SimpleQuantity;

public class SimpleQuantityBuilder extends AbstractQuantityBuilder<SimpleQuantity> {

  /**
   * Constructor.
   */
  public SimpleQuantityBuilder() {
    super(new SimpleQuantity());
  }
  
}
