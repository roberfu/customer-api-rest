package cl.springmachine.customer.api.rest.services.impl;

import cl.springmachine.customer.api.rest.dtos.CustomerResponseDto;
import cl.springmachine.customer.api.rest.mappers.CustomerMapper;
import cl.springmachine.customer.api.rest.repositories.CustomerRepository;
import cl.springmachine.customer.api.rest.services.CustomerService;
import org.springframework.stereotype.Service;

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
}
