package com.capgemini.training.service.mapper;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Getter
@Builder
@EqualsAndHashCode
@RequiredArgsConstructor
@Component
public class CustomMapper {

  private final BeneficiaryMapper beneficiaryMapper;
  private final CustomerMapper customerMapper;
  private final PaymentMapper paymentMapper;
}
