package com.lswebworld.builders.components.datatypes;

import com.lswebworld.builders.base.AbstractElementBuilder;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import org.hl7.fhir.r4.model.DataRequirement.DataRequirementDateFilterComponent;
import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.Duration;
import org.hl7.fhir.r4.model.Period;

public class DataRequirementDateFilterBuilder
    extends AbstractElementBuilder<DataRequirementDateFilterComponent,
        DataRequirementDateFilterBuilder> {

  private final DataRequirementDateFilterComponent component;

  /**
   * Constructor.
   */
  public DataRequirementDateFilterBuilder() {
    super();
    component = new DataRequirementDateFilterComponent();
    super.initialize(component);
  }

  /**
   * Sets the Path on the Date Filter.
   * @param path Path
   * @return DataRequirementDateFilterBuilder
   */
  public DataRequirementDateFilterBuilder withPath(String path) {
    component.setPath(path);
    return this;
  }

  /**
   * Sets the Search Parameter on the Date Filter.
   * @param searchParam Search Parameter
   * @return DataRequirementDateFilterBuilder
   */
  public DataRequirementDateFilterBuilder withSearchParam(String searchParam) {
    component.setSearchParam(searchParam);
    return this;
  }

  /**
   * Sets the value to the provided Java Util Date.
   * @param value Java Util Date
   * @return DataRequirementDateFilterBuilder
   */
  public DataRequirementDateFilterBuilder withValue(Date value) {
    component.setValue(new DateTimeType(value));
    return this;
  }

  /**
   * Sets the value to the provided Java Time Local Date Time.
   * @param value Java Time Local Date Time
   * @param offset Zone Offset
   * @return DataRequirementDateFilterBuilder
   */
  public DataRequirementDateFilterBuilder withValue(LocalDateTime value, ZoneOffset offset) {
    Date date = new Date(value.toEpochSecond(offset));
    component.setValue(new DateTimeType(date));
    return this;
  }

  /**
   * Sets the value to the provided Period.
   * @param period Period
   * @return DataRequirementDateFilterBuilder
   */
  public DataRequirementDateFilterBuilder withValue(Period period) {
    component.setValue(period);
    return this;
  }

  /**
   * Sets the value to the provided Duration.
   * @param duration Duration
   * @return DataRequirementDateFilterBuilder
   */
  public DataRequirementDateFilterBuilder withValue(Duration duration) {
    component.setValue(duration);
    return this;
  }

  public DataRequirementDateFilterComponent build() {
    return this.component;
  }

}
