package com.lswebworld.datatypes;

import org.hl7.fhir.r4.model.MoneyQuantity;

public class MoneyQuantityBuilder extends AbstractQuantityBuilder<MoneyQuantity> {

  /**
   * Constructor.
   */
  public MoneyQuantityBuilder() {
    super(new MoneyQuantity());
  }
  
}
