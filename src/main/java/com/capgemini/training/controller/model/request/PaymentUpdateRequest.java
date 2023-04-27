package com.capgemini.training.controller.model.request;

import com.capgemini.training.commons.model.PaymentType;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class PaymentUpdateRequest {

  @Setter
  @Schema(description = "Payment id", example = "1")
  private Long paymentId;

  @Schema(required = true, description = "Customer id", example = "1")
  private String customerId;

  @Schema(description = "Customer id", example = "1")
  private String beneficiaryId;

  @Schema(description = "Payment Type", example = "BIZUM")
  private PaymentType paymentType;

  @Schema(description = "Amount", example = "1.00")
  private BigDecimal amount;
}
