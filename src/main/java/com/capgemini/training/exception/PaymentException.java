package com.capgemini.training.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter@AllArgsConstructor
public class PaymentException extends RuntimeException{

  private final String message;

}
