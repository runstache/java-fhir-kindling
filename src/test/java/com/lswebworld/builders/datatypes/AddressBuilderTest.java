package com.lswebworld.builders.datatypes;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import org.hl7.fhir.r4.model.Address;
import org.hl7.fhir.r4.model.Address.AddressType;
import org.hl7.fhir.r4.model.Address.AddressUse;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.Period;
import org.hl7.fhir.r4.model.StringType;
import org.junit.jupiter.api.Test;

class AddressBuilderTest {

  @Test
  void testWithUse() {
    Address address = new AddressBuilder()
        .withUse(AddressUse.HOME)
        .build();
    assertThat(address.getUse())
        .as("Address Use should be Home")
        .isEqualTo(AddressUse.HOME);
  }

  @Test
  void testWithType() {
    Address address = new AddressBuilder()
        .withType(AddressType.POSTAL)
        .build();
    assertThat(address.getType())
        .as("Address Type should be Postal")
        .isEqualTo(AddressType.POSTAL);
  }

  @Test
  void testWithText() {
    Address address = new AddressBuilder()
        .withText("123 Main St")
        .build();
    assertThat(address.getText())
        .as("Text should be 123 Main St")
        .isEqualToIgnoringCase("123 Main St");
  }

  @Test
  void testAddLine() {
    Address address = new AddressBuilder()
        .addLine("123 Main St")
        .addLine("Suite 200")
        .build();
    assertThat(address.getLine())
        .as("123 Main St and Suite 200 should be present")
        .extracting(StringType.class::cast)
        .extracting(StringType::getValueAsString)
        .contains("123 Main St", "Suite 200");
  }

  @Test
  void testWithCity() {
    Address address = new AddressBuilder()
        .withCity("Pittsburgh")
        .build();
    assertThat(address.getCity())
        .as("City should be Pittsburgh")
        .isEqualToIgnoringCase("Pittsburgh");
  }

  @Test
  void testWithDistrict() {
    Address address = new AddressBuilder()
        .withDistrict("ANYWHERE")
        .build();
    assertThat(address.getDistrict())
        .as("District should be Anywhere")
        .isEqualToIgnoringCase("ANYWHERE");
  }

  @Test
  void testWithState() {
    Address address = new AddressBuilder()
        .withState("OH")
        .build();
    assertThat(address.getState())
        .as("State should be OH")
        .isEqualToIgnoringCase("OH");
  }

  @Test
  void testWithPostalCode() {
    Address address = new AddressBuilder()
        .withPostalCode("157890")
        .build();
    assertThat(address.getPostalCode())
        .as("Postal Code should be 157890")
        .isEqualToIgnoringCase("157890");
  }

  @Test
  void testWithCountry() {
    Address address = new AddressBuilder()
        .withCountry("USA")
        .build();
    assertThat(address.getCountry())
        .as("Country should be USA")
        .isEqualToIgnoringCase("USA");
  }

  @Test
  void testWithPeriod() {
    Period period = new Period();
    period.setStart(new Date());
    Address address = new AddressBuilder()
        .withPeriod(period)
        .build();
    assertThat(address.getPeriod())
        .as("Period should not be null")
        .isNotNull();

    assertThat(address.getPeriod().isEmpty())
        .as("Period should not be empty")
        .isFalse();
        
  }

  @Test
  void testWithId() {
    Address address = new AddressBuilder()
        .withId("MyID")
        .build();
  
    assertThat(address.getId())
        .as("Id should be MyID")
        .isEqualToIgnoringCase("MyID");
        
  }

  @Test
  void testAddExtension() {
    Extension extension = new Extension("http://www.myextension.com");
    extension.setValue(new StringType("MyValue"));

    Address address = new AddressBuilder()
        .addExtension(extension)
        .build();
    assertThat(address.getExtension())
        .as("Extension should be set with correct values")
        .isNotEmpty()
        .allSatisfy(ext -> {
          assertThat(ext.getUrl()).isEqualToIgnoringCase("http://www.myextension.com");
          StringType value = (StringType) ext.getValue();          
          assertThat(value.getValueAsString()).isEqualToIgnoringCase("MyValue");
        });

  }
  
}
