package com.lswebworld.datatypes;

import org.hl7.fhir.r4.model.SampledData;
import org.hl7.fhir.r4.model.SimpleQuantity;

public class SampledDataBuilder extends AbstractElementBuilder<SampledData, SampledDataBuilder> {

  private SampledData sampledData;

  /**
   * Constructor.
   */
  public SampledDataBuilder() {
    super();
    sampledData = new SampledData();
    super.initialize(sampledData);
  }

  /**
   * Sets the Origin to the provided Simpled Quantity.
   * @param origin Origin
   * @return SampledDataBuilder
   */
  public SampledDataBuilder withOrigin(SimpleQuantity origin) {
    sampledData.setOrigin(origin);
    return this;
  }

  /**
   * Sets the period to the provided Double.
   * @param period Period
   * @return SampledDataBuilder
   */
  public SampledDataBuilder withPeriod(double period) {
    sampledData.setPeriod(period);
    return this;
  }

  /**
   * Sets the Factor to the provided double.
   * @param factor Factor
   * @return SampledDataBuilder
   */
  public SampledDataBuilder withFactor(double factor) {
    sampledData.setFactor(factor);
    return this;
  }

  /**
   * Sets the lower limit to the provided Double.
   * @param lowerLimit Lower limit
   * @return SampledDataBuilder
   */
  public SampledDataBuilder withLowerLimit(double lowerLimit) {
    sampledData.setLowerLimit(lowerLimit);
    return this;
  }

  /**
   * Sets the Upper Limit to the provided Double.
   * @param upperLimit Upper Limit
   * @return SampledDataBuilder
   */
  public SampledDataBuilder withUpperLimit(double upperLimit) {
    sampledData.setUpperLimit(upperLimit);
    return this;
  }

  /**
   * Sets the Dimension of the Sampled Data to the provided Integer.
   * @param dimensions Dimensions
   * @return SampledDataBuilder
   */
  public SampledDataBuilder withDimensions(int dimensions) {
    sampledData.setDimensions(dimensions);
    return this;
  }

  /**
   * Sets the Data of the Sampled Date to the provided String.
   * @param data Data
   * @return SampledDataBuilder
   */
  public SampledDataBuilder withData(String data) {
    sampledData.setData(data);
    return this;
  }

  /**
   * Returns the constructed Sampled Data.
   * @return Sampled Data
   */
  public SampledData build() {
    return sampledData;
  }
}
