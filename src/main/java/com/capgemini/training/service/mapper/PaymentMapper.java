package com.capgemini.training.service.mapper;

import com.capgemini.training.model.BeneficiaryDetails;
import com.capgemini.training.model.CustomerDetails;
import com.capgemini.training.model.PaymentCreateRequest;
import com.capgemini.training.model.PaymentDetails;
import com.capgemini.training.model.PaymentResponse;
import com.capgemini.training.repository.entity.PaymentEntity;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Getter
@Builder
@EqualsAndHashCode()
@RequiredArgsConstructor
@ToString()
@Component
public class PaymentMapper {

  private final CustomerMapper customerMapper;
  private final BeneficiaryMapper beneficiaryMapper;

  public PaymentDetails toPaymentDetails(PaymentEntity paymentEntity) {
    return PaymentDetails.builder()
        .paymentId(paymentEntity.getPaymentId())
        .customer(customerMapper.toCustomerDetails(paymentEntity.getCustomer()))
        .amount(paymentEntity.getAmount())
        .paymentType(paymentEntity.getPaymentType())
        .beneficiary(beneficiaryMapper.toBeneficiaryDetails(paymentEntity.getBeneficiary()))
        .creationDate(paymentEntity.getCreationDate())
        .updateDate(paymentEntity.getUpdatedDate())
        .build();
  }

  public PaymentEntity toPaymentEntity(
      PaymentCreateRequest paymentCreateRequest,
      CustomerDetails customerDetails,
      BeneficiaryDetails beneficiaryDetails) {

    return PaymentEntity.builder()
        .customer(customerMapper.toCustomerEntity(customerDetails))
        .beneficiary(beneficiaryMapper.toBeneficiaryEntity(beneficiaryDetails))
        .paymentType(paymentCreateRequest.getPaymentType())
        .amount(paymentCreateRequest.getAmount())
        .build();
  }

  public PaymentEntity toEntity(PaymentDetails paymentDetails) {

    return PaymentEntity.builder()
        .customer(customerMapper.toCustomerEntity(paymentDetails.getCustomer()))
        .beneficiary(beneficiaryMapper.toBeneficiaryEntity(paymentDetails.getBeneficiary()))
        .paymentType(paymentDetails.getPaymentType())
        .amount(paymentDetails.getAmount())
        .creationDate(paymentDetails.getCreationDate())
        .build();
  }

  public PaymentResponse toPaymentResponse(PaymentEntity paymentEntity) {
    return PaymentResponse.builder()
        .paymentId(paymentEntity.getPaymentId())
        .customerId(paymentEntity.getCustomer().getCustomerId())
        .amount(paymentEntity.getAmount())
        .paymentType(paymentEntity.getPaymentType())
        .beneficiaryId(paymentEntity.getBeneficiary().getBeneficiaryId())
        .creationDate(paymentEntity.getCreationDate().toLocalDate())
        .updateDate(paymentEntity.getUpdatedDate().toLocalDate())
        .build();
  }
}
