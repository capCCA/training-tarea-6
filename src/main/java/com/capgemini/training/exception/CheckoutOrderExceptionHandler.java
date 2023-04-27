package com.capgemini.training.exception;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackages = "com.capgemini.training.controller")
@Order(Ordered.HIGHEST_PRECEDENCE)
@RequiredArgsConstructor
@Slf4j
public class CheckoutOrderExceptionHandler {

  private final String BODY_ERROR_MSG = "%s - %s";

  private ResponseEntity<String> createErrorMessageResponseEntity(
      HttpStatus httpStatus, final String description) {
    return ResponseEntity.status(httpStatus)
        .body(
            String.format(
                BODY_ERROR_MSG,
                httpStatus,
                ObjectUtils.defaultIfNull(description, httpStatus.getReasonPhrase())));
  }

  /**
   * Beneficiary not found.
   *
   * @param exception exception
   * @return String
   */
  @ExceptionHandler(BeneficiaryNotFoundException.class)
  public ResponseEntity<String> beneficiaryNotFoundException(
      BeneficiaryNotFoundException exception) {
    log.info("Exception: ", exception);
    return createErrorMessageResponseEntity(NOT_FOUND, exception.getMessage());
  }

  /**
   * Customer not found.
   *
   * @param exception exception
   * @return String
   */
  @ExceptionHandler(CustomerNotFoundException.class)
  public ResponseEntity<String> customerNotFoundException(CustomerNotFoundException exception) {
    log.info("Exception: ", exception);
    return createErrorMessageResponseEntity(NOT_FOUND, exception.getMessage());
  }

  /**
   * Payment not found.
   *
   * @param exception exception
   * @return ErrorMessage
   */
  @ExceptionHandler(PaymentNotFoundException.class)
  public ResponseEntity<String> paymentNotFoundException(PaymentNotFoundException exception) {
    log.info("Exception: ", exception);
    return createErrorMessageResponseEntity(NOT_FOUND, exception.getMessage());
  }
}
