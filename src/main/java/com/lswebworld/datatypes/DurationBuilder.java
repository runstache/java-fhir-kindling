package com.lswebworld.datatypes;

import com.lswebworld.base.AbstractQuantityBuilder;
import org.hl7.fhir.r4.model.Duration;

public class DurationBuilder extends AbstractQuantityBuilder<Duration> {

  /**
   * Constructor.
   */
  public DurationBuilder() {
    super(new Duration());
  }
  
}
