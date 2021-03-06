package com.lswebworld.datatypes;

import org.hl7.fhir.r4.model.Duration;

public class DurationBuilder extends AbstractQuantityBuilder<Duration> {

  /**
   * Constructor.
   */
  public DurationBuilder() {
    super(new Duration());
  }
  
}
