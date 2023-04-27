package com.capgemini.training.service;

import com.capgemini.training.exception.PaymentNotFoundException;
import com.capgemini.training.model.PaymentCreateRequest;
import com.capgemini.training.model.PaymentDetails;
import com.capgemini.training.model.PaymentResponse;
import com.capgemini.training.repository.PaymentRepository;
import com.capgemini.training.service.mapper.CustomMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdatePaymentService {
  private final PaymentRepository paymentRepository;
  private final CustomMapper mapper;

  public PaymentResponse updatePayment(PaymentCreateRequest paymentRequest) {

    // TODO comprobar que obtengo el pago de base de datos, sino doy error, una vez tengo el item de
    // base de datos, sustituyo los campos no null que me vengan en la request en el objeto que me
    // he traido de db y hago save del nuevo objeto
    PaymentDetails paymentDetails =
        paymentRepository
            .findById(paymentRequest.getPaymentId())
            .map(payment -> mapper.getPaymentMapper().toPaymentDetails(payment))
            .orElseThrow(() -> new PaymentNotFoundException("Payment does not exist in database"));

    //TODO cuando es nulo en request coges de paymentDetails
    return mapper
        .getPaymentMapper()
        .toPaymentResponse(
            paymentRepository.save(mapper.getPaymentMapper().toEntity(paymentDetails, paymentRequest)));
  }
}
