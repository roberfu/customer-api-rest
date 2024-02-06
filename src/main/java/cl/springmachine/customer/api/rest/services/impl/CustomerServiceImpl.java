package cl.springmachine.customer.api.rest.services.impl;

import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.springmachine.customer.api.rest.dtos.CustomerCreateRequestDto;
import cl.springmachine.customer.api.rest.dtos.CustomerResponseDto;
import cl.springmachine.customer.api.rest.dtos.CustomerUpdateRequestDto;
import cl.springmachine.customer.api.rest.mappers.CustomerMapper;
import cl.springmachine.customer.api.rest.models.Customer;
import cl.springmachine.customer.api.rest.repositories.CustomerRepository;
import cl.springmachine.customer.api.rest.services.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	private final CustomerRepository customerRepository;

	private final CustomerMapper customerMapper;

	public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
		this.customerRepository = customerRepository;
		this.customerMapper = customerMapper;
	}

	@Override
	public Iterable<CustomerResponseDto> findCustomers() {
		return customerMapper.fromIterableCustomertoIterableCustomerResponseDto(customerRepository.findAll());
	}

	@Override
	@Transactional
	public CustomerResponseDto saveCustomer(CustomerCreateRequestDto requestDto) {
		Customer customer = customerRepository.save(customerMapper.fromCustomerCreateToCustomer(requestDto));
		return customerMapper.fromCustomerToCustomerResponseDto(customer);
	}

	@Override
	@Transactional
	public void updateCustomer(CustomerUpdateRequestDto requestDto, Integer id) {
		Optional<Customer> optional = customerRepository.findById(id);
		if (optional.isPresent()) {
			Customer customer = optional.get();
			updateFieldIfNotNull(requestDto.getFirstName(), customer::setFirstName);
			updateFieldIfNotNull(requestDto.getLastName(), customer::setLastName);
			updateFieldIfNotNull(requestDto.getDocumentType(), customer::setDocumentType);
			updateFieldIfNotNull(requestDto.getDocumentId(), customer::setDocumentId);
			updateFieldIfNotNull(requestDto.getPhone(), customer::setPhone);
			updateFieldIfNotNull(requestDto.getEmail(), customer::setEmail);
			updateFieldIfNotNull(requestDto.getAddressId(), customer::setAddressId);
			updateFieldIfNotNull(requestDto.getInvoiceDataId(), customer::setInvoiceDataId);
			updateFieldIfNotNull(requestDto.getCustomerType(), customer::setCustomerType);
			updateFieldIfNotNull(requestDto.getLegalName(), customer::setLegalName);
			updateFieldIfNotNull(requestDto.getClassification(), customer::setClassification);
			customerRepository.save(customer);

		}
	}

	@Override
	@Transactional
	public void deleteCustomer(Integer id) {
		customerRepository.deleteById(id);
	}

	private <T> void updateFieldIfNotNull(T value, Consumer<T> setter) {
		if (value != null) {
			setter.accept(value);
		}
	}
}
