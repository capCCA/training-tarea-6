package com.capgemini.training.controller.model.request;

import com.capgemini.training.commons.model.PaymentType;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class PaymentRequest {

  private Long paymentId;
  @NotBlank private String customerId;
  private String beneficiaryId;
  private PaymentType paymentType;
  private BigDecimal fromAmount;
  private BigDecimal toAmount;
  private LocalDate fromCreationDate;
  private LocalDate toCreationDate;
  private LocalDate fromUpdateDate;
  private LocalDate toUpdateDate;
}
