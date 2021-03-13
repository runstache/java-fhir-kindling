package com.lswebworld.datatypes;

import com.lswebworld.base.AbstractElementBuilder;
import org.hl7.fhir.r4.model.Quantity;
import org.hl7.fhir.r4.model.Ratio;

public class RatioBuilder extends AbstractElementBuilder<Ratio, RatioBuilder> {

  private final Ratio ratio;

  /**
   * Constructor.
   */
  public RatioBuilder() {
    super();
    this.ratio = new Ratio();
    super.initialize(ratio);
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
