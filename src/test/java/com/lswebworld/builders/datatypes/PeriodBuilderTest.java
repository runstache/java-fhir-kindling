package com.lswebworld.builders.datatypes;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.Period;
import org.hl7.fhir.r4.model.StringType;
import org.junit.jupiter.api.Test;

class PeriodBuilderTest {

  @Test
  void testWithStart() {
    Period period = new PeriodBuilder()
        .withStart(new Date())
        .build();
    
    assertThat(period.getStart())
        .as("Start Date should not be null")
        .isNotNull();
  }

  @Test
  void testWithStartLocalDateTime() {
    LocalDateTime ldt = LocalDateTime.now();
    Period period = new PeriodBuilder()
        .withStart(ldt, ZoneOffset.UTC)
        .build();
    
    assertThat(period.getStart())
        .as("Start Date should not be null")
        .isNotNull();
  }

  @Test
  void testWithEnd() {
    Period period = new PeriodBuilder()
        .withEnd(new Date())
        .build();
    assertThat(period.getEnd())
        .as("End Date should not be null")
        .isNotNull();
  }

  @Test
  void testWithEndLocalDateTime() {
    LocalDateTime ldt = LocalDateTime.now();
    Period period = new PeriodBuilder()
        .withEnd(ldt, ZoneOffset.UTC)
        .build();
    assertThat(period.getEnd())
        .as("End Date should not be empty")
        .isNotNull();
  }  

  @Test
  void testWithId() {
    Period period = new PeriodBuilder()
        .withId("MyID")
        .build();
  
    assertThat(period.getId())
        .as("Id should be MyID")
        .isEqualToIgnoringCase("MyID");
        
  }

  @Test
  void testAddExtension() {
    Extension extension = new Extension("http://www.myextension.com");
    extension.setValue(new StringType("MyValue"));

    Period period = new PeriodBuilder()
        .addExtension(extension)        
        .build();
    assertThat(period.getExtension())
        .as("Extension should be set with correct values")
        .isNotEmpty()
        .allSatisfy(ext -> {
          assertThat(ext.getUrl()).isEqualToIgnoringCase("http://www.myextension.com");
          StringType value = (StringType) ext.getValue();          
          assertThat(value.getValueAsString()).isEqualToIgnoringCase("MyValue");
        });

  }
}
