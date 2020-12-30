package service.impl;

import constant.NepaliNumberConstant;
import model.NepaliNumberToWord;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 * NepaliNumberServiceImpl contains methods related to nepali numbers
 *
 * @author Rohan
 * @version 1.0.0
 * @since 29 Dec 2020
 */
public class NepaliNumberServiceImpl {

  /**
   * Method to convert big decimal to nepali words
   *
   * @param number BigDecimal
   * @return numberInNepaliWords String
   * @author Rohan
   * @since 29 Dec 2020
   */
  public String convertNumberToNepaliWords(BigDecimal number) {
    BigInteger bigInteger = number.toBigInteger();
    Integer length = String.valueOf(bigInteger).length();
    BigDecimal nonFractionalPart = new BigDecimal(bigInteger);
    if (length == 0) {
      return NepaliNumberConstant.NEPALI_DIGITS.get(0);
    }
    BigDecimal fractionalPart = number.remainder(BigDecimal.ONE).setScale(2, RoundingMode.DOWN);
    boolean isFractionPresent = fractionalPart.compareTo(BigDecimal.ZERO) != 0;
    String fractionPartString = populateFractionPartString(fractionalPart, isFractionPresent);
    if (length <= 3) {
      return computeNepaliWordForLessThanThousand(length, nonFractionalPart, fractionPartString, isFractionPresent);
    } else {
      return getNepaliWordIfGreaterThanHundred(length, nonFractionalPart, fractionPartString, isFractionPresent);
    }
  }

  /**
   * Method to populate fraction part of the string
   *
   * @param fractionalPart    BigDecimal
   * @param isFractionPresent boolean
   * @return fractionPartString String
   * @author Rohan
   * @since 30 Dec 2020
   */
  private String populateFractionPartString(BigDecimal fractionalPart, boolean isFractionPresent) {
    String fractionPartString = NepaliNumberConstant.EMPTY_STRING;
    if (isFractionPresent) {
      fractionPartString = fractionPartString.concat(NepaliNumberConstant.NEPALI_DIGITS.get(Integer.parseInt(fractionalPart.toString().replaceAll("0.", NepaliNumberConstant.EMPTY_STRING))));
    }
    return fractionPartString;
  }

  /**
   * Method to compute nepali word for number less than one thousand
   *
   * @param length             Integer
   * @param nonFractionalPart  BigDecimal
   * @param fractionPartString String
   * @param isFractionPresent  boolean
   * @return numberInNepaliWords String
   * @author Rohan
   * @since 30 Dec 2020
   */
  private String computeNepaliWordForLessThanThousand(Integer length, BigDecimal nonFractionalPart, String fractionPartString, boolean isFractionPresent) {
    Integer numberIntValue = nonFractionalPart.intValue();
    String nepaliNumberToWords = computeHundredsPlaceWord(length, numberIntValue);
    if (isFractionPresent)
      nepaliNumberToWords = nepaliNumberToWords.concat(NepaliNumberConstant.ONE_WHITESPACE_STRING).concat(NepaliNumberConstant.RUPEES).concat(NepaliNumberConstant.ONE_WHITESPACE_STRING).concat(fractionPartString).concat(NepaliNumberConstant.ONE_WHITESPACE_STRING).concat(NepaliNumberConstant.PAISA);
    return nepaliNumberToWords;
  }

  /**
   * Method to get nepali word if greater than hundred
   *
   * @param length             Integer
   * @param nonFractionalPart  BigDecimal
   * @param fractionPartString String
   * @param isFractionPresent  boolean
   * @return numberInNepaliWords String
   * @author Rohan
   * @since 29 Dec 2020
   */
  private String getNepaliWordIfGreaterThanHundred(Integer length, BigDecimal nonFractionalPart, String fractionPartString, boolean isFractionPresent) {
    NepaliNumberToWord nepaliNumberToWord = new NepaliNumberToWord();
    nepaliNumberToWord.setNumberInNepaliWords(NepaliNumberConstant.EMPTY_STRING);
    nepaliNumberToWord.setNumber(nonFractionalPart);
    nepaliNumberToWord.setNumberLength(length);
    computeGreaterThanHundredsPlaceWord(nepaliNumberToWord);
    if (nepaliNumberToWord.getNumber().compareTo(BigDecimal.ZERO) != 0) {
      nepaliNumberToWord.setNumberInNepaliWords(nepaliNumberToWord.getNumberInNepaliWords().concat(computeHundredsPlaceWord(nepaliNumberToWord.getNumberLength(),
              nepaliNumberToWord.getNumber().intValue())));
    }
    if (isFractionPresent)
      return nepaliNumberToWord.getNumberInNepaliWords().concat(NepaliNumberConstant.ONE_WHITESPACE_STRING).concat(NepaliNumberConstant.RUPEES).concat(NepaliNumberConstant.ONE_WHITESPACE_STRING).concat(fractionPartString).concat(NepaliNumberConstant.ONE_WHITESPACE_STRING).concat(NepaliNumberConstant.PAISA);
    else
      return nepaliNumberToWord.getNumberInNepaliWords().concat(NepaliNumberConstant.RUPEES);
  }

