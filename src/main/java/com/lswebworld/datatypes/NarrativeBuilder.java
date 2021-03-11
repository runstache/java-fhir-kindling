package com.lswebworld.datatypes;

import org.hl7.fhir.r4.model.Narrative;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class NarrativeBuilder extends AbstractElementBuilder<Narrative, NarrativeBuilder> {

  private Narrative narrative;

  /**
   * Constructor.
   */
  public NarrativeBuilder() {
    super();
    narrative = new Narrative();
    super.initialize(narrative);
  }

  /**
   * Sets the Status to the provided Narrative Status.
   * @param status Narrative Status
   * @return NarrativeBuilder
   */
  public NarrativeBuilder withStatus(Narrative.NarrativeStatus status) {
    narrative.setStatus(status);
    return this;
  }

  /**
   * Sets the Narrative Div to the provided xhtml node.
   * @param div Div Value.
   * @return NarrativeBuilder
   */
  public NarrativeBuilder withDiv(XhtmlNode div) {
    narrative.setDiv(div);
    return this;
  }

  /**
   * Sets the Narrative Div to the provided XHTML String.
   * @param div XHMTL String
   * @return NarrativeBuilder
   */
  public NarrativeBuilder withDiv(String div) {
    narrative.setDiv(new XhtmlNode().setValue(div));
    return this;
  }

  /**
   * Returns the Constructed Narrative.
   * @return Narrative
   */
  public Narrative build() {
    return this.narrative;
  }

}
