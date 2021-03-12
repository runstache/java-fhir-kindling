package com.lswebworld.datatypes;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Dosage;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.Quantity;
import org.hl7.fhir.r4.model.Range;
import org.hl7.fhir.r4.model.Ratio;
import org.hl7.fhir.r4.model.SimpleQuantity;
import org.hl7.fhir.r4.model.StringType;
import org.junit.jupiter.api.Test;

class DoseAndRateBuilderTest {

  @Test
  void testWithId() {
    Dosage.DosageDoseAndRateComponent component = new DoseAndRateBuilder()
        .withId("MyId")
        .build();
    assertThat(component.getId())
        .as("Id should be MyId")
        .isEqualToIgnoringCase("MyId");
  }

  @Test
  void testAddExtension() {
    Extension extension = new Extension("http://www.myextension.com");
    extension.setValue(new StringType("MyValue"));

    Dosage.DosageDoseAndRateComponent component = new DoseAndRateBuilder()
        .addExtension(extension)
        .build();
    assertThat(component.getExtension())
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
    CodeableConcept concept = new CodeableConcept();
    concept.addCoding(new Coding("MY.CODE.OID", "CODE", "DISPLAY"));
    concept.setText("My Code Text");
    Dosage.DosageDoseAndRateComponent component = new DoseAndRateBuilder()
        .withType(concept)
        .build();

    assertThat(component.getType().isEmpty())
        .as("Type should not be empty")
        .isFalse();
    assertThat(component.getType())
        .as("Type Text should be My Code Text")
        .extracting("text")
        .isEqualTo("My Code Text");
    assertThat(component.getType().getCoding())
        .as("Coding should not be empty")
        .isNotEmpty()
        .allSatisfy(code -> assertThat(code)
            .extracting("system", "code", "display")
            .containsOnly("MY.CODE.OID", "CODE", "DISPLAY"));
  }

  @Test
  void testWithDoseRange() {
    Quantity quantity = new Quantity();
    quantity.setValue(25.5);
    Range range = new Range();
    range.setLow(quantity);
    range.setHigh(quantity);
    Dosage.DosageDoseAndRateComponent component = new DoseAndRateBuilder()
        .withDose(range)
        .build();
    assertThat(component.getDose())
        .as("Dose should be a Range")
        .isInstanceOf(Range.class);
    assertThat(component.getDose())
        .as("Range should have a Low value of 25.5")
        .extracting(Range.class::cast)
        .extracting(Range::getLow)
        .extracting(Quantity.class::cast)
        .extracting(Quantity::getValue)
        .extracting(BigDecimal::doubleValue)
        .isEqualTo(25.5);
    assertThat(component.getDose())
        .as("Range should have a High value of 25.5")
        .extracting(Range.class::cast)
        .extracting(Range::getHigh)
        .extracting(Quantity.class::cast)
        .extracting(Quantity::getValue)
        .extracting(BigDecimal::doubleValue)
        .isEqualTo(25.5);

  }

  @Test
  void testWithDoseQuantity() {
    SimpleQuantity quantity = new SimpleQuantity();
    quantity.setValue(25.5);
    Dosage.DosageDoseAndRateComponent component = new DoseAndRateBuilder()
        .withDose(quantity)
        .build();

    assertThat(component.getDose())
        .as("Dose should be a Simple Quantity")
        .isInstanceOf(SimpleQuantity.class);
    assertThat(component.getDose())
        .as("Dosage should be 25.5")
        .extracting(SimpleQuantity.class::cast)
        .extracting(SimpleQuantity::getValue)
        .extracting(BigDecimal::doubleValue)
        .isEqualTo(25.5);
  }

  @Test
  void testWithRateRatio() {
    Quantity quantity = new Quantity();
    quantity.setValue(25.5);
    Ratio ratio = new Ratio();
    ratio.setDenominator(quantity);
    ratio.setNumerator(quantity);

    Dosage.DosageDoseAndRateComponent component = new DoseAndRateBuilder()
        .withRate(ratio)
        .build();
    assertThat(component.getRate())
        .as("Rate should be a Ratio")
        .isInstanceOf(Ratio.class);
    assertThat(component.getRate())
        .as("Rate should have a Denominator of 25.5")
        .extracting(Ratio.class::cast)
        .extracting(Ratio::getDenominator)
        .extracting(Quantity::getValue)
        .extracting(BigDecimal::doubleValue)
        .isEqualTo(25.5);
    assertThat(component.getRate())
        .as("Rate should have a Numerator of 25.5")
        .extracting(Ratio.class::cast)
        .extracting(Ratio::getNumerator)
        .extracting(Quantity::getValue)
        .extracting(BigDecimal::doubleValue)
        .isEqualTo(25.5);
  }

  @Test
  void testWithRateRange() {
    Quantity quantity = new Quantity();
    quantity.setValue(25.5);
    Range range = new Range();
    range.setLow(quantity);
    range.setHigh(quantity);

    Dosage.DosageDoseAndRateComponent component = new DoseAndRateBuilder()
        .withRate(range)
        .build();
    assertThat(component.getRate())
        .as("Rate should be a Range")
        .isInstanceOf(Range.class);
    assertThat(component.getRate())
        .as("Range should have a Low value of 25.5")
        .extracting(Range.class::cast)
        .extracting(Range::getLow)
        .extracting(Quantity.class::cast)
        .extracting(Quantity::getValue)
        .extracting(BigDecimal::doubleValue)
        .isEqualTo(25.5);
    assertThat(component.getRate())
        .as("Range should have a High value of 25.5")
        .extracting(Range.class::cast)
        .extracting(Range::getHigh)
        .extracting(Quantity.class::cast)
        .extracting(Quantity::getValue)
        .extracting(BigDecimal::doubleValue)
        .isEqualTo(25.5);

  }

  @Test
  void testWithRateQuantity() {
    SimpleQuantity quantity = new SimpleQuantity();
    quantity.setValue(25.5);
    Dosage.DosageDoseAndRateComponent component = new DoseAndRateBuilder()
        .withRate(quantity)
        .build();

    assertThat(component.getRate())
        .as("Rate should be a Simple Quantity")
        .isInstanceOf(SimpleQuantity.class);
    assertThat(component.getRate())
        .as("Rate should be 25.5")
        .extracting(SimpleQuantity.class::cast)
        .extracting(SimpleQuantity::getValue)
        .extracting(BigDecimal::doubleValue)
        .isEqualTo(25.5);
  }
}