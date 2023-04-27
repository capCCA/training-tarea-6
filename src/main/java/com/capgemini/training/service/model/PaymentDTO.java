package com.capgemini.training.service.model;

import com.capgemini.training.commons.model.PaymentType;
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
public class PaymentDTO {

  private Long paymentId;
  private CustomerDTO customer;
  private BeneficiaryDTO beneficiary;
  private PaymentType paymentType;
  private BigDecimal amount;
  private ZonedDateTime creationDate;
  private ZonedDateTime updateDate;
}
