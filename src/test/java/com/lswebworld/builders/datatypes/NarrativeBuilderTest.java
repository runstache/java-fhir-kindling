package com.lswebworld.builders.datatypes;

import static org.assertj.core.api.Assertions.assertThat;

import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.Narrative;
import org.hl7.fhir.r4.model.StringType;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.junit.jupiter.api.Test;

class NarrativeBuilderTest {

  @Test
  void testWithId() {
    Narrative narrative = new NarrativeBuilder()
        .withId("MyId")
        .build();
    assertThat(narrative.getId())
        .as("Id should be My Id")
        .isEqualToIgnoringCase("MyId");
  }

  @Test
  void testAddExtension() {
    Extension extension = new Extension("http://www.myextension.com");
    extension.setValue(new StringType("MyValue"));

    Narrative narrative = new NarrativeBuilder()
        .addExtension(extension)
        .build();
    assertThat(narrative.getExtension())
        .as("Extension should be set with correct values")
        .isNotEmpty()
        .allSatisfy(ext -> {
          assertThat(ext.getUrl()).isEqualToIgnoringCase("http://www.myextension.com");
          StringType value = (StringType) ext.getValue();
          assertThat(value.getValueAsString()).isEqualToIgnoringCase("MyValue");
        });
  }

  @Test
  void testWithStatus() {
    Narrative narrative = new NarrativeBuilder()
        .withStatus(Narrative.NarrativeStatus.GENERATED)
        .build();
    assertThat(narrative.getStatus())
        .as("Status should be Generated")
        .isEqualTo(Narrative.NarrativeStatus.GENERATED);
  }

  @Test
  void testWithDiv() {
    XhtmlNode node = new XhtmlNode();
    node.setValue("<div>My Value</div>");

    Narrative narrative = new NarrativeBuilder()
        .withDiv(node)
        .build();
    assertThat(narrative.getDiv())
        .as("Node should have a Div Value")
        .extracting(XhtmlNode::getValue)
        .isEqualTo("<div xmlns=\"http://www.w3.org/1999/xhtml\">My Value</div>");
  }

  @Test
  void testWithDivString() {
    Narrative narrative = new NarrativeBuilder()
        .withDiv("<div>My Value</div>")
        .build();
    assertThat(narrative.getDiv())
        .as("Node should have a Div Value")
        .extracting(XhtmlNode::getValue)
        .isEqualTo("<div xmlns=\"http://www.w3.org/1999/xhtml\">My Value</div>");
  }
}