package com.nepali.number.to.word.constant;

import java.util.Arrays;
import java.util.List;

/**
 * Nepali number constant has all constants related to nepali numbers
 *
 * @author Rohan
 * @version 1.0.0
 * @since 29 Dec 2020
 */
public class NepaliNumberConstant {

  private NepaliNumberConstant() {
    throw new IllegalStateException("Utility/Constant class should not be instantiated.");
  }

  public static final String RUPEES = "रुपैया";
  public static final String PAISA = "पैसा";

  public static final String EMPTY_STRING = "";
  public static final String ONE_WHITESPACE_STRING = " ";

  public static final List<String> NEPALI_DIGITS = Arrays.asList("शुन्य", "एक", "दुई", "तीन", "चार", "पाँच", "छ", "सात", "आठ", "नौ", "दश", "एघार", "बाह्र", "तेह्र",
          "चौध", "पन्ध्र", "सोह्र", "सत्र", "अठार", "उन्नाइस", "विस", "एक्काइस", "बाइस", "तेईस", "चौविस", "पच्चिस", "छब्बिस", "सत्ताइस", "अठ्ठाईस", "उनन्तिस", "तिस", "एकत्तिस", "बत्तिस", "तेत्तिस", "चौँतिस", "पैँतिस",
          "छत्तिस", "सैँतीस", "अठतीस", "उनन्चालीस", "चालीस", "एकचालीस", "बयालीस", "त्रियालीस", "चवालीस", "पैँतालीस",
          "छयालीस",
          "सच्चालीस",
          "अठचालीस",
          "उनन्चास",
          "पचास",
          "एकाउन्न",
          "बाउन्न",
          "त्रिपन्न",
          "चउन्न",
          "पचपन्न",
          "छपन्न",
          "सन्ताउन्न",
          "अन्ठाउन्न",
          "उनन्साठी",
          "साठी",
          "एकसट्ठी",
          "बयसट्ठी",
          "त्रिसट्ठी",
          "चौंसट्ठी",
          "पैंसट्ठी",
          "छयसट्ठी",
          "सतसट्ठी",
          "अठसट्ठी",
          "उनन्सत्तरी",
          "सत्तरी",
          "एकहत्तर",
          "बहत्तर",
          "त्रिहत्तर",
          "चौहत्तर",
          "पचहत्तर",
          "छयहत्तर",
          "सतहत्तर",
          "अठहत्तर",
          "उनासी",
          "असी",
          "एकासी",
          "बयासी",
          "त्रियासी",
          "चौरासी",
          "पचासी",
          "छयासी",
          "सतासी",
          "अठासी",
          "उनान्नब्बे",
          "नब्बे",
          "एकान्नब्बे",
          "बयानब्बे",
          "त्रियान्नब्बे",
          "चौरान्नब्बे",
          "पन्चानब्बे",
          "छयान्नब्बे",
          "सन्तान्नब्बे",
          "अन्ठान्नब्बे",
          "उनान्सय",
          "सय");

  public static final List<String> NEPALI_DIGIT_PLACES = Arrays.asList("हजार", "लाख", "करोड", "अर्ब", "खर्ब");
}
