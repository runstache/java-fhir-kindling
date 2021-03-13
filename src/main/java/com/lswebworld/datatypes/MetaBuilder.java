package com.lswebworld.datatypes;

import com.lswebworld.base.AbstractElementBuilder;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Meta;

public class MetaBuilder extends AbstractElementBuilder<Meta, MetaBuilder> {

  private Meta meta;

  /**
   * Constructor.
   */
  public MetaBuilder() {
    super();
    meta = new Meta();
    super.initialize(meta);
  }

  /**
   * Sets the Version Id for the Meta Object.
   * @param versionId Version Id
   * @return MetaBuilder
   */
  public MetaBuilder withVersionId(String versionId) {
    meta.setVersionId(versionId);
    return this;
  }

  /**
   * Sets the Last Updated to a Java Util Date.
   * @param lastUpdated Java Util Date
   * @return MetaBuilder
   */
  public MetaBuilder withLastUpdated(Date lastUpdated) {
    meta.setLastUpdated(lastUpdated);
    return this;
  }

  /**
   * Sets the Last Updated to a Java Time Local Date Time.
   * @param lastUpdated Local Date Time
   * @param offset Zone Offset
   * @return MetaBuilder
   */
  public MetaBuilder withLastUpdated(LocalDateTime lastUpdated, ZoneOffset offset) {
    meta.setLastUpdated(new Date(lastUpdated.toEpochSecond(offset)));
    return this;
  }

  /**
   * Sets the Source Uri for the Meta Object.
   * @param source Source Uri
   * @return MetaBuilder
   */
  public MetaBuilder withSource(String source) {
    meta.setSource(source);
    return this;
  }

  /**
   * Adds a URI to a Structure Definition for the Meta Object.
   * @param profile Profile uri
   * @return MetaBuilder
   */
  public MetaBuilder addProfile(String profile) {
    meta.addProfile(profile);
    return this;
  }

  /**
   * Adds a Security Coding to the Meta Object.
   * @param security Coding
   * @return MetaBuilder
   */
  public MetaBuilder addSecurity(Coding security) {
    meta.addSecurity(security);
    return this;
  }

  /**
   * Adds a Tag Coding to the Meta Object.
   * @param tag Coding
   * @return MetaBuilder
   */
  public MetaBuilder addTag(Coding tag) {
    meta.addTag(tag);
    return this;
  }

  /**
   * Returns the Constructed Meta Object.
   * @return Meta
   */
  public Meta build() {
    return this.meta;
  }

}
