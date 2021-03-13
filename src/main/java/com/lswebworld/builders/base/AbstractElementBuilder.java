package com.lswebworld.builders.base;

import org.hl7.fhir.r4.model.Element;
import org.hl7.fhir.r4.model.Extension;

@SuppressWarnings("unchecked")
public abstract class AbstractElementBuilder<T extends Element, U> {

  private T element;

  protected AbstractElementBuilder() {
  }

  protected void initialize(T element) {
    this.element = element;
  }

  /**
   * Sets the Id of the Element.
   * @param id Id Value
   * @return AbstractElementBuilder
   */
  public U withId(String id) {
    element.setId(id);
    return (U) this;
  }

  /**
   * Adds an Extension to the Extensions of the Element.
   * @param extension Extension.
   * @return AbstractElementBuilder
   */
  public U addExtension(Extension extension) {
    element.addExtension(extension);
    return (U) this;
  }
}
