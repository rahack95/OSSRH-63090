package com.nepali.number.to.word.service;

import java.math.BigDecimal;

/**
 * Unit test cases for NepaliNumberService
 *
 * @author Rohan
 * @version 1.0.0
 * @since 29 Dec 2020
 */
public interface NepaliNumberService {

  public String convertNumberToNepaliWords(BigDecimal number);
}
