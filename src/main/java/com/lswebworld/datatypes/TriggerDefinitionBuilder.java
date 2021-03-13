package com.lswebworld.datatypes;

import com.lswebworld.base.AbstractElementBuilder;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import org.hl7.fhir.r4.model.DataRequirement;
import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.Expression;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.Timing;
import org.hl7.fhir.r4.model.TriggerDefinition;
import org.hl7.fhir.r4.model.TriggerDefinition.TriggerType;

public class TriggerDefinitionBuilder
    extends AbstractElementBuilder<TriggerDefinition, TriggerDefinitionBuilder> {

  private final TriggerDefinition trigger;

  /**
   * Constructor.
   */
  public TriggerDefinitionBuilder() {
    super();
    trigger = new TriggerDefinition();
    super.initialize(trigger);
  }

  /**
   * Sets the Type on the Trigger Definition.
   * @param type Type
   * @return TriggerDefinitionBuilder
   */
  public TriggerDefinitionBuilder withType(TriggerType type) {
    trigger.setType(type);
    return this;
  }

  /**
   * Sets the Name of the Trigger Definition.
   * @param name Name
   * @return TriggerDefinitionBuilder
   */
  public TriggerDefinitionBuilder withName(String name) {
    trigger.setName(name);
    return this;
  }

  /**
   * Sets the Timing on the Trigger Definition to the provided Timing.
   * @param timing Timing
   * @return TriggerDefinitionBuilder
   */
  public TriggerDefinitionBuilder withTiming(Timing timing) {
    trigger.setTiming(timing);
    return this;
  }

  /**
   * Sets the Timing to the provided Reference.
   * @param timing Reference
   * @return TriggerDefinitionBuilder
   */
  public TriggerDefinitionBuilder withTiming(Reference timing) {
    trigger.setTiming(timing);
    return this;
  }

  /**
   * Sets the Timing to the provided Java Util Date.
   * @param timing Java Util Date
   * @return TriggerDefinitionBuilder
   */
  public TriggerDefinitionBuilder withTiming(Date timing) {
    trigger.setTiming(new DateTimeType(timing));
    return this;
  }

  /**
   * Sets the Timing to the Provided Java Time Local Date Time with Offset.
   * @param timing Java Time Local Date Time
   * @param offset Zone Offset
   * @return TriggerDefinitionBuilder
   */
  public TriggerDefinitionBuilder withTiming(LocalDateTime timing, ZoneOffset offset) {
    Date date = new Date(timing.toEpochSecond(offset));
    trigger.setTiming(new DateTimeType(date));
    return this;
  }

  /**
   * Adds the provided Data Requirement to the Trigger Definition.
   * @param data Data Requirement
   * @return TriggerDefinitionBuilder
   */
  public TriggerDefinitionBuilder addData(DataRequirement data) {
    trigger.addData(data);
    return this;
  }

  /**
   * Sets the Condition on the Trigger Definition.
   * @param condition Expression
   * @return TriggerDefinitionBuilder
   */
  public TriggerDefinitionBuilder withCondition(Expression condition) {
    trigger.setCondition(condition);
    return this;
  }

  /**
   * Returns the Constructed Trigger Definition.
   * @return Trigger Definition
   */
  public TriggerDefinition build() {
    return this.trigger;
  }
}
