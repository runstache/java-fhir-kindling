package com.lswebworld.datatypes;

import org.hl7.fhir.r4.model.Distance;

public class DistanceBuilder extends AbstractQuantityBuilder<Distance> {

  /**
   * Constructor.
   */
  public DistanceBuilder() {
    super(new Distance());
  }
  
}
