package com.lswebworld.datatypes;

import com.lswebworld.base.AbstractBackboneElementBuilder;
import org.hl7.fhir.r4.model.BooleanType;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Dosage;
import org.hl7.fhir.r4.model.Quantity;
import org.hl7.fhir.r4.model.Ratio;
import org.hl7.fhir.r4.model.Timing;

public class DosageBuilder extends AbstractBackboneElementBuilder<Dosage, DosageBuilder> {

  private final Dosage dosage;

  /**
   * Constructor.
   */
  public DosageBuilder() {
    super();
    dosage = new Dosage();
    super.initialize(dosage);
  }

  /**
   * Sets the Sequence for the dosage.
   * @param sequence Sequence
   * @return DosageBuilder
   */
  public DosageBuilder withSequence(int sequence) {
    dosage.setSequence(sequence);
    return this;
  }

  /**
   * Sets the Text on the Dosage.
   * @param text Text
   * @return DosageBuilder
   */
  public DosageBuilder withText(String text) {
    dosage.setText(text);
    return this;
  }

  /**
   * Adds a Codeable Concept to the Additional Instructions Collection.
   * @param additionalInstruction Additional Instructions
   * @return DosageBuilder
   */
  public DosageBuilder addAdditionalInstruction(CodeableConcept additionalInstruction) {
    dosage.addAdditionalInstruction(additionalInstruction);
    return this;
  }

  /**
   * Sets the Patient Instructions on the Dosage.
   * @param patientInstruction Patient Instructions
   * @return DosageBuilder
   */
  public DosageBuilder withPatientInstruction(String patientInstruction) {
    dosage.setPatientInstruction(patientInstruction);
    return this;
  }

  /**
   * Sets the Dosage Timing.
   * @param timing Timing
   * @return DosageBuilder
   */
  public DosageBuilder withTiming(Timing timing) {
    dosage.setTiming(timing);
    return this;
  }

  /**
   * Sets the As Needed to a Boolean Value.
   * @param asNeeded As Needed Boolean
   * @return DosageBuilder
   */
  public DosageBuilder withAsNeeded(boolean asNeeded) {
    dosage.setAsNeeded(new BooleanType(asNeeded));
    return this;
  }

  /**
   * Sets the As Needed to a Codeable Concept.
   * @param asNeeded As Needed Codeable Concept
   * @return DosageBuilder
   */
  public DosageBuilder withAsNeeded(CodeableConcept asNeeded) {
    dosage.setAsNeeded(asNeeded);
    return this;
  }

  /**
   * Sets the Site of the Dosage to the provided Codeable Concept.
   * @param site Dosage Site
   * @return DosageBuilder
   */
  public DosageBuilder withSite(CodeableConcept site) {
    dosage.setSite(site);
    return this;
  }

  /**
   * Sets the Route of the Dosage to the provided Codeable Concept.
   * @param route Dosage Route
   * @return DosageBuilder
   */
  public DosageBuilder withRoute(CodeableConcept route) {
    dosage.setRoute(route);
    return this;
  }

  /**
   * Sets the Method of the Dosage to the provided Codeable Concept.
   * @param method Dosage Method
   * @return DosageBuilder
   */
  public DosageBuilder withMethod(CodeableConcept method) {
    dosage.setMethod(method);
    return this;
  }

  /**
   * Adds a Dose and Rate Component to the Dosage.
   * @param component Dose and Rate Component.
   * @return DosageBuilder
   */
  public DosageBuilder addDoseAndRate(Dosage.DosageDoseAndRateComponent component) {
    dosage.addDoseAndRate(component);
    return this;
  }


  /**
   * Sets the Max Dose per period to the provided Ratio.
   * @param maxDosePerPeriod Max Does Per Period.
   * @return DosageBuilder
   */
  public DosageBuilder withMaxDosePerPeriod(Ratio maxDosePerPeriod) {
    dosage.setMaxDosePerPeriod(maxDosePerPeriod);
    return this;
  }

  /**
   * Sets the Max Dose per Administration to the provided Simple Quantity.
   * @param maxDosePerAdministration Max Does Per Administration
   * @return DosageBuilder
   */
  public DosageBuilder withMaxDosePerAdministration(Quantity maxDosePerAdministration) {
    dosage.setMaxDosePerAdministration(maxDosePerAdministration);
    return this;
  }

  /**
   * Sets the Max Dose per Lifetime to the provided Simple Quantity.
   * @param maxDosePerLifetime Max Dose per Lifetime
   * @return DosageBuilder
   */
  public DosageBuilder withMaxDosePerLifetime(Quantity maxDosePerLifetime) {
    dosage.setMaxDosePerLifetime(maxDosePerLifetime);
    return this;
  }

  /**
   * Returns the Constructed Dosage.
   * @return Dosage
   */
  public Dosage build() {
    return this.dosage;
  }
}
