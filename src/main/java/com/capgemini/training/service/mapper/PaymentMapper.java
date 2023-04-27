package com.capgemini.training.service.mapper;

import com.capgemini.training.controller.model.request.PaymentCreateRequest;
import com.capgemini.training.controller.model.request.PaymentUpdateRequest;
import com.capgemini.training.controller.model.response.PaymentResponse;
import com.capgemini.training.repository.entity.PaymentEntity;
import com.capgemini.training.service.model.BeneficiaryDTO;
import com.capgemini.training.service.model.CustomerDTO;
import com.capgemini.training.service.model.PaymentDTO;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Component;

@Getter
@Builder
@EqualsAndHashCode
@RequiredArgsConstructor
@ToString
@Component
public class PaymentMapper {

  private final CustomerMapper customerMapper;
  private final BeneficiaryMapper beneficiaryMapper;

  public PaymentDTO toPaymentDto(PaymentEntity paymentEntity) {
    return PaymentDTO.builder()
        .paymentId(paymentEntity.getPaymentId())
        .customer(customerMapper.toCustomerDto(paymentEntity.getCustomer()))
        .amount(paymentEntity.getAmount())
        .paymentType(paymentEntity.getPaymentType())
        .beneficiary(beneficiaryMapper.toBeneficiaryDto(paymentEntity.getBeneficiary()))
        .creationDate(paymentEntity.getCreationDate())
        .updateDate(paymentEntity.getUpdatedDate())
        .build();
  }

  public PaymentEntity toPaymentEntity(
      PaymentCreateRequest paymentCreateRequest,
      CustomerDTO customerDto,
      BeneficiaryDTO beneficiaryDto) {

    return PaymentEntity.builder()
        .customer(customerMapper.toCustomerEntity(customerDto))
        .beneficiary(beneficiaryMapper.toBeneficiaryEntity(beneficiaryDto))
        .paymentType(paymentCreateRequest.getPaymentType())
        .amount(paymentCreateRequest.getAmount())
        .build();
  }

  public PaymentEntity toPaymentEntity(PaymentDTO paymentDto, PaymentUpdateRequest paymentRequest) {

    return PaymentEntity.builder()
        .paymentId(paymentRequest.getPaymentId())
        .customer(customerMapper.toCustomerEntity(paymentDto.getCustomer()))
        .beneficiary(beneficiaryMapper.toBeneficiaryEntity(paymentDto.getBeneficiary()))
        .paymentType(
            ObjectUtils.defaultIfNull(paymentRequest.getPaymentType(), paymentDto.getPaymentType()))
        .amount(ObjectUtils.defaultIfNull(paymentRequest.getAmount(), paymentDto.getAmount()))
        .creationDate(paymentDto.getCreationDate())
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
