package com.lswebworld.datatypes;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import org.hl7.fhir.r4.model.Attachment;

public class AttachmentBuilder extends AbstractElementBuilder<Attachment, AttachmentBuilder> {

  private Attachment attachment;

  /**
   * Constructor.
   */
  public AttachmentBuilder() {
    super();
    attachment = new Attachment();    
    super.initialize(attachment);
  }  

  /**
   * Sets the Mime Type.
   * @param code Mime Type code
   * @return AttachmentBuilder
   */
  public AttachmentBuilder withContentType(String code) {
    attachment.setContentType(code);
    return this;
  }

  /**
   * Sets the Language of the Attachment.
   * @param language Language Value
   * @return AttachmentBuilder
   */
  public AttachmentBuilder withLanguage(String language) {
    attachment.setLanguage(language);
    return this;
  }

  /**
   * Sets the Attachment Data to the provided Byte Array.
   * @param data Byte Array
   * @return AttachmentBuilder
   */
  public AttachmentBuilder withData(byte[] data) {
    attachment.setData(data);
    return this;
  }

  /**
   * Sets the Url of the Attachment.
   * @param url Url
   * @return AttachmentBuilder
   */
  public AttachmentBuilder withUrl(String url) {
    attachment.setUrl(url);
    return this;
  }

  /**
   * Sets the Attachment File Size.
   * @param size Size
   * @return AttachmentBuilder
   */
  public AttachmentBuilder withSize(int size) {
    attachment.setSize(size);
    return this;
  }

  /**
   * Sets the Hash value to the provided byte array.
   * @param hash Byte Array
   * @return AttachmentBuilder
   */
  public AttachmentBuilder withHash(byte[] hash) {
    attachment.setHash(hash);
    return this;
  }

  /**
   * Sets the Attachment Title.
   * @param title Title
   * @return AttachmentBuilder
   */
  public AttachmentBuilder withTitle(String title) {
    attachment.setTitle(title);
    return this;
  }

  /**
   * Sets the Creation time to the provide Java Date value.
   * @param creation Java Date value.
   * @return AttachmentBuilder
   */
  public AttachmentBuilder withCreation(Date creation) {
    attachment.setCreation(creation);
    return this;
  }

  /**
   * Sets the Creation Time to the provided LocalDateTime value.
   * @param creation Local DateTime value for Creation.
   * @return AttachmentBuilder
   */
  public AttachmentBuilder withCreation(LocalDateTime creation) {
    Date value = new Date(creation.toEpochSecond(ZoneOffset.UTC));
    attachment.setCreation(value);
    return this;
  }

  /**
   * Returns the created Attachment.
   * @return Attachment
   */
  public Attachment build() {
    return this.attachment;
  }


  
}
