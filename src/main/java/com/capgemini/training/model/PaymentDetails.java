package com.capgemini.training.model;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode()
@NoArgsConstructor
@ToString(callSuper = true)
public class PaymentDetails {

  private Long paymentId;
  private CustomerDetails customer;
  private BeneficiaryDetails beneficiary;
  private String paymentType;
  private BigDecimal amount;
  private ZonedDateTime creationDate;
  private ZonedDateTime updateDate;
}
