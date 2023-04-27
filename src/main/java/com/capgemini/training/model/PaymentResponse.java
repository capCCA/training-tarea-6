package com.capgemini.training.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@EqualsAndHashCode()
@RequiredArgsConstructor
@ToString()
public class PaymentResponse {

  private Long paymentId;
  private String customerId;
  private String beneficiaryId;
  private String paymentType;
  private BigDecimal amount;
  private LocalDate creationDate;
  private LocalDate updateDate;
}
