package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Model class has fields related to nepali number to word
 *
 * @author Rohan
 * @version 1.0.0
 * @since 29 Dec 2020
 */
@Getter
@Setter
@NoArgsConstructor
public class NepaliNumberToWord {
  private BigDecimal number;
  private String numberInNepaliWords;
  private BigDecimal divisor;
  private BigDecimal quotient;
  private Integer numberLength;
}
