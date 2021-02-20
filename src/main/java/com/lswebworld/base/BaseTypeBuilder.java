package com.lswebworld.base;

import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.Type;

public abstract class BaseTypeBuilder<T extends Type> {
  
  private T type;

  protected BaseTypeBuilder(T type) {
    this.type = type;
  }

  /**
   * Sets the Element Id Field to the provided String.
   * @param id Id Value
   * @return Base Type Builder
   */
  public BaseTypeBuilder<T> withId(String id) {
    this.type.setId(id);
    return this;
  }

  /**
   * Adds an Extension to the Type.
   * @param extension Extension
   * @return Base Type Builder
   */
  public BaseTypeBuilder<T> addExtension(Extension extension) {
    this.type.addExtension(extension);
    return this;
  }
}
