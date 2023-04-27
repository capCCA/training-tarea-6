package com.capgemini.training.controller;

import com.capgemini.training.controller.model.request.PaymentCreateRequest;
import com.capgemini.training.controller.model.response.PaymentResponse;
import com.capgemini.training.service.InitiatePaymentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/capgemini/training/payments")
@Tag(name = "Payments")
@RequiredArgsConstructor
@Validated
public class InitiatePaymentController {

  private final InitiatePaymentService initiatePaymentService;

  @PostMapping(value = "/initiate", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<PaymentResponse> initiatePayment(
      @RequestBody @Valid PaymentCreateRequest paymentCreateRequest) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(initiatePaymentService.initiatePayment(paymentCreateRequest));
  }
}
