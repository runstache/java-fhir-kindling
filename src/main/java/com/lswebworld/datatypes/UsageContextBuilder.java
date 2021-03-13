package com.lswebworld.datatypes;

import com.lswebworld.base.AbstractElementBuilder;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Quantity;
import org.hl7.fhir.r4.model.Range;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.UsageContext;

public class UsageContextBuilder extends AbstractElementBuilder<UsageContext, UsageContextBuilder> {

  private final UsageContext context;

  /**
   * Constructor.
   */
  public UsageContextBuilder() {
    super();
    context = new UsageContext();
    super.initialize(context);
  }

  /**
   * Sets the code to the provided Coding.
   * @param code Coding
   * @return UsageContextBuilder
   */
  public UsageContextBuilder withCode(Coding code) {
    context.setCode(code);
    return this;
  }

  /**
   * Sets the Value to the provided Codeable Concept.
   * @param value Codeable Concept
   * @return UsageContextBuilder
   */
  public UsageContextBuilder withValue(CodeableConcept value) {
    context.setValue(value);
    return this;
  }

  /**
   * Sets the value to the provided Quantity.
   * @param value Quantity
   * @return UsageContextBuilder
   */
  public UsageContextBuilder withValue(Quantity value) {
    context.setValue(value);
    return this;
  }

  /**
   * Sets the value to the provided Range.
   * @param value Range
   * @return UsageContextBuilder
   */
  public UsageContextBuilder withValue(Range value) {
    context.setValue(value);
    return this;
  }

  /**
   * Sets the value to the provided Reference.
   * @param value Reference
   * @return UsageContextBuilder
   */
  public UsageContextBuilder withValue(Reference value) {
    context.setValue(value);
    return this;
  }

  /**
   * Returns the Constructed Usage Context.
   * @return Usage Context
   */
  public UsageContext build() {
    return this.context;
  }
}
