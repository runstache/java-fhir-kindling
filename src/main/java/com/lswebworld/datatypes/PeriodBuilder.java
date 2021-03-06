package com.lswebworld.datatypes;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import org.hl7.fhir.r4.model.Period;

public class PeriodBuilder {

  private Period period;

  /**
   * Constructor.
   */
  public PeriodBuilder() {
    this.period = new Period();
  }

  /**
   * Sets the Start Date based on a Java Util Date Item.
   * @param startDate Start Date 
   * @return PeriodBuilder
   */
  public PeriodBuilder withStart(Date startDate) {
    period.setStart(startDate);
    return this;
  }

  /**
   * Sets the Start Date based on a Java Time Local Date Time.
   * @param startDate Start Date
   * @param offset Time Zone Offset
   * @return PeriodBuilder
   */
  public PeriodBuilder withStart(LocalDateTime startDate, ZoneOffset offset) {
    period.setStart(new Date(startDate.toEpochSecond(offset)));
    return this;
  }

  /**
   * Sets the End Date based on a Java Util Date Time.
   * @param endDate End Date
   * @return PeriodBuilder
   */
  public PeriodBuilder withEnd(Date endDate) {
    period.setEnd(endDate);
    return this;
  }

  /**
   * Sets the End Date based on a Java Time Local Date Time.
   * @param endDate End Date
   * @param offset Time Zone Offset
   * @return PeriodBuilder
   */
  public PeriodBuilder withEnd(LocalDateTime endDate, ZoneOffset offset) {
    period.setEnd(new Date(endDate.toEpochSecond(offset)));
    return this;
  }

  /**
   * Returns the constructed Period.
   * @return Period
   */
  public Period build() {
    return this.period;
  }


  
}
