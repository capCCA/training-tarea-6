package com.capgemini.training.service.mapper;

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
public class CustomMapper {
  private final BeneficiaryMapper beneficiaryMapper;
  private final CustomerMapper customerMapper;
  private final PaymentMapper paymentMapper;
}
