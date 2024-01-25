package cl.springmachine.customer.api.rest.mappers;

import cl.springmachine.customer.api.rest.dtos.CustomerResponseDto;
import cl.springmachine.customer.api.rest.models.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerMapper {

    public CustomerResponseDto toCustomerResponseDto(Customer customer) {
        return CustomerResponseDto.builder()
                .id(customer.id().toString())
                .firstName(customer.firstName())
                .lastName(customer.lastName())
                .build();
    }

    public Iterable<CustomerResponseDto> toIterableCustomerResponseDto (Iterable<Customer> iterable) {
        List<CustomerResponseDto> list = new ArrayList<>();
        iterable.forEach(customer -> list.add(toCustomerResponseDto(customer)));
        return list;
    }
}
