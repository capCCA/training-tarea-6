package com.capgemini.training.controller;

import com.capgemini.training.model.PaymentCreateRequest;
import com.capgemini.training.model.PaymentResponse;
import com.capgemini.training.service.InitiatePaymentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/capgemini/training/payments"})
@Tag(name = "Payments")
@RequiredArgsConstructor
public class InitiatePaymentController {

  private final InitiatePaymentService initiatePaymentService;

  @PostMapping("/initiate")
  public ResponseEntity<PaymentResponse> initiatePayment(
      @RequestBody PaymentCreateRequest paymentCreateRequest) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(initiatePaymentService.initiatePayment(paymentCreateRequest));
  }
}
