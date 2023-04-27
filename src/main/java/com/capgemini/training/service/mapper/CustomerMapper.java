package com.capgemini.training.service.mapper;

import com.capgemini.training.model.CustomerDetails;
import com.capgemini.training.repository.entity.CustomerEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CustomerMapper {

  public CustomerDetails toCustomerDetails(CustomerEntity customer) {
    return CustomerDetails.builder()
        .customerId(customer.getCustomerId())
        .documentType(customer.getDocumentType())
        .documentNumber(customer.getDocumentNumber())
        .name(customer.getName())
        .surName(customer.getSurname())
        .lastName(customer.getLastname())
        .country(customer.getCountry())
        .telephone(customer.getTelephone().toString())
        .creationDate(customer.getCreationDate().toLocalDate())
        .updateDate(customer.getUpdatedDate().toLocalDate())
        .build();
  }

  public CustomerEntity toCustomerEntity(CustomerDetails customerDetails) {

    return CustomerEntity.builder()
        .customerId(customerDetails.getCustomerId())
        .documentType(customerDetails.getDocumentType())
        .documentNumber(customerDetails.getDocumentNumber())
        .name(customerDetails.getName())
        .surname(customerDetails.getSurName())
        .lastname(customerDetails.getLastName())
        .country(customerDetails.getCountry())
        .telephone(Integer.valueOf(customerDetails.getTelephone()))
        .build();
  }
}
