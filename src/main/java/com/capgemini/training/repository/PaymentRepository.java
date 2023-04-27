package com.capgemini.training.repository;

import com.capgemini.training.repository.entity.PaymentEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {
  /*
  //TODO falta añadir todos los filtros que puede tener un pago, por rango de amount, por rango de fechas, por tipo de pago, etc.
  @Query(value = "SELECT p FROM Payment p WHERE p.customer.customerId = ?1")*/
  List<PaymentEntity> getPayments(String customerId);
}
