package com.lswebworld.datatypes;

import org.hl7.fhir.r4.model.Quantity;
import org.hl7.fhir.r4.model.Ratio;

public class RatioBuilder {

  private Ratio ratio;

  /**
   * Constructor.
   */
  public RatioBuilder() {
    this.ratio = new Ratio();
  }

  /**
   * Sets the Numerator to the provided Quantity.
   * @param numerator Numerator
   * @return RatioBuilder
   */
  public RatioBuilder withNumerator(Quantity numerator) {
    ratio.setNumerator(numerator);
    return this;
  }

  /**
   * Sets the Denominator to the provided Quantity.
   * @param denominator Denominator
   * @return RatioBuilder
   */
  public RatioBuilder withDenominator(Quantity denominator) {
    ratio.setDenominator(denominator);
    return this;
  }

  /**
   * Returns the constructed Ratio.
   * @return Ratio
   */
  public Ratio build() {
    return this.ratio;
  }
  
}
