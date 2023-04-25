package com.capgemini.training.model;

import com.capgemini.training.model.Enum.DocumentType;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "customer")
public class Customer implements Serializable {

  private static final long serialVersionUID = -2250005744661923250L;

  public Customer() {

  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "customer_id", nullable = false)
  private String customerId;

//  @Enumerated(EnumType.STRING)
//  @Column(name = "document_type")
//  private DocumentType documentType;
  @Column(name = "document_number", nullable = false)
  private String documentNumber;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "surname", nullable = false)
  private String surname;

  @Column(name = "lastname")
  private String lastname;

  @Column(name = "country", nullable = false)
  private String country;

  @Column(name = "telephone")
  private Integer telephone;
  @Column(name = "creation_date", nullable = false)
  private LocalDate creationDate;
  @Column(name = "updated_date")
  private LocalDate updatedDate;
}
