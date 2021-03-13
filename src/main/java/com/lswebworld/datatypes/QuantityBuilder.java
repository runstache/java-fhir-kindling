package com.lswebworld.datatypes;

import com.lswebworld.base.AbstractQuantityBuilder;
import org.hl7.fhir.r4.model.Quantity;

public class QuantityBuilder extends AbstractQuantityBuilder<Quantity> {

  /**
   * Constructor.
   */
  public QuantityBuilder() {
    super(new Quantity());
  }
}
