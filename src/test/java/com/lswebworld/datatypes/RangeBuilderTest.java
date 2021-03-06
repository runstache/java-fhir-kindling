package com.lswebworld.datatypes;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.Range;
import org.hl7.fhir.r4.model.SimpleQuantity;
import org.hl7.fhir.r4.model.StringType;
import org.junit.jupiter.api.Test;

class RangeBuilderTest {

  @Test
  void testWithLow() {
    SimpleQuantity low = new SimpleQuantity();
    low.setCode("ml");
    low.setSystem("http://unitsofmeasure.org");
    low.setValue(25.0);

    Range range = new RangeBuilder()
        .withLow(low)
        .build();
    
    assertThat(range.getLow())
        .as("Low value should not be null")
        .isNotNull();
    assertThat(range.getLow().isEmpty())
        .as("Low value should not be empty")
        .isFalse();

    assertThat(range.getLow())
        .as("Quantity value should be 100")
        .extracting(SimpleQuantity.class::cast)
        .extracting(SimpleQuantity::getValue)
        .extracting(BigDecimal.class::cast)
        .extracting(BigDecimal::doubleValue)
        .isEqualTo(25.0);

  }

  @Test
  void testWithHigh() {
    SimpleQuantity high = new SimpleQuantity();
    high.setCode("ml");
    high.setSystem("http://unitsofmeasure.org");
    high.setValue(100.0);

    Range range = new RangeBuilder()
        .withHigh(high)
        .build();
    
    assertThat(range.getHigh())
        .as("High value should not be null")
        .isNotNull();
    assertThat(range.getHigh().isEmpty())
        .as("High value should not be empty")
        .isFalse();

    assertThat(range.getHigh())
        .as("Quantity value should be 100")
        .extracting(SimpleQuantity.class::cast)
        .extracting(SimpleQuantity::getValue)
        .extracting(BigDecimal.class::cast)
        .extracting(BigDecimal::doubleValue)
        .isEqualTo(100.0);        
  }

  @Test
  void testWithId() {
    Range range = new RangeBuilder()
        .withId("MyID")
        .build();
  
    assertThat(range.getId())
        .as("Id should be MyID")
        .isEqualToIgnoringCase("MyID");
        
  }

  @Test
  void testAddExtension() {
    Extension extension = new Extension("http://www.myextension.com");
    extension.setValue(new StringType("MyValue"));

    Range range = new RangeBuilder()
        .addExtension(extension)
        .build();
    assertThat(range.getExtension())
        .as("Extension should be set with correct values")
        .isNotEmpty()
        .allSatisfy(ext -> {
          assertThat(ext.getUrl()).isEqualToIgnoringCase("http://www.myextension.com");
          StringType value = (StringType) ext.getValue();          
          assertThat(value.getValueAsString()).isEqualToIgnoringCase("MyValue");
        });

  }
  
}
