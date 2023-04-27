package com.capgemini.training.controller.model.request;

import com.capgemini.training.commons.model.PaymentType;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
public class PaymentCreateRequest {

  @Setter
  @Schema(description = "Payment id", example = "1")
  private Long paymentId;

  @NotEmpty
  @Schema(required = true, description = "Customer id", example = "1")
  private String customerId;

  @NotEmpty
  @Schema(required = true, description = "Customer id", example = "1")
  private String beneficiaryId;

  @NotNull
  @Schema(required = true, description = "Payment Type", example = "BIZUM")
  private PaymentType paymentType;

  @NotNull
  @Schema(required = true, description = "Amount", example = "1.00")
  private BigDecimal amount;
}
