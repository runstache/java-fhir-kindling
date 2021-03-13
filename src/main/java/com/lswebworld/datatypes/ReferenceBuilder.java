package com.lswebworld.datatypes;

import com.lswebworld.base.AbstractElementBuilder;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.Reference;

public class ReferenceBuilder extends AbstractElementBuilder<Reference, ReferenceBuilder> {

  private final Reference reference;

  /**
   * Constructor.
   */
  public ReferenceBuilder() {
    super();
    reference = new Reference();
    super.initialize(reference);
  }

  /**
   * Sets the Reference Url to the Resource.
   * @param reference Reference
   * @return ReferenceBuilder
   */
  public ReferenceBuilder withReference(String reference) {
    this.reference.setReference(reference);
    return this;
  }

  /**
   * Sets the Type of the Reference.
   * @param type Type
   * @return ReferenceBuilder
   */
  public ReferenceBuilder withType(String type) {
    reference.setType(type);
    return this;
  }

  /**
   * Sets the Reference Identifier.
   * @param identifier Identifier
   * @return ReferenceBuilder
   */
  public ReferenceBuilder withIdentifier(Identifier identifier) {
    reference.setIdentifier(identifier);
    return this;
  }

  /**
   * Sets the Display of the reference.
   * @param display Display
   * @return ReferenceBuilder
   */
  public ReferenceBuilder withDisplay(String display) {
    reference.setDisplay(display);
    return this;
  }

  /**
   * Returns the constructed Reference.
   * @return Reference
   */
  public Reference build() {
    return reference;
  }
}
