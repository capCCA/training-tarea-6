package com.capgemini.training.service.model;

import com.capgemini.training.commons.model.DocumentType;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Schema(description = "CustomerDetails")
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode()
@NoArgsConstructor
@ToString(callSuper = true)
public class CustomerDTO {

  @Schema(title = "customerId", example = "1234567891", description = "Customer identifier.")
  @NotBlank
  private String customerId;

  @Schema(
      title = "documentType",
      example = "DNI",
      description = "Customer document type identifier.")
  @NotBlank
  private DocumentType documentType;

  @Schema(
      title = "documentNumber",
      example = "1234567891",
      description = "Customer document number.")
  @NotBlank
  private String documentNumber;

  @Schema(title = "name", example = "Jaimito", description = "Customer name.")
  @NotBlank
  private String name;

  @Schema(title = "surName", example = "Ronaldo", description = "Customer surName.")
  @NotBlank
  private String surName;

  @Schema(title = "lastName", example = "Eustaquio", description = "Customer lastName.")
  private String lastName;

  @Schema(title = "country", example = "Spain", description = "Customer country.")
  @NotBlank
  private String country;

  @Schema(title = "telephone", example = "678097823", description = "Customer telephone.")
  @NotBlank
  private String telephone;

  private LocalDate creationDate;
  private LocalDate updateDate;
}
