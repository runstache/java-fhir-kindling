package com.lswebworld.datatypes;

import org.hl7.fhir.r4.model.Quantity;
import org.hl7.fhir.r4.model.Quantity.QuantityComparator;

public class QuantityBuilder {

  private Quantity quantity;


  /**
   * Constructor.
   */
  public QuantityBuilder() {
    this.quantity = new Quantity();
  }

  /**
   * Sets the Value of the Quantity.
   * @param value Value
   * @return QuantityBuilder
   */
  public QuantityBuilder withValue(double value) {
    quantity.setValue(value);
    return this;
  }

  /**
   * Sets the Comparator on the Quantity (>, <, >=, <=, =).
   * @param comparator Comparator
   * @return QuantityBuilder
   */
  public QuantityBuilder withComparator(QuantityComparator comparator) {
    quantity.setComparator(comparator);
    return this;
  }

  /**
   * Sets the Unit for the Quantity Value.
   * @param unit Units
   * @return QuantityBuilder
   */
  public QuantityBuilder withUnit(String unit) {
    quantity.setUnit(unit);
    return this;
  }

  /**
   * Sets the System for the Value Units.
   * @param system System value.
   * @return QuantityBuilder
   */
  public QuantityBuilder withSystem(String system) {
    quantity.setSystem(system);
    return this;
  }

  /**
   * Sets the Coded form of the Units.
   * @param code Code
   * @return QuantityBuilder
   */
  public QuantityBuilder withCode(String code) {
    quantity.setCode(code);
    return this;
  }

  /**
   * Returns the Constructred Quantity.
   * @return Quantity.
   */
  public Quantity build() {
    return this.quantity;
  }
  
}
