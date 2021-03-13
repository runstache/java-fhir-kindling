package com.lswebworld.builders.datatypes;

import com.lswebworld.builders.base.AbstractElementBuilder;
import org.hl7.fhir.r4.model.Expression;

public class ExpressionBuilder extends AbstractElementBuilder<Expression, ExpressionBuilder> {

  private final Expression element;

  /**
   * Constructor.
   */
  public ExpressionBuilder() {
    super();
    element = new Expression();
    super.initialize(element);
  }

  /**
   * Sets the Description on the Expression.
   * @return ExpressionBuilder
   */
  public ExpressionBuilder withDescription(String description) {
    element.setDescription(description);
    return this;
  }

  /**
   * Sets the Name on the Expression.
   * @param name Name
   * @return ExpressionBuilder
   */
  public ExpressionBuilder withName(String name) {
    element.setName(name);
    return this;
  }

  /**
   * Sets the Language of the Expression.
   * @param language Language
   * @return ExpressionBuilder
   */
  public ExpressionBuilder withLanguage(String language) {
    element.setLanguage(language);
    return this;
  }

  /**
   * Sets the Expression Text of the Expression.
   * @param expression Expression
   * @return ExpressionBuilder
   */
  public ExpressionBuilder withExpression(String expression) {
    element.setExpression(expression);
    return this;
  }

  /**
   * Sets the Reference for the Expression.
   * @param reference Reference
   * @return ExpressionBuilder
   */
  public ExpressionBuilder withReference(String reference) {
    element.setReference(reference);
    return this;
  }

  /**
   * Returns the Constructed Expression.
   * @return Expression
   */
  public Expression build() {
    return this.element;
  }
}
