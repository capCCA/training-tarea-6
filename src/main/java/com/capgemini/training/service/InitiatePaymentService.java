package com.capgemini.training.service;

import com.capgemini.training.controller.model.request.PaymentCreateRequest;
import com.capgemini.training.controller.model.response.PaymentResponse;
import com.capgemini.training.exception.BeneficiaryNotFoundException;
import com.capgemini.training.exception.CustomerNotFoundException;
import com.capgemini.training.repository.BeneficiaryRepository;
import com.capgemini.training.repository.CustomerRepository;
import com.capgemini.training.repository.PaymentRepository;
import com.capgemini.training.repository.entity.PaymentEntity;
import com.capgemini.training.service.mapper.CustomMapper;
import com.capgemini.training.service.model.BeneficiaryDTO;
import com.capgemini.training.service.model.CustomerDTO;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InitiatePaymentService {

  private final CustomerRepository customerRepository;
  private final BeneficiaryRepository beneficiaryRepository;
  private final PaymentRepository paymentRepository;
  private final CustomMapper mapper;
  private final String ITEM_NOT_FOUND = "%s %s not found";

  @Transactional
  public PaymentResponse initiatePayment(PaymentCreateRequest paymentCreateRequest) {
    CustomerDTO customerDetails =
        customerRepository
            .findById(paymentCreateRequest.getCustomerId())
            .map(customer -> mapper.getCustomerMapper().toCustomerDto(customer))
            .orElseThrow(
                () ->
                    new CustomerNotFoundException(
                        String.format(
                            ITEM_NOT_FOUND, "Customer", paymentCreateRequest.getCustomerId())));

    BeneficiaryDTO beneficiaryDetails =
        beneficiaryRepository
            .findById(paymentCreateRequest.getBeneficiaryId())
            .map(beneficiary -> mapper.getBeneficiaryMapper().toBeneficiaryDto(beneficiary))
            .orElseThrow(
                () ->
                    new BeneficiaryNotFoundException(
                        String.format(
                            ITEM_NOT_FOUND,
                            "Beneficiary",
                            paymentCreateRequest.getBeneficiaryId())));

    PaymentEntity paymentEntity =
        mapper
            .getPaymentMapper()
            .toPaymentEntity(paymentCreateRequest, customerDetails, beneficiaryDetails);

    return mapper.getPaymentMapper().toPaymentResponse(paymentRepository.save(paymentEntity));
  }
}
