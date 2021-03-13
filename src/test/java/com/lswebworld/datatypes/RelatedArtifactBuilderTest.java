package com.lswebworld.datatypes;

import static org.assertj.core.api.Assertions.assertThat;

import org.hl7.fhir.r4.model.Attachment;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.RelatedArtifact;
import org.hl7.fhir.r4.model.RelatedArtifact.RelatedArtifactType;
import org.hl7.fhir.r4.model.StringType;
import org.junit.jupiter.api.Test;

class RelatedArtifactBuilderTest {

  @Test
  void testWithId() {
    RelatedArtifact artifact = new RelatedArtifactBuilder()
        .withId("MyId")
        .build();
    assertThat(artifact.getId())
        .as("Id should be MyId")
        .isEqualToIgnoringCase("MyId");
  }

  @Test
  void testAddExtension() {
    Extension extension = new Extension("http://www.myextension.com");
    extension.setValue(new StringType("MyValue"));

    RelatedArtifact artifact = new RelatedArtifactBuilder()
        .addExtension(extension)
        .build();
    assertThat(artifact.getExtension())
        .as("Extension should be set with correct values")
        .isNotEmpty()
        .allSatisfy(ext -> {
          assertThat(ext.getUrl()).isEqualToIgnoringCase("http://www.myextension.com");
          StringType value = (StringType) ext.getValue();
          assertThat(value.getValueAsString()).isEqualToIgnoringCase("MyValue");
        });
  }

  @Test
  void testWithType() {
    RelatedArtifact artifact = new RelatedArtifactBuilder()
        .withType(RelatedArtifactType.CITATION)
        .build();
    assertThat(artifact.getType())
        .as("Type should be Citation")
        .isEqualTo(RelatedArtifactType.CITATION);
  }

  @Test
  void testWithLabel() {
    RelatedArtifact artifact = new RelatedArtifactBuilder()
        .withLabel("MyLabel")
        .build();
    assertThat(artifact.getLabel())
        .as("Label should be MyLabel")
        .isEqualToIgnoringCase("MyLabel");
  }

  @Test
  void testWithDisplay() {
    RelatedArtifact artifact = new RelatedArtifactBuilder()
        .withDisplay("MyDisplay")
        .build();
    assertThat(artifact.getDisplay())
        .as("Display should be MyDisplay")
        .isEqualToIgnoringCase("MyDisplay");
  }

  @Test
  void testWithCitation() {
    RelatedArtifact artifact = new RelatedArtifactBuilder()
        .withCitation("MyCitationMarkdown")
        .build();
    assertThat(artifact.getCitation())
        .as("Citation should by MyCitationMarkdown")
        .isEqualToIgnoringCase("MyCitationMarkdown");
  }

  @Test
  void testWithUrl() {
    RelatedArtifact artifact = new RelatedArtifactBuilder()
        .withUrl("www.google.com")
        .build();
    assertThat(artifact.getUrl())
        .as("Url should be www.google.com")
        .isEqualToIgnoringCase("www.google.com");
  }

  @Test
  void testWithDocument() {
    Attachment attachment = new Attachment();
    attachment.setUrl("/data/document/doc.pdf");
    RelatedArtifact artifact = new RelatedArtifactBuilder()
        .withDocument(attachment)
        .build();
    assertThat(artifact.getDocument())
        .as("Document Attachment should be Populated")
        .extracting(Attachment::getUrl)
        .isEqualTo("/data/document/doc.pdf");
  }

  @Test
  void testWithResource() {
    RelatedArtifact artifact = new RelatedArtifactBuilder()
        .withResource("DocumentReference/12345")
        .build();
    assertThat(artifact.getResource())
        .as("Resource should be DocumentReference/12345")
        .isEqualToIgnoringCase("DocumentReference/12345");
  }
}