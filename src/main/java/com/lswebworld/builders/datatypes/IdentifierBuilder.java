package com.lswebworld.builders.datatypes;

import com.lswebworld.builders.base.AbstractElementBuilder;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.Identifier.IdentifierUse;
import org.hl7.fhir.r4.model.Period;
import org.hl7.fhir.r4.model.Reference;

public class IdentifierBuilder extends AbstractElementBuilder<Identifier, IdentifierBuilder> {

  private final Identifier identifier;

  /**
   * Constructor.
   */
  public IdentifierBuilder() {
    super();
    this.identifier = new Identifier();
    super.initialize(identifier);
  }

  /**
   * Sets the Identifier Use.
   * @param use Identifier Use
   * @return IdentifierBuilder
   */
  public IdentifierBuilder withUse(IdentifierUse use) {
    identifier.setUse(use);
    return this;
  }

  /**
   * Sets the Identifier Type to the provided Codeable Concept. 
   * @param type Identifier Type
   * @return IdentifierBuilder
   */
  public IdentifierBuilder withType(CodeableConcept type) {
    identifier.setType(type);
    return this;
  }

  /**
   * Sets the Identifier System.
   * @param system Identifier System.
   * @return IdentifierBuilder
   */
  public IdentifierBuilder withSystem(String system) {
    identifier.setSystem(system);
    return this;
  }

  /**
   * Sets the Identifier Value.
   * @param value Identifier Value
   * @return IdentifierBuilder
   */
  public IdentifierBuilder withValue(String value) {
    identifier.setValue(value);
    return this;
  }

  /**
   * Sets the Identifier Period of use.
   * @param period Period.
   * @return IdentifierBuilder
   */
  public IdentifierBuilder withPeriod(Period period) {
    identifier.setPeriod(period);
    return this;
  }

  /**
   * Sets the Reference to the Identifier Assigner.
   * @param assigner Reference to the Assigner
   * @return IdentifierBuilder
   */
  public IdentifierBuilder withAssigner(Reference assigner) {
    identifier.setAssigner(assigner);
    return this;
  }

  /**
   * Returns the created Identifier.
   * @return Identifier
   */
  public Identifier build() {
    return this.identifier;
  }
  
}
