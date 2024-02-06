package cl.springmachine.customer.api.rest.services;

import cl.springmachine.customer.api.rest.dtos.CustomerCreateRequestDto;
import cl.springmachine.customer.api.rest.dtos.CustomerResponseDto;
import cl.springmachine.customer.api.rest.dtos.CustomerUpdateRequestDto;

public interface CustomerService {

	Iterable<CustomerResponseDto> findCustomers();

	CustomerResponseDto saveCustomer(CustomerCreateRequestDto requestDto);

	void updateCustomer(CustomerUpdateRequestDto requestDto, Integer id);

	void deleteCustomer(Integer id);
}
