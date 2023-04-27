package com.capgemini.training.controller;

import com.capgemini.training.model.PaymentRequest;
import com.capgemini.training.model.PaymentResponse;
import com.capgemini.training.service.PaymentsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/capgemini/training/payments"})
@Tag(name = "Payments")
@RequiredArgsConstructor
public class PaymentsController {

  private final PaymentsService paymentsService;

  @GetMapping()
  public ResponseEntity<List<PaymentResponse>> getPayments(PaymentRequest paymentRequest) {
    return ResponseEntity.ok(paymentsService.getPayments(paymentRequest));
  }
}
