package com.lswebworld.datatypes;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import org.hl7.fhir.r4.model.Period;
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
}
