package com.lswebworld.components.datatypes;

import com.lswebworld.base.AbstractElementBuilder;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Dosage;
import org.hl7.fhir.r4.model.Range;
import org.hl7.fhir.r4.model.Ratio;
import org.hl7.fhir.r4.model.SimpleQuantity;

public class DoseAndRateBuilder
    extends AbstractElementBuilder<Dosage.DosageDoseAndRateComponent, DoseAndRateBuilder> {

  private final Dosage.DosageDoseAndRateComponent component;

  /**
   * Constructor.
   */
  public DoseAndRateBuilder() {
    super();
    component = new Dosage.DosageDoseAndRateComponent();
    super.initialize(component);
  }

  /**
   * Sets the Type of the Dose and Rate Component to the provided Codeable Concept.
   * @param type Type
   * @return DoseAndRateBuilder
   */
  public DoseAndRateBuilder withType(CodeableConcept type) {
    component.setType(type);
    return this;
  }

  /**
   * Sets the Dose to the provided Range.
   * @param dose Dose Range
   * @return DoseAndRateBuilder
   */
  public DoseAndRateBuilder withDose(Range dose) {
    component.setDose(dose);
    return this;
  }

  /**
   * Sets the Dose to the provided Simple Quantity.
   * @param dose Dose Simple Quantity
   * @return DoseAndRateBuilder
   */
  public DoseAndRateBuilder withDose(SimpleQuantity dose) {
    component.setDose(dose);
    return this;
  }

  /**
   * Sets the Rate to the provided Ratio.
   * @param rate Rate Ratio
   * @return DoseAndRateBuilder
   */
  public DoseAndRateBuilder withRate(Ratio rate) {
    component.setRate(rate);
    return this;
  }

  /**
   * Sets the Rate to the Provided Range.
   * @param rate Rate Range
   * @return DoseAndRateBuilder
   */
  public DoseAndRateBuilder withRate(Range rate) {
    component.setRate(rate);
    return this;
  }

  /**
   * Sets the Rate to the provided Simple Quantity.
   * @param rate Rate Simple Quantity.
   * @return DoseAndRateBuilder
   */
  public DoseAndRateBuilder withRate(SimpleQuantity rate) {
    component.setRate(rate);
    return this;
  }

  /**
   * Returns the Constructed Dose and Rate Component.
   * @return DosageDoseAndRateComponent
   */
  public Dosage.DosageDoseAndRateComponent build() {
    return this.component;
  }

}
