package com.lswebworld.datatypes;

import com.lswebworld.base.AbstractElementBuilder;
import org.hl7.fhir.r4.model.ContactDetail;
import org.hl7.fhir.r4.model.Contributor;

public class ContributorBuilder extends AbstractElementBuilder<Contributor, ContributorBuilder> {

  private final Contributor contributor;

  /**
   * Constructor.
   */
  public ContributorBuilder() {
    super();
    contributor = new Contributor();
    super.initialize(contributor);
  }

  /**
   * Sets the Contributor Type.
   * @param type Contributor Type
   * @return ContributorBuilder
   */
  public ContributorBuilder withType(Contributor.ContributorType type) {
    contributor.setType(type);
    return this;
  }

  /**
   * Sets the Name on the Contributor.
   * @param name Name
   * @return ContributorBuilder
   */
  public ContributorBuilder withName(String name) {
    contributor.setName(name);
    return this;
  }

  /**
   * Adds a Contact Detail to the Contributor.
   * @param detail Contact Detail
   * @return ContributorBuilder
   */
  public ContributorBuilder addContact(ContactDetail detail) {
    contributor.addContact(detail);
    return this;
  }

  /**
   * Returns the constructed Contributor.
   * @return Contributor
   */
  public Contributor build() {
    return this.contributor;
  }
}
