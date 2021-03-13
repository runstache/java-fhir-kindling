package com.lswebworld.builders.datatypes;

import com.lswebworld.builders.base.AbstractElementBuilder;
import org.hl7.fhir.r4.model.ContactDetail;
import org.hl7.fhir.r4.model.ContactPoint;

public class ContactDetailBuilder
    extends AbstractElementBuilder<ContactDetail, ContactDetailBuilder> {

  private final ContactDetail detail;

  /**
   * Constructor.
   */
  public ContactDetailBuilder() {
    super();
    detail = new ContactDetail();
    super.initialize(detail);
  }

  /**
   * Sets the Name of the Contact Detail.
   * @param name Name
   * @return ContactDetailBuilder
   */
  public ContactDetailBuilder withName(String name) {
    detail.setName(name);
    return this;
  }

  /**
   * Adds a Contact Point to the Contact Detail.
   * @param telecom Telecom
   * @return ContactDetailBuilder
   */
  public ContactDetailBuilder addTelecom(ContactPoint telecom) {
    detail.addTelecom(telecom);
    return this;
  }

  /**
   * Returns the Constructed Contact Detail.
   * @return ContactDetail
   */
  public ContactDetail build() {
    return detail;
  }


}
