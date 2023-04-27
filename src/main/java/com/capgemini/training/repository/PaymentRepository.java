package com.capgemini.training.repository;

import com.capgemini.training.commons.model.PaymentType;
import com.capgemini.training.repository.entity.PaymentEntity;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {
  @Query(
      """
          SELECT p FROM PaymentEntity p WHERE (:paymentId IS NULL OR p.paymentId = :paymentId) 
          AND p.customer.customerId = :customerId 
          AND (:beneficiaryId IS NULL OR p.beneficiary.beneficiaryId = :beneficiaryId) 
          AND (:paymentType IS NULL OR p.paymentType = :paymentType) 
          AND (:fromAmount IS NULL OR p.amount >= :fromAmount) 
          AND (:toAmount IS NULL OR p.amount <= :toAmount) 
          AND (:fromCreationDate IS NULL OR p.creationDate >= :fromCreationDate) 
          AND (:toCreationDate IS NULL OR p.creationDate <= :toCreationDate) 
          AND (:fromUpdateDate IS NULL OR p.updatedDate >= :fromUpdateDate) 
          AND (:toUpdateDate IS NULL OR p.updatedDate <= :toUpdateDate)""")
  List<PaymentEntity> findPaymentsByCriteria(
      Long paymentId,
      String customerId,
      String beneficiaryId,
      PaymentType paymentType,
      BigDecimal fromAmount,
      BigDecimal toAmount,
      LocalDate fromCreationDate,
      LocalDate toCreationDate,
      LocalDate fromUpdateDate,
      LocalDate toUpdateDate);
}
