package com.lswebworld.builders.datatypes;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.Money;
import org.hl7.fhir.r4.model.StringType;
import org.junit.jupiter.api.Test;

class MoneyBuilderTest {

  @Test
  void testWithId() {
    Money money = new MoneyBuilder()
        .withId("MyId")
        .build();
    assertThat(money.getId())
        .as("Id should be MyId")
        .isEqualToIgnoringCase("MyId");
  }

  @Test
  void testAddExtension() {
    Extension extension = new Extension("http://myextension.org");
    extension.setValue(new StringType("MyExtensionValue"));

    Money money = new MoneyBuilder()
        .addExtension(extension)
        .build();
    assertThat(money.getExtension())
        .as("Extension should be populated")
        .isNotEmpty()
        .allSatisfy(ext -> {
          assertThat(ext.getUrl()).isEqualToIgnoringCase("http://myextension.org");
          assertThat(ext.getValue())
              .extracting(StringType.class::cast)
              .extracting(StringType::getValueAsString)
              .isEqualTo("MyExtensionValue");          
        });
  }

  @Test
  void testWithValue() {
    Money money = new MoneyBuilder()
        .withValue(25.6)
        .build();
    assertThat(money.getValue())
        .as("Value should be 25.6")
        .extracting(BigDecimal.class::cast)
        .extracting(BigDecimal::doubleValue)
        .isEqualTo(25.6);
  }

  @Test
  void testWithCurrency() {
    Money money = new MoneyBuilder()
        .withCurrency("USD")
        .build();
    assertThat(money.getCurrency())
        .as("Currency should be USD")
        .isEqualToIgnoringCase("USD");
  }
  
}
