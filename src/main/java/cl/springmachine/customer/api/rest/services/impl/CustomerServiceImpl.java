package cl.springmachine.customer.api.rest.services.impl;

import cl.springmachine.customer.api.rest.dtos.CustomerCreateRequestDto;
import cl.springmachine.customer.api.rest.dtos.CustomerResponseDto;
import cl.springmachine.customer.api.rest.mappers.CustomerMapper;
import cl.springmachine.customer.api.rest.models.Customer;
import cl.springmachine.customer.api.rest.repositories.CustomerRepository;
import cl.springmachine.customer.api.rest.services.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public Iterable<CustomerResponseDto> getAllCustomers() {
        return customerMapper.toIterableCustomerResponseDto(customerRepository.findAll());
    }

    @Override
    @Transactional
    public CustomerResponseDto saveCustomer(CustomerCreateRequestDto requestDto) {
        Customer customer = customerRepository.save(customerMapper.toCustomer(requestDto));
        return customerMapper.toCustomerResponseDto(customer);
    }
}
