package com.lswebworld.datatypes;

import com.lswebworld.base.AbstractElementBuilder;
import org.hl7.fhir.r4.model.Address;
import org.hl7.fhir.r4.model.Address.AddressType;
import org.hl7.fhir.r4.model.Address.AddressUse;
import org.hl7.fhir.r4.model.Period;

public class AddressBuilder extends AbstractElementBuilder<Address, AddressBuilder> {
  
  private final Address address;

  /**
   * Constructor.
   */
  public AddressBuilder() {
    super();
    this.address = new Address();
    super.initialize(address);
  }

  /**
   * Sets the Address Use.
   * @param use Address Use
   * @return AddressBuilder
   */
  public AddressBuilder withUse(AddressUse use) {
    address.setUse(use);
    return this;
  }

  /**
   * Sets the Address Type.
   * @param type Address Type
   * @return AddressBuilder
   */
  public AddressBuilder withType(AddressType type) {
    address.setType(type);
    return this;
  }

  /**
   * Sets the Text Representation of the Address.
   * @param text Address Text
   * @return AddressBuilder
   */
  public AddressBuilder withText(String text) {
    address.setText(text);
    return this;
  }

  /**
   * Adds an Address Line to the Address.
   * @param line Address Line
   * @return AddressBuilder
   */
  public AddressBuilder addLine(String line) {
    address.addLine(line);
    return this;
  }

  /**
   * Sets the City of the Address.
   * @param city City value
   * @return AddressBuilder
   */
  public AddressBuilder withCity(String city) {
    address.setCity(city);
    return this;
  }

  /**
   * Sets the District of the Address.
   * @param district District Value.
   * @return AddressBuilder
   */
  public AddressBuilder withDistrict(String district) {
    address.setDistrict(district);
    return this;
  }

  /**
   * Sets the State value of the Address.
   * @param state State
   * @return AddressBuilder
   */
  public AddressBuilder withState(String state) {
    address.setState(state);
    return this;
  }

  /**
   * Sets the Postal Code for the Address. Also know as the Zip Code.
   * @param postalCode Postal Code
   * @return AddressBuilder
   */
  public AddressBuilder withPostalCode(String postalCode) {
    address.setPostalCode(postalCode);
    return this;
  }

  /**
   * Sets the Country code for the Address.
   * @param country Country
   * @return AddressBuilder
   */
  public AddressBuilder withCountry(String country) {
    address.setCountry(country);
    return this;
  }

  /**
   * Sets the Period in which this Address is Active.
   * @param period Period
   * @return AddressBuilder
   */
  public AddressBuilder withPeriod(Period period) {
    address.setPeriod(period);
    return this;
  }

  /**
   * Returns the constructed Address.
   * @return Address
   */
  public Address build() {
    return this.address;
  }

}
