package com.lswebworld.builders.datatypes;

import com.lswebworld.builders.base.AbstractElementBuilder;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;

public class CodeableConceptBuilder 
    extends AbstractElementBuilder<CodeableConcept, CodeableConceptBuilder> {

  private final CodeableConcept concept;

  /**
   * Constructor.
   */
  public CodeableConceptBuilder() {
    super();
    concept = new CodeableConcept();
    super.initialize(concept);
  }

  /**
   * Adds a Coding Object to the Codeable Concept.
   * @param coding Coding
   * @return CodeableConceptBuilder
   */
  public CodeableConceptBuilder addCoding(Coding coding) {
    concept.addCoding(coding);
    return this;
  }

  /**
   * Sets the Text on the Codeable Concept.
   * @param text Text value.
   * @return CodeableConceptBuilder
   */
  public CodeableConceptBuilder withText(String text) {
    concept.setText(text);
    return this;
  }

  /**
   * Returns the constructed Codeable Concept.
   * @return Codeable Concept.
   */
  public CodeableConcept build() {
    return concept;
  }
  
}
