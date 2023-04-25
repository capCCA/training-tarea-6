package com.capgemini.training.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@Builder
@Entity
@Table(name = "beneficiary")
public class Beneficiary implements Serializable {
  private static final long serialVersionUID = 8251162554898160011L;

  public Beneficiary() {}

  @Id
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE
  )
  @Column(name = "beneficiary_id", nullable = false)
  private Long beneficiaryId;
  @Column(name = "creation_date", nullable = false)
  private LocalDate creation_date;

  @Column(name = "updated_date", nullable = false)
  private LocalDate updated_date;


}
