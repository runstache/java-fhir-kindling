package com.lswebworld.datatypes;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Date;
import org.hl7.fhir.r4.model.Duration;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.Period;
import org.hl7.fhir.r4.model.Quantity;
import org.hl7.fhir.r4.model.Range;
import org.hl7.fhir.r4.model.StringType;
import org.hl7.fhir.r4.model.Timing;
import org.junit.jupiter.api.Test;

class TimingRepeatBuilderTest {

  @Test
  void testWithId() {
    Timing.TimingRepeatComponent component = new TimingRepeatBuilder()
        .withId("MyId")
        .build();
    assertThat(component.getId())
        .as("Id should be MyId")
        .isEqualToIgnoringCase("MyId");
  }

  @Test
  void testAddExtension() {
    Extension extension = new Extension("http://myextension.org");
    extension.setValue(new StringType("MyStringValue"));

    Timing.TimingRepeatComponent component = new TimingRepeatBuilder()
        .addExtension(extension)
        .build();
    assertThat(component.getExtension())
        .as("Extension should be set")
        .isNotEmpty()
        .allSatisfy(ext -> {
          assertThat(ext.getUrl()).isEqualToIgnoringCase("http://myextension.org");
          assertThat(ext.getValue())
              .extracting(StringType.class::cast)
              .extracting(StringType::getValueAsString)
              .isEqualTo("MyStringValue");
        });
  }

  @Test
  void testWithBoundsDuration() {
    Duration duration = new Duration();
    duration.setValue(250);
    Timing.TimingRepeatComponent component = new TimingRepeatBuilder()
        .withBounds(duration)
        .build();
    assertThat(component.getBounds())
        .as("Bounds should be 250")
        .isNotNull()
        .extracting(Duration.class::cast)
        .extracting(Duration::getValue)
        .extracting(BigDecimal::longValue)
        .isEqualTo(250L);
  }

  @Test
  void testWithBoundsRange() {
    Range range = new Range();
    Quantity quantity = new Quantity();
    quantity.setValue(250);
    range.setHigh(quantity);
    Timing.TimingRepeatComponent component = new TimingRepeatBuilder()
        .withBounds(range)
        .build();
    assertThat(component.getBounds())
        .as("Bounds should be set to a Range.")
        .isNotNull()
        .extracting(Range.class::cast)
        .extracting(Range::getHigh)
        .extracting(Quantity::getValue)
        .extracting(BigDecimal::longValue)
        .isEqualTo(250L);
  }

  @Test
  void testWithBoundsPeriod() {
    Period period = new Period();
    period.setStart(new Date());

    Timing.TimingRepeatComponent component = new TimingRepeatBuilder()
        .withBounds(period)
        .build();
    assertThat(component.getBounds())
        .as("Bounds should be set to a Period")
        .isNotNull()
        .extracting(Period.class::cast)
        .extracting(Period::isEmpty)
        .isEqualTo(false);
  }

  @Test
  void testWithCount() {
    Timing.TimingRepeatComponent component = new TimingRepeatBuilder()
        .withCount(10)
        .build();
    assertThat(component.getCount())
        .as("Count should be 10")
        .isEqualTo(10);
  }

  @Test
  void testWithCountMax() {
    Timing.TimingRepeatComponent component = new TimingRepeatBuilder()
        .withCountMax(15)
        .build();
    assertThat(component.getCountMax())
        .as("Count Max should be 15")
        .isEqualTo(15);
  }

  @Test
  void testWithDuration() {
    Timing.TimingRepeatComponent component = new TimingRepeatBuilder()
        .withDuration(15.5)
        .build();
    assertThat(component.getDuration())
        .as("Duration should be 15.5")
        .isNotNull()
        .extracting(BigDecimal::doubleValue)
        .isEqualTo(15.5);
  }

  @Test
  void testWithDurationMax() {
    Timing.TimingRepeatComponent component = new TimingRepeatBuilder()
        .withDurationMax(20.5)
        .build();
    assertThat(component.getDurationMax())
        .as("Duration Max")
        .isNotNull()
        .extracting(BigDecimal::doubleValue)
        .isEqualTo(20.5);
  }

  @Test
  void testWithDurationUnit() {
    Timing.TimingRepeatComponent component = new TimingRepeatBuilder()
        .withDurationUnit(Timing.UnitsOfTime.D)
        .build();
    assertThat(component.getDurationUnit())
        .as("Duration Unti should be D")
        .isEqualTo(Timing.UnitsOfTime.D);
  }

  @Test
  void testWithFrequency() {
    Timing.TimingRepeatComponent component = new TimingRepeatBuilder()
        .withFrequency(50)
        .build();
    assertThat(component.getFrequency())
        .as("Frequency should be 50")
        .isEqualTo(50);
  }

  @Test
  void testWithFrequencyMax() {
    Timing.TimingRepeatComponent component = new TimingRepeatBuilder()
        .withFrequencyMax(75)
        .build();
    assertThat(component.getFrequencyMax())
        .as("Frequency Max should be 75")
        .isEqualTo(75);
  }

  @Test
  void testWithPeriod() {
    Timing.TimingRepeatComponent component = new TimingRepeatBuilder()
        .withPeriod(22.3)
        .build();
    assertThat(component.getPeriod())
        .as("Period should be 22.3")
        .isNotNull()
        .extracting(BigDecimal::doubleValue)
        .isEqualTo(22.3);
  }

  @Test
  void testWithPeriodMax() {
    Timing.TimingRepeatComponent component = new TimingRepeatBuilder()
        .withPeriodMax(35.2)
        .build();
    assertThat(component.getPeriodMax())
        .as("Period Max should be 35.3")
        .isNotNull()
        .extracting(BigDecimal::doubleValue)
        .isEqualTo(35.2);
  }

  @Test
  void testWithPeriodUnit() {
    Timing.TimingRepeatComponent component = new TimingRepeatBuilder()
        .withPeriodUnit(Timing.UnitsOfTime.H)
        .build();
    assertThat(component.getPeriodUnit())
        .as("Period Unit should be H")
        .isEqualTo(Timing.UnitsOfTime.H);
  }

  @Test
  void testAddDayOfWeek() {
    Timing.TimingRepeatComponent component = new TimingRepeatBuilder()
        .addDayOfWeek(Timing.DayOfWeek.MON)
        .build();
    assertThat(component.getDayOfWeek())
        .as("Day of Week should contain Mon")
        .isNotEmpty()
        .allSatisfy(dow -> assertThat(dow.getValue()).isEqualTo(Timing.DayOfWeek.MON));
  }

  @Test
  void testAddTimeOfDay() {
    Timing.TimingRepeatComponent component = new TimingRepeatBuilder()
        .addTimeOfDay("12:30:00")
        .build();
    assertThat(component.getTimeOfDay())
        .as("Time Of Day should contain 12:30:00")
        .isNotEmpty()
        .allSatisfy(time -> assertThat(time.getValueAsString()).isEqualToIgnoringCase("12:30:00"));
  }

  @Test
  void testAddWhen() {
    Timing.TimingRepeatComponent component = new TimingRepeatBuilder()
        .addWhen(Timing.EventTiming.ACD)
        .build();
    assertThat(component.getWhen())
        .as("When should contain ACD")
        .isNotEmpty()
        .allSatisfy(when -> assertThat(when.getValue()).isEqualTo(Timing.EventTiming.ACD));
  }

  @Test
  void testWithOffset() {
    Timing.TimingRepeatComponent component = new TimingRepeatBuilder()
        .withOffset(6)
        .build();
    assertThat(component.getOffset())
        .as("Offset should be 6")
        .isEqualTo(6);

  }
}