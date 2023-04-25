package com.capgemini.training.model;

import com.capgemini.training.model.Enum.PaymentType;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@Builder
@Entity
@Table(name = "payment")
public class Payment implements Serializable {

  private static final long serialVersionUID = 7021289717246220248L;

  public Payment() {}

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_generator_sequence")
  @SequenceGenerator(
      name = "payment_generator_sequence",
      sequenceName = "payment_payment_id_seq",
      allocationSize = 1)
  @Column(name = "payment_id", nullable = false)
  private Long paymentId;

  @Column(name = "amount", nullable = false)
  private Double amount;

//  @Enumerated(EnumType.STRING)
//  @Column(name = "payment_type")
//  private PaymentType paymentType;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "beneficiary_id")
  private Beneficiary beneficiary;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "customer_id")
  private Customer customer;

  @Column(name = "creation_date", nullable = false)
  private LocalDate creation_date;

  @Column(name = "updated_date", nullable = false)
  private LocalDate updated_date;
}
