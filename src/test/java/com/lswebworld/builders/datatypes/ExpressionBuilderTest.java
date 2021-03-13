package com.lswebworld.builders.datatypes;

import static org.assertj.core.api.Assertions.assertThat;

import org.hl7.fhir.r4.model.Expression;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.StringType;
import org.junit.jupiter.api.Test;

class ExpressionBuilderTest {

  @Test
  void testWithId() {
    Expression expression = new ExpressionBuilder()
        .withId("MyId")
        .build();
    assertThat(expression.getId())
        .as("Id should be MyId")
        .isEqualToIgnoringCase("MyId");
  }

  @Test
  void testAddExtension() {
    Extension extension = new Extension("http://www.myextension.com");
    extension.setValue(new StringType("MyValue"));

    Expression expression = new ExpressionBuilder()
        .addExtension(extension)
        .build();
    assertThat(expression.getExtension())
        .as("Extension should be set with correct values")
        .isNotEmpty()
        .allSatisfy(ext -> {
          assertThat(ext.getUrl()).isEqualToIgnoringCase("http://www.myextension.com");
          StringType value = (StringType) ext.getValue();
          assertThat(value.getValueAsString()).isEqualToIgnoringCase("MyValue");
        });
  }

  @Test
  void testWithDescription() {
    Expression expression = new ExpressionBuilder()
        .withDescription("My Expression")
        .build();
    assertThat(expression.getDescription())
        .as("Description should be My Expression")
        .isEqualToIgnoringCase("My Expression");
  }

  @Test
  void testWithName() {
    Expression expression = new ExpressionBuilder()
        .withName("Super Expression")
        .build();
    assertThat(expression.getName())
        .as("Name should be Super Expression")
        .isEqualToIgnoringCase("Super Expression");
  }

  @Test
  void testWithLanguage() {
    Expression expression = new ExpressionBuilder()
        .withLanguage("cql")
        .build();
    assertThat(expression.getLanguage())
        .as("Language should be cql")
        .isEqualToIgnoringCase("cql");
  }

  @Test
  void testWithExpression() {
    Expression expression = new ExpressionBuilder()
        .withExpression("f = 132")
        .build();
    assertThat(expression.getExpression())
        .as("Expression should be f = 132")
        .isEqualToIgnoringCase("f = 132");
  }

  @Test
  void testWithReference() {
    Expression expression = new ExpressionBuilder()
        .withReference("Expression/12345")
        .build();
    assertThat(expression.getReference())
        .as("Reference should be Expression/12345")
        .isEqualToIgnoringCase("Expression/12345");
  }
}