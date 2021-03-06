package com.lswebworld.datatypes;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import org.hl7.fhir.r4.model.Quantity;
import org.hl7.fhir.r4.model.Ratio;
import org.junit.jupiter.api.Test;

class RatioBuilderTest {

  @Test
  void testWithNumerator() {
    Quantity quantity = new Quantity();
    quantity.setCode("ml");
    quantity.setValue(25.4);

    Ratio ratio = new RatioBuilder()
        .withNumerator(quantity)
        .build();
    
    assertThat(ratio.getNumerator())
        .as("Numerator should not be null")
        .isNotNull();
    assertThat(ratio.getNumerator().isEmpty())
        .as("Numerator should not be empty")
        .isFalse();
    assertThat(ratio.getNumerator())
        .as("Numerator Value should be 25.4")
        .extracting(Quantity.class::cast)
        .extracting(Quantity::getValue)
        .extracting(BigDecimal.class::cast)
        .extracting(BigDecimal::doubleValue)
        .isEqualTo(25.4);
  }

  @Test
  void testWithDenominator() {
    Quantity quantity = new Quantity();
    quantity.setCode("ml");
    quantity.setValue(37.2);

    Ratio ratio = new RatioBuilder()
        .withDenominator(quantity)
        .build();
    
    assertThat(ratio.getDenominator())
        .as("Denominator should not be null")
        .isNotNull();
    assertThat(ratio.getDenominator().isEmpty())
        .as("Denominator should not be empty")
        .isFalse();
    assertThat(ratio.getDenominator())
        .as("Denominator Value should be 37.2")
        .extracting(Quantity.class::cast)
        .extracting(Quantity::getValue)
        .extracting(BigDecimal.class::cast)
        .extracting(BigDecimal::doubleValue)
        .isEqualTo(37.2);
  }
  
}
