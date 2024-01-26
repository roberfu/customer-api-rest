package cl.springmachine.customer.api.rest.services;

import cl.springmachine.customer.api.rest.dtos.CustomerCreateRequestDto;
import cl.springmachine.customer.api.rest.dtos.CustomerResponseDto;

public interface CustomerService {

    Iterable<CustomerResponseDto> getAllCustomers();

    CustomerResponseDto saveCustomer(CustomerCreateRequestDto requestDto);
}
