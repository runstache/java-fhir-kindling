package com.lswebworld.base;

import org.hl7.fhir.r4.model.Quantity;
import org.hl7.fhir.r4.model.Quantity.QuantityComparator;

public abstract class AbstractQuantityBuilder<T extends Quantity> 
    extends AbstractElementBuilder<T, AbstractQuantityBuilder<T>> {

  private T quantity;

  /**
   * Constructor.
   * @param quantity Initial Quantity Type.
   */
  protected AbstractQuantityBuilder(T quantity) {
    super();
    this.quantity = quantity;
    super.initialize(quantity);
  }

  /**
   * Sets the Value of the Quantity.
   * @param value Value
   * @return QuantityBuilder
   */
  public AbstractQuantityBuilder<T> withValue(double value) {
    quantity.setValue(value);
    return this;
  }

  /**
   * Sets the Comparator on the Quantity (&gt;, &lt;, &gt;=, &lt;=, =).
   * @param comparator Comparator
   * @return QuantityBuilder
   */
  public AbstractQuantityBuilder<T> withComparator(QuantityComparator comparator) {
    quantity.setComparator(comparator);
    return this;
  }

  /**
   * Sets the Unit for the Quantity Value.
   * @param unit Units
   * @return QuantityBuilder
   */
  public AbstractQuantityBuilder<T> withUnit(String unit) {
    quantity.setUnit(unit);
    return this;
  }

  /**
   * Sets the System for the Value Units.
   * @param system System value.
   * @return QuantityBuilder
   */
  public AbstractQuantityBuilder<T> withSystem(String system) {
    quantity.setSystem(system);
    return this;
  }

  /**
   * Sets the Coded form of the Units.
   * @param code Code
   * @return QuantityBuilder
   */
  public AbstractQuantityBuilder<T> withCode(String code) {
    quantity.setCode(code);
    return this;
  }

  /**
   * Returns the Constructred Quantity.
   * @return Quantity.
   */
  public T build() {
    return this.quantity;
  }
  
}
