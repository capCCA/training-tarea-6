package com.capgemini.training.controller;

import com.capgemini.training.model.dto.PaymentRequest;
import com.capgemini.training.model.Payment;
import com.capgemini.training.service.interfaces.PaymentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment/v1")
public class PaymentController {

  @Autowired
  private PaymentService paymentService;

  @GetMapping("/payments/{customerId}")
  public ResponseEntity<List<Payment>> findPaymentByCustomerId(@PathVariable String customerId){
    return new ResponseEntity<>(this.paymentService.findPaymentsByCustomerId(customerId), HttpStatus.OK);
  }

  @PutMapping("/{paymentId}")
  public ResponseEntity<Payment> updatePayment(@RequestBody PaymentRequest paymentRequest){
    return new ResponseEntity<>(this.paymentService.updatePayment(paymentRequest), HttpStatus.OK);
  }

  @PostMapping("/create")
  public ResponseEntity<Payment> createPayment(@RequestBody PaymentRequest paymentRequest){
    return new ResponseEntity<>(this.paymentService.createPayment(paymentRequest), HttpStatus.CREATED);
  }


}
