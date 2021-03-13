package com.lswebworld.datatypes;

import com.lswebworld.base.AbstractBackboneElementBuilder;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Timing;

public class TimingBuilder extends AbstractBackboneElementBuilder<Timing, TimingBuilder> {

  private final Timing timing;

  /**
   * Constructor.
   */
  public TimingBuilder() {
    super();
    timing = new Timing();
    super.initialize(timing);
  }

  /**
   * Adds a Java Util Date value to the Event.
   * @param event Date
   * @return TimingBuilder
   */
  public TimingBuilder addEvent(Date event) {
    timing.addEvent(event);
    return this;
  }

  /**
   * Adds a Java Time local time value to the Event.
   * @param event Local Date Time
   * @param offset Time Zone Offset
   * @return TimingBuilder
   */
  public TimingBuilder addEvent(LocalDateTime event, ZoneOffset offset) {
    timing.addEvent(new Date(event.toEpochSecond(offset)));
    return this;
  }

  /**
   * Sets the Timing Repeat Component.
   * @param component Repeat Component
   * @return TimingBuilder
   */
  public TimingBuilder withRepeat(Timing.TimingRepeatComponent component) {
    timing.setRepeat(component);
    return this;
  }

  /**
   * Sets the Code to the provided Codeable Concept.
   * @param code Codeable Concept.
   * @return TimingBuilder
   */
  public TimingBuilder withCode(CodeableConcept code) {
    timing.setCode(code);
    return this;
  }

  /**
   * Returns the constructed Timing.
   * @return Timing
   */
  public Timing build() {
    return this.timing;
  }





}
