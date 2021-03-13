package com.lswebworld.base;

import org.hl7.fhir.r4.model.BackboneType;
import org.hl7.fhir.r4.model.Extension;

@SuppressWarnings("unchecked")
public class AbstractBackboneElementBuilder<T extends BackboneType, U>
    extends AbstractElementBuilder<T, U> {

  private T element;

  /**
   * Constructor.
   */
  protected AbstractBackboneElementBuilder() {
    super();
  }

  @Override
  protected void initialize(T element) {
    this.element = element;
    super.initialize(element);
  }

  /**
   * Adds a Modifier Extension to tbe Backbone Element.
   * @param extension Extension.
   * @return AbstractBackboneElementBuilder
   */
  public U addModifierExtension(Extension extension) {
    element.addModifierExtension(extension);
    return (U) this;
  }

}
