package com.capgemini.training.model;

import java.math.BigDecimal;
import javax.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Builder
@EqualsAndHashCode()
@RequiredArgsConstructor
@ToString()
public class PaymentCreateRequest {

  @Setter private Long paymentId;
  @NotBlank private String customerId;
  @NotBlank private String beneficiaryId;
  @NotBlank private String paymentType;
  @NotBlank private BigDecimal amount;
}
