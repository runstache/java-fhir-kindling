package com.lswebworld.builders.datatypes;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.HumanName;
import org.hl7.fhir.r4.model.HumanName.NameUse;
import org.hl7.fhir.r4.model.Period;
import org.hl7.fhir.r4.model.StringType;
import org.junit.jupiter.api.Test;

class HumanNameBuilderTest {

  @Test
  void testWithUse() {
    HumanName name = new HumanNameBuilder()
        .withUse(NameUse.USUAL)
        .build();
    
    assertThat(name.getUse())
        .as("Name Use should be Usual")
        .isEqualTo(NameUse.USUAL);    
  }

  @Test
  void testWithText() {
    HumanName name = new HumanNameBuilder()
        .withText("JOHN SMITH")
        .build();
    assertThat(name.getText())
        .as("Name Text should be John Smith")
        .isEqualToIgnoringCase("JOHN SMITH");
  }

  @Test
  void testWithFamily() {
    HumanName name = new HumanNameBuilder()
        .withFamily("SMITH")
        .build();
    assertThat(name.getFamily())
        .as("Family should be SMITH")
        .isEqualToIgnoringCase("SMITH");
  }

  @Test
  void testAddGiven() {
    HumanName name = new HumanNameBuilder()
        .addGiven("JOHN")
        .addGiven("M")
        .build();
    assertThat(name.getGiven())
        .as("Given should contain JOHN and M")
        .extracting(StringType.class::cast)
        .extracting(StringType::getValueAsString)
        .containsOnly("JOHN", "M");
  }

  @Test
  void testAddPrefix() {
    HumanName name = new HumanNameBuilder()
        .addPrefix("MR")
        .build();
    assertThat(name.getPrefix())
        .as("Prefix should contain Mr")
        .extracting(StringType.class::cast)
        .extracting(StringType::getValueAsString)
        .containsOnly("MR");
  }

  @Test
  void testAddSuffix() {
    HumanName name = new HumanNameBuilder()
        .addSuffix("JR")
        .build();
    assertThat(name.getSuffix())
        .as("Suffix should contain Jr")
        .extracting(StringType.class::cast)
        .extracting(StringType::getValueAsString)
        .containsOnly("JR");
  }

  @Test
  void testWithPeriod() {
    Period period = new Period();
    period.setStart(new Date());
    period.setEnd(new Date());
    
    HumanName name = new HumanNameBuilder()
        .withPeriod(period)
        .build();
    assertThat(name.getPeriod())
        .as("Period should be set")
        .isNotNull();
    assertThat(name.getPeriod().isEmpty())
        .as("Period should not be empty")
        .isFalse();        
  }

  @Test
  void testWithId() {
    HumanName name = new HumanNameBuilder()
        .withId("MyID")
        .build();
  
    assertThat(name.getId())
        .as("Id should be MyID")
        .isEqualToIgnoringCase("MyID");
        
  }

  @Test
  void testAddExtension() {
    Extension extension = new Extension("http://www.myextension.com");
    extension.setValue(new StringType("MyValue"));

    HumanName name = new HumanNameBuilder()
        .addExtension(extension)
        .build();
    assertThat(name.getExtension())
        .as("Extension should be set with correct values")
        .isNotEmpty()
        .allSatisfy(ext -> {
          assertThat(ext.getUrl()).isEqualToIgnoringCase("http://www.myextension.com");
          StringType value = (StringType) ext.getValue();          
          assertThat(value.getValueAsString()).isEqualToIgnoringCase("MyValue");
        });

  }
  
}
