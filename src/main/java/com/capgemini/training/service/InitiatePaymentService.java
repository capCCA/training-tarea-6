package com.capgemini.training.service;

import com.capgemini.training.exception.BeneficiaryNotFoundException;
import com.capgemini.training.exception.CustomerNotFoundException;
import com.capgemini.training.model.BeneficiaryDetails;
import com.capgemini.training.model.CustomerDetails;
import com.capgemini.training.model.PaymentCreateRequest;
import com.capgemini.training.model.PaymentResponse;
import com.capgemini.training.repository.BeneficiaryRepository;
import com.capgemini.training.repository.CustomerRepository;
import com.capgemini.training.repository.PaymentRepository;
import com.capgemini.training.service.mapper.CustomMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InitiatePaymentService {

  private final CustomerRepository customerRepository;
  private final BeneficiaryRepository beneficiaryRepository;
  private final PaymentRepository paymentRepository;
  private final CustomMapper mapper;

  public PaymentResponse initiatePayment(PaymentCreateRequest paymentCreateRequest) {

    CustomerDetails customerDetails =
        customerRepository
            .findById(paymentCreateRequest.getCustomerId())
            .map(customer -> mapper.getCustomerMapper().toCustomerDetails(customer))
            .orElseThrow(() -> new CustomerNotFoundException("Customer not found"));
    BeneficiaryDetails beneficiaryDetails =
        beneficiaryRepository
            .findById(paymentCreateRequest.getBeneficiaryId())
            .map(beneficiary -> mapper.getBeneficiaryMapper().toBeneficiaryDetails(beneficiary))
            .orElseThrow(() -> new BeneficiaryNotFoundException("Beneficiary not found"));

    return mapper
        .getPaymentMapper()
        .toPaymentResponse(
            paymentRepository.save(
                mapper
                    .getPaymentMapper()
                    .toPaymentEntity(paymentCreateRequest, customerDetails, beneficiaryDetails)));
  }
}
