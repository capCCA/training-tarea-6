package com.capgemini.training.exception;

public class CustomerNotFoundException extends RuntimeException {

  public CustomerNotFoundException(String msg) {
    super(msg);
  }
}
