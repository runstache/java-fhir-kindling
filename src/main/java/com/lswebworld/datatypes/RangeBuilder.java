package com.lswebworld.datatypes;

import org.hl7.fhir.r4.model.Range;
import org.hl7.fhir.r4.model.SimpleQuantity;

public class RangeBuilder extends AbstractElementBuilder<Range, RangeBuilder> {

  private Range range;

  /**
   * Constructor.
   */
  public RangeBuilder() {
    super();
    this.range = new Range();
    super.initialize(range);
  }

  /**
   * Set the Low Value to a Simple Quantity.
   * @param low Simple Quantity Low value.
   * @return RangeBuilder
   */
  public RangeBuilder withLow(SimpleQuantity low) {
    range.setLow(low);
    return this;
  }

  /**
   * Sets the High Value to a Simple Quantity.
   * @param high Simple Quantity High Value
   * @return RangeBuilder
   */
  public RangeBuilder withHigh(SimpleQuantity high) {
    range.setHigh(high);
    return this;
  }

  /**
   * Returns the constructed Range.
   * @return Range
   */
  public Range build() {
    return this.range;
  }
  
}
