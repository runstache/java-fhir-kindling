package com.lswebworld.datatypes;

import org.hl7.fhir.r4.model.Duration;
import org.hl7.fhir.r4.model.Period;
import org.hl7.fhir.r4.model.Range;
import org.hl7.fhir.r4.model.Timing;

public class TimingRepeatBuilder
    extends AbstractElementBuilder<Timing.TimingRepeatComponent, TimingRepeatBuilder> {

  private final Timing.TimingRepeatComponent component;

  /**
   * Constructor.
   */
  public TimingRepeatBuilder() {
    super();
    component = new Timing.TimingRepeatComponent();
    super.initialize(component);
  }

  /**
   * Sets the Timing Bounds to a Duration.
   * @param duration duration
   * @return TimingRepeatBuilder
   */
  public TimingRepeatBuilder withBounds(Duration duration) {
    component.setBounds(duration);
    return this;
  }

  /**
   * Sets the Timing Bounds to a Range.
   * @param range Range
   * @return TimingRepeatBuilder
   */
  public TimingRepeatBuilder withBounds(Range range) {
    component.setBounds(range);
    return this;
  }

  /**
   * Sets the Bounds to a Period.
   * @param period Period
   * @return TimingRepeatBuilder
   */
  public TimingRepeatBuilder withBounds(Period period) {
    component.setBounds(period);
    return this;
  }

  /**
   * Sets the Count to the provided integer.
   * @param count count
   * @return TimingRepeatBuilder
   */
  public TimingRepeatBuilder withCount(int count) {
    component.setCount(count);
    return this;
  }

  /**
   * Sets the Count max to the provided Integer.
   * @param countMax Count Max
   * @return TimingRepeatBuilder
   */
  public TimingRepeatBuilder withCountMax(int countMax) {
    component.setCountMax(countMax);
    return this;
  }

  /**
   * Sets the Duration to the provided double.
   * @param duration Duration
   * @return TimingRepeatBuilder
   */
  public TimingRepeatBuilder withDuration(double duration) {
    component.setDuration(duration);
    return this;
  }

  /**
   * Sets the Duration Max to the provided Double.
   * @param durationMax Duration Max
   * @return TimingRepeatBuilder
   */
  public TimingRepeatBuilder withDurationMax(double durationMax) {
    component.setDurationMax(durationMax);
    return this;
  }

  /**
   * Sets the Duration Unit to the provided Unit of Time code.
   * @param unit Unit of Time
   * @return TimingRepeatBuilder
   */
  public TimingRepeatBuilder withDurationUnit(Timing.UnitsOfTime unit) {
    component.setDurationUnit(unit);
    return this;
  }

  /**
   * Sets the Frequency to the provided Integer.
   * @param frequency Feequency
   * @return TimingRepeatBuilder
   */
  public TimingRepeatBuilder withFrequency(int frequency) {
    component.setFrequency(frequency);
    return this;
  }

  /**
   * Sets the Frequency to the provided Integer.
   * @param frequencyMax Frequency Max
   * @return TimingRepeatBuilder
   */
  public TimingRepeatBuilder withFrequencyMax(int frequencyMax) {
    component.setFrequencyMax(frequencyMax);
    return this;
  }

  /**
   * Sets the Period to the provided Double.
   * @param period Period
   * @return TimingRepeatBuilder
   */
  public TimingRepeatBuilder withPeriod(double period) {
    component.setPeriod(period);
    return this;
  }

  /**
   * Sets the Period max to the provided double.
   * @param periodMax Period Max
   * @return TimingRepeatBuilder
   */
  public TimingRepeatBuilder withPeriodMax(double periodMax) {
    component.setPeriodMax(periodMax);
    return this;
  }

  /**
   * Sets the Period Unit to the provided Unit of Time.
   * @param periodUnit Unit of Time Code
   * @return TimingRepeatBuilder
   */
  public TimingRepeatBuilder withPeriodUnit(Timing.UnitsOfTime periodUnit) {
    component.setPeriodUnit(periodUnit);
    return this;
  }

  /**
   * Adds a Day of Week to the provided Day of Week Code.
   * @param dayOfWeek Day Of Week Code
   * @return TimingRepeatBuilder
   */
  public TimingRepeatBuilder addDayOfWeek(Timing.DayOfWeek dayOfWeek) {
    component.addDayOfWeek(dayOfWeek);
    return this;
  }

  /**
   * Adds a Time of Day to the Repeat element.
   * @param timeOfDay Time of Day
   * @return TimingRepeatBuilder
   */
  public TimingRepeatBuilder addTimeOfDay(String timeOfDay) {
    component.addTimeOfDay(timeOfDay);
    return this;
  }

  /**
   * Adds an Event Timing code to the When property.
   * @param when Event Timing Code
   * @return TimingRepeatBuilder
   */
  public TimingRepeatBuilder addWhen(Timing.EventTiming when) {
    component.addWhen(when);
    return this;
  }

  /**
   * Sets the Offset to the provided integer.
   * @param offset Offset
   * @return TimingRepeatBuilder
   */
  public TimingRepeatBuilder withOffset(int offset) {
    component.setOffset(offset);
    return this;
  }

  /**
   * Returns the constructed Repeat Timing Component.
   * @return Timing Repeat Component
   */
  public Timing.TimingRepeatComponent build() {
    return this.component;
  }

}
