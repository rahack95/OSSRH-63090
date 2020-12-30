package service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * Unit test cases for NepaliNumberServiceImpl
 *
 * @author Rohan
 * @version 1.0.0
 * @since 29 Dec 2020
 */
public class NepaliNumberServiceImplTest {

  private static NepaliNumberServiceImpl nepaliNumberService;

  @BeforeAll
  public static void setup() {
    nepaliNumberService = new NepaliNumberServiceImpl();
  }

  /**
   * Unit test case when new three digit number is given to convert to Nepali words
   *
   * @author Rohan
   * @version 1.0.3
   * @since 29 Dec 2020
   */
  @Test
  public void convertNumberToNepaliWordsTest() {
    Assertions.assertEquals("एक सय", nepaliNumberService.convertNumberToNepaliWords(new BigDecimal(100)));
    Assertions.assertEquals("तीन सय", nepaliNumberService.convertNumberToNepaliWords(new BigDecimal(300)));
    Assertions.assertEquals("तीन सय चार", nepaliNumberService.convertNumberToNepaliWords(new BigDecimal(304)));
    Assertions.assertEquals("नौ सय पन्ध्र रुपैया अठसट्ठी पैसा", nepaliNumberService.convertNumberToNepaliWords(new BigDecimal(915.687)));
    Assertions.assertEquals("बत्तिस लाख एक हजार रुपैया", nepaliNumberService.convertNumberToNepaliWords(new BigDecimal(3201000)));
    Assertions.assertEquals("एघार खर्ब बाइस अर्ब सत्र करोड बाइस लाख दश हजार तीन सय एक्काइस रुपैया बाह्र पैसा", nepaliNumberService.convertNumberToNepaliWords(new BigDecimal("1122172210321.12981")));
  }
}
