package com.capgemini.training.service;

import com.capgemini.training.controller.model.request.PaymentUpdateRequest;
import com.capgemini.training.controller.model.response.PaymentResponse;
import com.capgemini.training.exception.BeneficiaryNotFoundException;
import com.capgemini.training.exception.CustomerNotFoundException;
import com.capgemini.training.exception.PaymentNotFoundException;
import com.capgemini.training.repository.BeneficiaryRepository;
import com.capgemini.training.repository.CustomerRepository;
import com.capgemini.training.repository.PaymentRepository;
import com.capgemini.training.repository.entity.PaymentEntity;
import com.capgemini.training.service.mapper.CustomMapper;
import com.capgemini.training.service.model.BeneficiaryDTO;
import com.capgemini.training.service.model.CustomerDTO;
import com.capgemini.training.service.model.PaymentDTO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdatePaymentService {
  private final PaymentRepository paymentRepository;

  private final CustomerRepository customerRepository;

  private final BeneficiaryRepository beneficiaryRepository;

  private final CustomMapper mapper;

  private final String ITEM_NOT_FOUND = "%s %s not found";

  public PaymentResponse updatePayment(PaymentUpdateRequest request) {
    PaymentDTO paymentDTO = getPaymentById(request);
    PaymentEntity paymentEntity = mapper.getPaymentMapper().toPaymentEntity(paymentDTO, request);
    return mapper.getPaymentMapper().toPaymentResponse(paymentRepository.save(paymentEntity));
  }

  private PaymentDTO getPaymentById(final PaymentUpdateRequest paymentRequest) {
    PaymentDTO response =
        paymentRepository
            .findById(paymentRequest.getPaymentId())
            .map(paymentEntity -> mapper.getPaymentMapper().toPaymentDto(paymentEntity))
            .orElseThrow(
                () ->
                    new PaymentNotFoundException(
                        String.format(ITEM_NOT_FOUND, "Payment", paymentRequest.getPaymentId())));
    if (StringUtils.isNotEmpty(paymentRequest.getCustomerId())) {
      CustomerDTO customerDTO =
          customerRepository
              .findById(paymentRequest.getCustomerId())
              .map(customerEntity -> mapper.getCustomerMapper().toCustomerDto(customerEntity))
              .orElseThrow(
                  () ->
                      new CustomerNotFoundException(
                          String.format(
                              ITEM_NOT_FOUND, "Customer", paymentRequest.getCustomerId())));
      response.setCustomer(customerDTO);
    }
    if (StringUtils.isNotEmpty(paymentRequest.getBeneficiaryId())) {
      BeneficiaryDTO beneficiaryDTO =
          beneficiaryRepository
              .findById(paymentRequest.getBeneficiaryId())
              .map(
                  beneficiaryEntity ->
                      mapper.getBeneficiaryMapper().toBeneficiaryDto(beneficiaryEntity))
              .orElseThrow(
                  () ->
                      new BeneficiaryNotFoundException(
                          String.format(
                              ITEM_NOT_FOUND, "Beneficiary", paymentRequest.getCustomerId())));
      response.setBeneficiary(beneficiaryDTO);
    }
    return response;
  }
}
