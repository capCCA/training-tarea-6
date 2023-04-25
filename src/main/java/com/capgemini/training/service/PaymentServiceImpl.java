package com.capgemini.training.service;

import com.capgemini.training.exception.PaymentException;
import com.capgemini.training.model.Beneficiary;
import com.capgemini.training.model.Customer;
import com.capgemini.training.model.Enum.PaymentType;
import com.capgemini.training.model.Payment;
import com.capgemini.training.model.dto.PaymentRequest;
import com.capgemini.training.repository.BeneficiaryRepository;
import com.capgemini.training.repository.CustomerRepository;
import com.capgemini.training.repository.PaymentRepository;
import com.capgemini.training.service.interfaces.PaymentService;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

  @Autowired private PaymentRepository paymentRepo;

  @Autowired private CustomerRepository customerRepo;

  @Autowired private BeneficiaryRepository beneficiaryRepo;

  @Override
  public List<Payment> findPaymentsByCustomerId(String customerId) {
    return paymentRepo.findPaymentsByCustomerId(customerId);
  }

  @Override
  public Payment updatePayment(PaymentRequest paymentRequest) {
    Optional<Payment> paymentOp = this.paymentRepo.findById(paymentRequest.getPaymentId());

    if (!paymentOp.isPresent()) {
      throw new PaymentException(
          "Payment id : " + paymentRequest.getPaymentId() + "does not exist");
    }

    Payment paymentToSave = paymentOp.get();
    paymentToSave.setAmount(paymentRequest.getAmount());
    //paymentToSave.setPaymentType(PaymentType.valueOf(paymentRequest.getPaymentType()));
    paymentToSave.setUpdated_date(LocalDate.now());
    return this.paymentRepo.save(paymentToSave);
  }

  @Override
  public Payment createPayment(PaymentRequest paymentRequest) {
    Optional<Customer> customerOp = this.customerRepo.findById(paymentRequest.getCustomerId());
    Optional<Beneficiary> beneficiaryOp =
        this.beneficiaryRepo.findById(Long.valueOf(paymentRequest.getBeneficiaryId()));

    if (!(customerOp.isPresent() && beneficiaryOp.isPresent())) {
      throw new PaymentException(
          "Customer id: "
              + paymentRequest.getCustomerId()
              + " and Beneficiary id: "
              + paymentRequest.getBeneficiaryId()
              + " does not exist");
    }
    Payment paymentToSave =
        Payment.builder()
            //.paymentType(PaymentType.valueOf(paymentRequest.getPaymentType()))
            .amount(paymentRequest.getAmount())
            .creation_date(LocalDate.now())
            .customer(customerOp.get())
            .beneficiary(beneficiaryOp.get())
            .build();
    return this.paymentRepo.save(paymentToSave);
  }
}
