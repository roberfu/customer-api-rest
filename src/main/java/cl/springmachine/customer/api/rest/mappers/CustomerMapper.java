package cl.springmachine.customer.api.rest.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import cl.springmachine.customer.api.rest.dtos.CustomerCreateRequestDto;
import cl.springmachine.customer.api.rest.dtos.CustomerResponseDto;
import cl.springmachine.customer.api.rest.models.Customer;

@Service
public class CustomerMapper {

	public CustomerResponseDto fromCustomerToCustomerResponseDto(Customer customer) {
		return CustomerResponseDto.builder().id(customer.getId().toString()).firstName(customer.getFirstName())
				.lastName(customer.getLastName()).email(customer.getEmail()).documentType(customer.getDocumentType())
				.documentId(customer.getDocumentId()).phone(customer.getPhone()).email(customer.getEmail())
				.addressId(customer.getAddressId()).invoiceDataId(customer.getInvoiceDataId())
				.customerType(customer.getCustomerType()).legalName(customer.getLegalName())
				.classification(customer.getClassification()).build();
	}

	public Iterable<CustomerResponseDto> fromIterableCustomertoIterableCustomerResponseDto(
			Iterable<Customer> iterable) {
		List<CustomerResponseDto> list = new ArrayList<>();
		iterable.forEach(customer -> list.add(fromCustomerToCustomerResponseDto(customer)));
		return list;
	}

	public Customer fromCustomerCreateToCustomer(CustomerCreateRequestDto requestDto) {
		return Customer.builder().firstName(requestDto.getFirstName()).lastName(requestDto.getLastName())
				.email(requestDto.getEmail()).documentType(requestDto.getDocumentType())
				.documentId(requestDto.getDocumentId()).phone(requestDto.getPhone())
				.addressId(requestDto.getAddressId()).invoiceDataId(requestDto.getInvoiceDataId())
				.customerType(requestDto.getCustomerType()).legalName(requestDto.getLegalName())
				.classification(requestDto.getClassification()).build();
	}

}
