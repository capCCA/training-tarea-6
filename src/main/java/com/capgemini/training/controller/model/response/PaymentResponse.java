package com.capgemini.training.controller.model.response;

import com.capgemini.training.commons.model.PaymentType;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@ToString
public class PaymentResponse {

  @EqualsAndHashCode.Include
  @Schema(example = "1", description = "Payment identifier.")
  private Long paymentId;

  @Schema(example = "1", description = "Customer identifier.")
  private String customerId;

  @Schema(example = "1", description = "Beneficiary identifier.")
  private String beneficiaryId;

  @Schema(example = "BIZUM", description = "Payment type.")
  private PaymentType paymentType;

  @Schema(example = "10.00", description = "Amount")
  private BigDecimal amount;

  private LocalDate creationDate;
  private LocalDate updateDate;
}
