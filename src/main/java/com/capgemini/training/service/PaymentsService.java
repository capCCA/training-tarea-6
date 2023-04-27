package com.capgemini.training.service;

import com.capgemini.training.model.PaymentRequest;
import com.capgemini.training.model.PaymentResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentsService {

  public List<PaymentResponse> getPayments(PaymentRequest paymentRequest) {
    return null;
  }
}
