package com.lswebworld.builders.datatypes;

import com.lswebworld.builders.base.AbstractQuantityBuilder;
import org.hl7.fhir.r4.model.Quantity;

public class QuantityBuilder extends AbstractQuantityBuilder<Quantity> {

  /**
   * Constructor.
   */
  public QuantityBuilder() {
    super(new Quantity());
  }
}
