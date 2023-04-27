package com.capgemini.training.service;

import com.capgemini.training.controller.model.request.PaymentRequest;
import com.capgemini.training.controller.model.response.PaymentResponse;
import com.capgemini.training.exception.CustomerNotFoundException;
import com.capgemini.training.repository.CustomerRepository;
import com.capgemini.training.repository.PaymentRepository;
import com.capgemini.training.repository.entity.PaymentEntity;
import com.capgemini.training.service.mapper.PaymentMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentsService {

  private final PaymentRepository paymentRepository;

  private final CustomerRepository customerRepository;

  private final PaymentMapper mapper;

  private final String ITEM_NOT_FOUND = "%s %s not found";

  public List<PaymentResponse> getPayments(PaymentRequest request) {
    validatedCustomerId(request.getCustomerId());
    return getPaymentsEntity(request).stream().map(mapper::toPaymentResponse).toList();
  }

  private void validatedCustomerId(final String customerId) {
    customerRepository
        .findById(customerId)
        .orElseThrow(
            () ->
                new CustomerNotFoundException(
                    String.format(ITEM_NOT_FOUND, "Customer", customerId)));
  }

  public List<PaymentEntity> getPaymentsEntity(PaymentRequest request) {
    return paymentRepository.findPaymentsByCriteria(
        request.getPaymentId(),
        request.getCustomerId(),
        request.getBeneficiaryId(),
        request.getPaymentType(),
        request.getFromAmount(),
        request.getToAmount(),
        request.getFromCreationDate(),
        request.getToCreationDate(),
        request.getFromUpdateDate(),
        request.getToUpdateDate());
  }
}
