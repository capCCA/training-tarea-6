package com.capgemini.training.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Schema(description = "BeneficiaryDetails")
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode()
@NoArgsConstructor
@ToString(callSuper = true)
public class BeneficiaryDetails {

  private String beneficiaryId;
  private LocalDate creationDate;
  private LocalDate updateDate;
}
