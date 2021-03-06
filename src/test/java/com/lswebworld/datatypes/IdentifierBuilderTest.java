package com.lswebworld.datatypes;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Calendar;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.Identifier.IdentifierUse;
import org.hl7.fhir.r4.model.Period;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.StringType;
import org.junit.jupiter.api.Test;

class IdentifierBuilderTest {

  @Test
  void testWithId() {
    Identifier id = new IdentifierBuilder()
        .withId("MyId")
        .build();
    assertThat(id.getId()).as("Id should be MyId").isEqualToIgnoringCase("MyId");
  }

  @Test
  void testAddExtension() {
    Extension ext = new Extension("http://www.extension.org");
    ext.setValue(new StringType("MyValue"));

    Identifier id = new IdentifierBuilder()
        .addExtension(ext)
        .build();
    assertThat(id.getExtension())
        .as("Extension should not be empty")
        .isNotEmpty()
        .allSatisfy(e -> {
          assertThat(e.getUrl())
              .as("Url should be http://www.extension.org")
              .isEqualToIgnoringCase("http://www.extension.org");
          StringType value = (StringType) e.getValue();
          
          assertThat(value.getValueAsString())
              .as("Value should be MyValue")
              .isEqualToIgnoringCase("MyValue");
        });
  }

  @Test
  void testWithUse() {
    Identifier id = new IdentifierBuilder()
        .withUse(IdentifierUse.USUAL)
        .build();
    assertThat(id.getUse())
        .as("Use should be Usual")
        .isEqualTo(IdentifierUse.USUAL);
  }

  @Test
  void testWithType() {
    CodeableConcept concept = new CodeableConcept();
    concept.addCoding(new Coding("MyCode.Code.Oid", "MyCode", "Code Display"));
    concept.setText("Code Display");

    Identifier id = new IdentifierBuilder()
        .withType(concept)
        .build();
    assertThat(id.getType().getCoding())
        .as("Type Coding should be populated")
        .allSatisfy(code -> {
          assertThat(code.getSystem())
              .as("Code System should be MyCode.Code.Oid")
              .isEqualToIgnoringCase("MyCode.Code.Oid");
          assertThat(code.getCode())
              .as("Code Value should be MyCode")
              .isEqualToIgnoringCase("MyCode");
          assertThat(code.getDisplay())
              .as("Code Display should be Code Display")
              .isEqualToIgnoringCase("Code Display");
        });
    assertThat(id.getType().getText())
        .as("Type Text should be Code Display")
        .isEqualToIgnoringCase("Code Display");      
  }

  @Test
  void testWithSystem() {
    Identifier id = new IdentifierBuilder()
        .withSystem("TEST.MRN.OID")
        .build();
    assertThat(id.getSystem())
        .as("System should be TEST.MRN.OID")
        .isEqualToIgnoringCase("TEST.MRN.OID");
  }

  @Test
  void testWithValue() {
    Identifier id = new IdentifierBuilder()
        .withValue("12345")
        .build();
    assertThat(id.getValue())
        .as("Value should be 12345")
        .isEqualTo("12345");
  }

  @Test
  void testWithPeriod() {
    Calendar start = Calendar.getInstance();
    start.set(2020, 1, 15);
    Calendar end = Calendar.getInstance();
    end.set(2020, 4, 11);
    
    Period period = new Period();
    period.setStart(start.getTime());
    period.setEnd(end.getTime());

    Identifier id = new IdentifierBuilder()
        .withPeriod(period)
        .build();
    assertThat(id.getPeriod().getStart())
        .as("Period should have the Start of 1/15/2020")
        .isEqualTo(start.getTime());
    assertThat(id.getPeriod().getEnd())
        .as("Period should have the end of 4/11/2020")
        .isEqualTo(end.getTime());
  }

  @Test
  void testWithAssigner() {
    Reference reference = new Reference("Patient/1234");
    Identifier id = new IdentifierBuilder()
        .withAssigner(reference)
        .build();
    assertThat(id.getAssigner())
        .as("Reference should be Patient/1234")
        .extracting("reference")
        .isEqualTo("Patient/1234");
  }
  
}
