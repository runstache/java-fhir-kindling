package com.lswebworld.builders.datatypes;

import com.lswebworld.builders.base.AbstractElementBuilder;
import org.hl7.fhir.r4.model.Attachment;
import org.hl7.fhir.r4.model.RelatedArtifact;
import org.hl7.fhir.r4.model.RelatedArtifact.RelatedArtifactType;

public class RelatedArtifactBuilder
    extends AbstractElementBuilder<RelatedArtifact, RelatedArtifactBuilder> {

  private final RelatedArtifact artifact;

  /**
   * Constructor.
   */
  public RelatedArtifactBuilder() {
    super();
    artifact = new RelatedArtifact();
    super.initialize(artifact);
  }

  /**
   * Sets the Type on the Related Artifact.
   * @param type Type
   * @return RelatedArtifactBuilder
   */
  public RelatedArtifactBuilder withType(RelatedArtifactType type) {
    artifact.setType(type);
    return this;
  }

  /**
   * Sets the Label on the Related Artifact.
   * @param label Label value
   * @return RelatedArtifactBuilder
   */
  public RelatedArtifactBuilder withLabel(String label) {
    artifact.setLabel(label);
    return this;
  }

  /**
   * Sets the Display on the Related Artifact.
   * @param display Display
   * @return RelatedArtifactBuilder
   */
  public RelatedArtifactBuilder withDisplay(String display) {
    artifact.setDisplay(display);
    return this;
  }

  /**
   * Sets the Citation on the Related Artifact.
   * @param citation Citation
   * @return RelatedArtifactBuilder
   */
  public RelatedArtifactBuilder withCitation(String citation) {
    artifact.setCitation(citation);
    return this;
  }

  /**
   * Sets the Url of the Related Artifact.
   * @param url Url
   * @return RelatedArtifactBuilder
   */
  public RelatedArtifactBuilder withUrl(String url) {
    artifact.setUrl(url);
    return this;
  }

  /**
   * Sets the Document of the Related Artifact to the provided Attachment.
   * @param document Document Attachment
   * @return RelatedArtifactBuilder
   */
  public RelatedArtifactBuilder withDocument(Attachment document) {
    artifact.setDocument(document);
    return this;
  }

  /**
   * Sets the Canonical Url for a Resource on the Related Artifact.
   * @param resource Canonical Url
   * @return RelatedArtifactBuilder
   */
  public RelatedArtifactBuilder withResource(String resource) {
    artifact.setResource(resource);
    return this;
  }

  /**
   * Returns the constructed Related Artifact.
   * @return Related Artifact
   */
  public RelatedArtifact build() {
    return this.artifact;
  }
}