  /**
   * Method to compute hundreds place word
   *
   * @param length         Integer
   * @param numberIntValue Integer
   * @return numberInNepaliWords String
   * @author Rohan
   * @since 29 Dec 2020
   */
  private String computeHundredsPlaceWord(Integer length, Integer numberIntValue) {
    if (length <= 2) {
      return NepaliNumberConstant.NEPALI_DIGITS.get(numberIntValue);
    } else if (length == 3) {
      if (numberIntValue.equals(100)) {
        return NepaliNumberConstant.NEPALI_DIGITS.get(1).concat(NepaliNumberConstant.ONE_WHITESPACE_STRING).concat(NepaliNumberConstant.NEPALI_DIGITS.get(100));
      }
      Integer remainder = numberIntValue % 100;
      if (remainder == 0) {
        return NepaliNumberConstant.NEPALI_DIGITS.get(numberIntValue / 100).concat(NepaliNumberConstant.ONE_WHITESPACE_STRING).concat(NepaliNumberConstant.NEPALI_DIGITS.get(100));
      } else {
        return NepaliNumberConstant.NEPALI_DIGITS.get(numberIntValue / 100).concat(NepaliNumberConstant.ONE_WHITESPACE_STRING).concat(NepaliNumberConstant.NEPALI_DIGITS.get(100)).concat(NepaliNumberConstant.ONE_WHITESPACE_STRING).concat(NepaliNumberConstant.NEPALI_DIGITS.get(remainder));
      }
    }
    return NepaliNumberConstant.EMPTY_STRING;
  }

  /**
   * Method to compute numberInNepaliWords if greater than hundred place
   *
   * @param nepaliNumberToWord NepaliNumberToWord
   * @return numberInNepaliWords String
   * @author Rohan
   * @since 29 Dec 2020
   */
  private String computeGreaterThanHundredsPlaceWord(NepaliNumberToWord nepaliNumberToWord) {
    while (nepaliNumberToWord.getNumberLength() > 3) {
      computeDigitPlace(nepaliNumberToWord);
      nepaliNumberToWord.setNumberLength(String.valueOf(nepaliNumberToWord.getNumber()).length());
    }
    return nepaliNumberToWord.getNumberInNepaliWords();
  }

  /**
   * Method to compute digit place
   *
   * @param nepaliNumberToWord NepaliNumberToWord
   * @author Rohan
   * @since 29 Dec 2020
   */
  private void computeDigitPlace(NepaliNumberToWord nepaliNumberToWord) {
    Integer length = nepaliNumberToWord.getNumberLength();
    if (length == 4 || length == 5) {
      nepaliNumberToWord.setDivisor(new BigDecimal("1000"));
      updateNumberAndSpecifiedDigitPlace(0, nepaliNumberToWord);
    } else if (length == 6 || length == 7) {
      nepaliNumberToWord.setDivisor(new BigDecimal("100000"));
      updateNumberAndSpecifiedDigitPlace(1, nepaliNumberToWord);
    } else if (length == 8 || length == 9) {
      nepaliNumberToWord.setDivisor(new BigDecimal("10000000"));
      updateNumberAndSpecifiedDigitPlace(2, nepaliNumberToWord);
    } else if (length == 10 || length == 11) {
      nepaliNumberToWord.setDivisor(new BigDecimal("1000000000"));
      updateNumberAndSpecifiedDigitPlace(3, nepaliNumberToWord);
    } else if (length == 12 || length == 13) {
      nepaliNumberToWord.setDivisor(new BigDecimal("100000000000"));
      updateNumberAndSpecifiedDigitPlace(4, nepaliNumberToWord);
    }
  }

  /**
   * Method to update number and specified digit place
   *
   * @param digitPlace         Integer
   * @param nepaliNumberToWord NepaliNumberToWord
   * @author Rohan
   * @since 29 Dec 2020
   */
  private void updateNumberAndSpecifiedDigitPlace(Integer digitPlace, NepaliNumberToWord nepaliNumberToWord) {
    nepaliNumberToWord.setQuotient(nepaliNumberToWord.getNumber().divide(nepaliNumberToWord.getDivisor(), 0, RoundingMode.HALF_EVEN));
    nepaliNumberToWord.setNumberInNepaliWords(nepaliNumberToWord.getNumberInNepaliWords()
            .concat(NepaliNumberConstant.NEPALI_DIGITS.get(nepaliNumberToWord.getQuotient().intValue())
                    .concat(NepaliNumberConstant.ONE_WHITESPACE_STRING.concat(NepaliNumberConstant.NEPALI_DIGIT_PLACES.get(digitPlace))))
            .concat(NepaliNumberConstant.ONE_WHITESPACE_STRING));
    nepaliNumberToWord.setNumber(nepaliNumberToWord.getNumber().subtract(nepaliNumberToWord.getQuotient().multiply(nepaliNumberToWord.getDivisor())));
  }
}
