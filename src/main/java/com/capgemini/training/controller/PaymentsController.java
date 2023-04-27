package com.capgemini.training.controller;

import static org.springframework.util.CollectionUtils.isEmpty;

import com.capgemini.training.controller.model.request.PaymentRequest;
import com.capgemini.training.controller.model.response.PaymentResponse;
import com.capgemini.training.service.PaymentsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/capgemini/training/payments")
@Tag(name = "Payments")
@RequiredArgsConstructor
@Validated
public class PaymentsController {

  private final PaymentsService paymentsService;

  @GetMapping(
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<PaymentResponse>> getPayments(@RequestBody @Valid PaymentRequest paymentRequest) {
    List<PaymentResponse> response = paymentsService.getPayments(paymentRequest);
    return isEmpty(response) ? ResponseEntity.noContent().build() : ResponseEntity.ok(response);
  }
}
