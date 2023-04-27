package com.capgemini.training.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
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
public class PaymentRequest {

  @NotBlank private Long paymentId;
  @NotBlank private String customerId;
  @NotBlank private String beneficiaryId;
  @NotBlank private String paymentType;
  @NotBlank private BigDecimal fromAmount;
  @NotBlank private BigDecimal toAmount;
  @NotBlank private LocalDate fromCreationDate;
  @NotBlank private LocalDate toCreationDate;
  @NotBlank private LocalDate fromUpdateDate;
  @NotBlank private LocalDate toUpdateDate;
}
