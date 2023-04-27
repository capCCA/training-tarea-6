package com.capgemini.training.controller;

import com.capgemini.training.model.PaymentCreateRequest;
import com.capgemini.training.model.PaymentResponse;
import com.capgemini.training.service.UpdatePaymentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/capgemini/training/payments"})
@Tag(name = "Payments")
@RequiredArgsConstructor
public class UpdatePaymentController {

  private final UpdatePaymentService updatePaymentService;

  @PutMapping("/{paymentId}")
  public ResponseEntity<PaymentResponse> updatePayment(
      @PathVariable @NotEmpty Long paymentId,
      @RequestBody @Valid PaymentCreateRequest paymentRequest) {
    paymentRequest.setPaymentId(paymentId);
    return ResponseEntity.ok(updatePaymentService.updatePayment(paymentRequest));
  }
}
