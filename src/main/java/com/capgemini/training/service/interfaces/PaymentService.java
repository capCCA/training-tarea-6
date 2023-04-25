package com.capgemini.training.service.interfaces;

import com.capgemini.training.model.dto.PaymentRequest;
import com.capgemini.training.model.Payment;
import java.util.List;

public interface PaymentService {

  List<Payment> findPaymentsByCustomerId(String customerId);

  Payment updatePayment(PaymentRequest paymentRequest);

  Payment createPayment(PaymentRequest paymentRequest);

}
