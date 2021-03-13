package com.lswebworld.builders.datatypes;

import com.lswebworld.builders.base.AbstractElementBuilder;
import org.hl7.fhir.r4.model.ContactPoint;
import org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem;
import org.hl7.fhir.r4.model.ContactPoint.ContactPointUse;
import org.hl7.fhir.r4.model.Period;

public class ContactPointBuilder extends AbstractElementBuilder<ContactPoint, ContactPointBuilder> {

  private final ContactPoint contactPoint;

  /**
   * Constructor.
   */
  public ContactPointBuilder() {
    super();
    contactPoint = new ContactPoint();
    super.initialize(contactPoint);
  }

  /**
   * Sets the System of the Contact Point (Phone, Email, Fax, etc).
   * @param system System of the Contact Point.
   * @return ContactPointBuilder
   */
  public ContactPointBuilder withSystem(ContactPointSystem system) {
    contactPoint.setSystem(system);
    return this;
  }

  /**
   * Sets the Contact Point Value.
   * @param value Contact Point Value.
   * @return ContactPointBuilder
   */
  public ContactPointBuilder withValue(String value) {
    contactPoint.setValue(value);
    return this;
  }

  /**
   * Sets the Contact Point Use.
   * @param use Contact Point Use
   * @return ContactPointBuilder
   */
  public ContactPointBuilder withUse(ContactPointUse use) {
    contactPoint.setUse(use);
    return this;
  }

  /**
   * Set the Contact Point Ranking.
   * @param rank Rank Value
   * @return ContactPointBuilder
   */
  public ContactPointBuilder withRank(int rank) {
    contactPoint.setRank(rank);
    return this;
  }

  /**
   * Sets the Period of use for the Contact Point.
   * @param period Period
   * @return ContactPointBuilder
   */
  public ContactPointBuilder withPeriod(Period period) {
    contactPoint.setPeriod(period);
    return this;
  }

  /**
   * Returns the constructed Contact Point.
   * @return Contact Point
   */
  public ContactPoint build() {
    return this.contactPoint;
  }
  
}
