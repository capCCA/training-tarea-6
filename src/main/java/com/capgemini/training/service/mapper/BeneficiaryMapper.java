package com.capgemini.training.service.mapper;

import com.capgemini.training.model.BeneficiaryDetails;
import com.capgemini.training.repository.entity.BeneficiaryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BeneficiaryMapper {

  public BeneficiaryDetails toBeneficiaryDetails(BeneficiaryEntity beneficiaryEntity) {
    return BeneficiaryDetails.builder()
        .beneficiaryId(beneficiaryEntity.getBeneficiaryId())
        .creationDate(beneficiaryEntity.getCreationDate().toLocalDate())
        .updateDate(beneficiaryEntity.getUpdatedDate().toLocalDate())
        .build();
  }

  public BeneficiaryEntity toBeneficiaryEntity(BeneficiaryDetails beneficiaryDetails) {

    return BeneficiaryEntity.builder().beneficiaryId(beneficiaryDetails.getBeneficiaryId()).build();
  }
}
