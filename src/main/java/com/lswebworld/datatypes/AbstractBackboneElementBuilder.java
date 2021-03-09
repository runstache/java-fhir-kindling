package com.lswebworld.datatypes;

import org.hl7.fhir.r4.model.BackboneElement;
import org.hl7.fhir.r4.model.Extension;

@SuppressWarnings("unchecked")
public class AbstractBackboneElementBuilder<T extends BackboneElement, U>
    extends AbstractElementBuilder<T, U> {

  private final T element;

  /**
   * Constructor.
   * @param backboneElement Back Bone Element
   */
  protected AbstractBackboneElementBuilder(T backboneElement) {
    super();
    element = backboneElement;
    super.initialize(backboneElement);
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
