package com.lswebworld.datatypes;

import com.lswebworld.base.AbstractElementBuilder;
import org.hl7.fhir.r4.model.HumanName;
import org.hl7.fhir.r4.model.Period;

public class HumanNameBuilder extends AbstractElementBuilder<HumanName, HumanNameBuilder> {

  private final HumanName name;

  /**
   * Constructor.
   */
  public HumanNameBuilder() {
    super();
    name = new HumanName();
    super.initialize(name);
  }
  
  /**
   * Updates the Use of the Human Name.
   * @param use Human Name Use
   * @return HumanNameBuilder
   */
  public HumanNameBuilder withUse(HumanName.NameUse use) {
    name.setUse(use);
    return this;
  }

  /**
   * Sets the Full Name Text of the Human Name.
   * @param text Full Name Text
   * @return HumanNameBuilder
   */
  public HumanNameBuilder withText(String text) {
    name.setText(text);
    return this;
  }

  /**
   * Sets the Family name of the Human Name.
   * @param family Family Name
   * @return HumanNameBuilder
   */
  public HumanNameBuilder withFamily(String family) {
    name.setFamily(family);
    return this;
  }

  /**
   * Adds a Given Name of the Human Name.
   * @param givenName Given Name
   * @return HumanNameBuilder
   */
  public HumanNameBuilder addGiven(String givenName) {
    name.addGiven(givenName);
    return this;
  }

  /**
   * Adds a Prefix for the Human Name.
   * @param prefix Prefix
   * @return HumanNameBuilder
   */
  public HumanNameBuilder addPrefix(String prefix) {
    name.addPrefix(prefix);
    return this;
  }

  /**
   * Adds a Suffix for the Human Name.
   * @param suffix Suffix
   * @return HumanNameBuilder
   */
  public HumanNameBuilder addSuffix(String suffix) {
    name.addSuffix(suffix);
    return this;
  }

  /**
   * Sets the Period for which the Human Name is in use.
   * @param period Period
   * @return HumanNameBuilder
   */
  public HumanNameBuilder withPeriod(Period period) {
    name.setPeriod(period);
    return this;
  }

  /**
   * Returns the Constructed Human Name.
   * @return Human Name
   */
  public HumanName build() {
    return this.name;
  }
}
