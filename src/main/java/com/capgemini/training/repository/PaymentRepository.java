package com.capgemini.training.repository;

import com.capgemini.training.model.Payment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

  @Query(value = "SELECT p FROM Payment p WHERE p.customer.customerId = ?1")
  List<Payment> findPaymentsByCustomerId(String customerId);
}
