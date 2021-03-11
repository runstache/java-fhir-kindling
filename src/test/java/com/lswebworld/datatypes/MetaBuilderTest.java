package com.lswebworld.datatypes;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.Meta;
import org.hl7.fhir.r4.model.StringType;
import org.junit.jupiter.api.Test;

class MetaBuilderTest {

  @Test
  void withId() {
    Meta meta = new MetaBuilder()
        .withId("MyId")
        .build();
    assertThat(meta.getId())
        .as("Id should be My Id")
        .isEqualToIgnoringCase("MyId");
  }

  @Test
  void addExtension() {
    Extension extension = new Extension("http://www.myextension.com");
    extension.setValue(new StringType("MyValue"));

    Meta meta = new MetaBuilder()
        .addExtension(extension)
        .build();
    assertThat(meta.getExtension())
        .as("Extension should be set with correct values")
        .isNotEmpty()
        .allSatisfy(ext -> {
          assertThat(ext.getUrl()).isEqualToIgnoringCase("http://www.myextension.com");
          StringType value = (StringType) ext.getValue();
          assertThat(value.getValueAsString()).isEqualToIgnoringCase("MyValue");
        });
  }

  @Test
  void withVersionId() {
    Meta meta = new MetaBuilder()
        .withVersionId("v2.0")
        .build();
    assertThat(meta.getVersionId())
        .as("Version Id should be v2.0")
        .isEqualToIgnoringCase("v2.0");
  }

  @Test
  void testWithLastUpdated() {
    Meta meta = new MetaBuilder()
        .withLastUpdated(new Date())
        .build();
    assertThat(meta.getLastUpdated())
        .as("Last Updated Date should be populated")
        .isNotNull();
  }

  @Test
  void testWithLastUpdatedLocalDateTime() {
    Meta meta = new MetaBuilder()
        .withLastUpdated(LocalDateTime.now(), ZoneOffset.UTC)
        .build();
    assertThat(meta.getLastUpdated())
        .as("Last Updated Date should be populated")
        .isNotNull();
  }

  @Test
  void withSource() {
    Meta meta = new MetaBuilder()
        .withSource("http://www.google.com")
        .build();
    assertThat(meta.getSource())
        .as("Source should be http://www.google.com")
        .isEqualToIgnoringCase("http://www.google.com");
  }

  @Test
  void addProfile() {
    Meta meta = new MetaBuilder()
        .addProfile("/StructureDefinition/Patient-1234")
        .build();
    assertThat(meta.getProfile())
        .as("Profile should not be empty")
        .isNotEmpty()
        .allSatisfy(c -> assertThat(c.getValue()).isEqualToIgnoringCase("/StructureDefinition/Patient-1234"));
  }

  @Test
  void addSecurity() {
    Meta meta = new MetaBuilder()
        .addSecurity(new Coding("SECURITY.CODE.OID","SECURITY_CODE","ITS SECURITY"))
        .build();
    assertThat(meta.getSecurity())
        .as("Security should have a Coding")
        .isNotEmpty()
        .allSatisfy(code -> assertThat(code)
            .extracting("system", "code", "display")
            .containsOnly("SECURITY.CODE.OID","SECURITY_CODE","ITS SECURITY"));
  }

  @Test
  void addTag() {
    Meta meta = new MetaBuilder()
        .addTag(new Coding("MY.TAG.OID", "TAG", "TAG NAME"))
        .build();
    assertThat(meta.getTag())
        .as("Tag should be populated")
        .isNotEmpty()
        .allSatisfy(code -> assertThat(code)
            .extracting("system", "code", "display")
            .containsOnly("MY.TAG.OID", "TAG", "TAG NAME"));
  }
}