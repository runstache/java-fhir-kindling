package com.lswebworld.datatypes;

import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.Type;

public class ExtensionBuilder extends AbstractElementBuilder<Extension, ExtensionBuilder> {

  private final Extension extension;

  /**
   * Constructor.
   */
  public ExtensionBuilder() {
    super();
    extension = new Extension();
    super.initialize(extension);
  }

  /**
   * Sets the Uri for the Extension.
   * @param url Extension Uri
   * @return ExtensionBuilder
   */
  public ExtensionBuilder withUrl(String url) {
    extension.setUrl(url);
    return this;
  }

  /**
   * Sets the Value of the Extension.
   * @param value Extension Value
   * @return ExtensionBuilder
   */
  public ExtensionBuilder withValue(Type value) {
    extension.setValue(value);
    return this;
  }

  /**
   * Returns the Constructed Extension.
   * @return Extension
   */
  public Extension build() {
    return this.extension;
  }
}
