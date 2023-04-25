package com.capgemini.training.model.dto;

import lombok.Data;

@Data
public class PaymentRequest {

  private Long paymentId;
  private String paymentType;
  private Double amount;

  private String customerId;

  private String beneficiaryId;
}
