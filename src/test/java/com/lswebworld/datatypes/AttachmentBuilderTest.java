package com.lswebworld.datatypes;

import static org.assertj.core.api.Assertions.assertThat;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Calendar;
import org.hl7.fhir.r4.model.Attachment;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.StringType;
import org.junit.jupiter.api.Test;

class AttachmentBuilderTest {

  @Test
  void testSetId() {
    Attachment attachment = new AttachmentBuilder()
        .withId("MyId")
        .build();
    assertThat(attachment.getId()).as("Id should be My Id").isEqualToIgnoringCase("MyId");
  }

  @Test
  void testAddExtension() {
    Extension extension = new Extension("http://myextension.com");
    extension.setValue(new StringType("MyValue"));

    Attachment attachment = new AttachmentBuilder()
        .addExtenstion(extension)
        .build();
    assertThat(attachment.getExtension()).as("Extensions should not be empty").isNotEmpty();
    assertThat(attachment.getExtension())
        .as("Url and value should be set")
        .allSatisfy(ext -> {
          StringType value = (StringType) ext.getValue();
          assertThat(value.getValueAsString())
              .as("Value should be MyValue")
              .isEqualToIgnoringCase("MyValue");
          assertThat(ext.getUrl())
              .as("Url should be http://myextension.com")
              .isEqualToIgnoringCase("http://myextension.com");
        });
  }

  @Test
  void testWithTitle() {
    Attachment attachment = new AttachmentBuilder()
        .withTitle("MyTitle")
        .build();

    assertThat(attachment.getTitle())
        .as("Attachment Title should be MyTitle")
        .isEqualToIgnoringCase("MyTitle");
  }

  @Test
  void testWithContentType() {
    Attachment attachment = new AttachmentBuilder()
        .withContentType("application/json")
        .build();
    assertThat(attachment.getContentType())
        .as("Content Typ should be application/json")
        .isEqualToIgnoringCase("application/json");
  }

  @Test
  void testWithLanguage() {
    Attachment attachment = new AttachmentBuilder()
        .withLanguage("en-US")
        .build();
    assertThat(attachment.getLanguage())
        .as("Language should be en-US")
        .isEqualToIgnoringCase("en-US");
  }

  @Test
  void testWithData() {
    byte[] myData = "MyData String".getBytes(StandardCharsets.UTF_8);
    Attachment attachment = new AttachmentBuilder()
        .withData(myData)
        .build();
    assertThat(attachment.getData())
        .as("Data should be populated")
        .isNotNull()
        .isEqualTo(myData);
  }

  @Test
  void testWithUrl() {
    Attachment attachment = new AttachmentBuilder()
        .withUrl("http://www.google.com")
        .build();
    assertThat(attachment.getUrl())
        .as("Url should be http://www.google.com")
        .isEqualToIgnoringCase("http://www.google.com");
  }

  @Test
  void testWithSize() {
    Attachment attachment = new AttachmentBuilder()
        .withSize(10)
        .build();
    assertThat(attachment.getSize())
        .as("Attachment Size should be 10")
        .isEqualTo(10);
  }

  @Test
  void testWithHash() {
    byte[] myHash = "Hash Value".getBytes(StandardCharsets.UTF_8);
    Attachment attachment = new AttachmentBuilder()
        .withHash(myHash)
        .build();

    assertThat(attachment.getHash())
        .as("Attachment Hash should be Hash Value")
        .isNotNull()
        .isEqualTo(myHash);
  }

  @Test
  void testWithCreationDate() {
    Calendar cal = Calendar.getInstance();
    cal.set(2020, 1, 15);
    Attachment attachment = new AttachmentBuilder()
        .withCreation(cal.getTime())
        .build();
    assertThat(attachment.getCreation().getTime())
        .as("Creation should be equal to 1/15/2020")
        .isEqualTo(cal.getTime().getTime());    
  }

  @Test
  void testWithCreationLocalDatetime() {
    LocalDateTime dts = LocalDateTime.of(2020, 1, 15, 0, 0);
    
    Attachment attachment = new AttachmentBuilder()
        .withCreation(dts)
        .build();
    assertThat(attachment.getCreation().getTime())
        .as("Creation should be 1/15/2020")
        .isEqualTo(dts.toEpochSecond(ZoneOffset.UTC));
  }

  
}
