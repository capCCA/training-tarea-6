package com.capgemini.training.service.mapper;

import com.capgemini.training.repository.entity.BeneficiaryEntity;
import com.capgemini.training.service.model.BeneficiaryDTO;
import java.time.ZoneId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BeneficiaryMapper {

  public BeneficiaryDTO toBeneficiaryDto(BeneficiaryEntity beneficiaryEntity) {
    return BeneficiaryDTO.builder()
        .beneficiaryId(beneficiaryEntity.getBeneficiaryId())
        .creationDate(beneficiaryEntity.getCreationDate().toLocalDate())
        .updateDate(beneficiaryEntity.getUpdatedDate().toLocalDate())
        .build();
  }

  public BeneficiaryEntity toBeneficiaryEntity(BeneficiaryDTO beneficiaryDto) {
    return BeneficiaryEntity.builder()
        .beneficiaryId(beneficiaryDto.getBeneficiaryId())
        .creationDate(beneficiaryDto.getCreationDate().atStartOfDay(ZoneId.systemDefault()))
        .updatedDate(beneficiaryDto.getUpdateDate().atStartOfDay(ZoneId.systemDefault()))
        .build();
  }
}
